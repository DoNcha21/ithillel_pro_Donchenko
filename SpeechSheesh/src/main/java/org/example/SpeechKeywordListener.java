package org.example;

import com.google.api.gax.rpc.BidiStream;
import com.google.cloud.speech.v1.*;
import com.google.protobuf.ByteString;

import javax.sound.sampled.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SpeechKeywordListener {

    private static final int SAMPLE_RATE = 16000; // Частота дискретизации
    private static final int BUFFER_SIZE = 4096; // Размер буфера

    public static void main(String[] args) {
        // Очередь для передачи аудиоданных
        BlockingQueue<byte[]> audioQueue = new LinkedBlockingQueue<>();

        // Запуск потока записи с микрофона
        Thread audioCaptureThread = new Thread(() -> {
            try {
                AudioFormat audioFormat = new AudioFormat(SAMPLE_RATE, 16, 1, true, false);
                DataLine.Info info = new DataLine.Info(TargetDataLine.class, audioFormat);
                TargetDataLine microphone = (TargetDataLine) AudioSystem.getLine(info);

                microphone.open(audioFormat);
                microphone.start();
                byte[] buffer = new byte[BUFFER_SIZE];
                System.out.println("Микрофон включён. Говорите...");

                while (true) {
                    int bytesRead = microphone.read(buffer, 0, buffer.length);
                    if (bytesRead > 0) {
                        audioQueue.add(buffer.clone());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        audioCaptureThread.setDaemon(true);
        audioCaptureThread.start();

        // Потоковое распознавание речи
        try (SpeechClient speechClient = SpeechClient.create()) {
            RecognitionConfig config = RecognitionConfig.newBuilder()
                    .setEncoding(RecognitionConfig.AudioEncoding.LINEAR16)
                    .setSampleRateHertz(SAMPLE_RATE)
                    .setLanguageCode("ru-RU")
                    .build();

            StreamingRecognitionConfig streamingConfig = StreamingRecognitionConfig.newBuilder()
                    .setConfig(config)
                    .setInterimResults(true) // Включить частичные результаты
                    .build();

            // Создание потокового вызова
            BidiStream<StreamingRecognizeRequest, StreamingRecognizeResponse> stream =
                    speechClient.streamingRecognizeCallable().call();

            // Поток для чтения результатов распознавания
            Thread responseReader = new Thread(() -> {
                try {
                    for (StreamingRecognizeResponse response : stream) {
                        for (StreamingRecognitionResult result : response.getResultsList()) {
                            if (result.getIsFinal()) {
                                System.out.println("Распознанный текст (финальный): " + result.getAlternatives(0).getTranscript());
                            } else {
                                System.out.println("Распознанный текст (частичный): " + result.getAlternatives(0).getTranscript());
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            responseReader.setDaemon(true);
            responseReader.start();

            // Чтение аудиоданных из очереди и отправка их на сервер
            while (true) {
                byte[] audioData = audioQueue.take(); // Получение данных из очереди
                StreamingRecognizeRequest request = StreamingRecognizeRequest.newBuilder()
                        .setAudioContent(ByteString.copyFrom(audioData))
                        .build();
                stream.send(request);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
