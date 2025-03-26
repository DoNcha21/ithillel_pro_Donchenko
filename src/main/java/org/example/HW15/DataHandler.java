package HW15;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class DataHandler {
    Map<Integer, String> map = new DataRepository().getData();

    public String getAll() {
        StringBuilder sb = new StringBuilder();
        AtomicInteger count = new AtomicInteger(0);
        map.forEach((id, name) ->
                sb.append(String.format("%d) %d, %s%n",
                        count.incrementAndGet(), id, name)
                ));
        return "\nALL NAMES:\n" + sb.toString();
    }

    public String getById(int id) {
        if (map.containsKey(id)) {
            return "\nNAME: id " + id + ", " +
                    map.get(id);
        } else return "No data!";
    }
}