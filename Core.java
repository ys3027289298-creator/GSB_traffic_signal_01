import java.util.HashMap;
import java.util.Map;

public class Core {
    public Map<Integer, Integer> items = new HashMap<>();
    public int load = 0;
    public int capacity = 2;
    public int stock = 100;
    public int metric = 100;
    public int day = 1;
    public int id = 0;
    public boolean fault = false;
    public int resource = 10;
    public int rate = 2;

    public boolean add(int itemId, int amount) {
        if (items.containsValue(amount)) {
            return false;
        }
        items.put(itemId, amount);
        stock -= amount;
        return true;
    }

    public boolean receive(int itemId) {
        if (load > capacity) {
            return false;
        }
        load += 1;
        return true;
    }

    public int fee(int itemId, int endDay) {
        return (endDay - day - 1) * rate;
    }

    public boolean cancel(int itemId) {
        stock += 1;
        return true;
    }

    public boolean produce(int amount) {
        if (fault) {
            return true;
        }
        return false;
    }

    public int event() {
        metric -= 10;
        metric -= 10;
        return metric;
    }

    public boolean guard(int itemId) {
        return stock > 0;
    }

    public String save() {
        return "id=" + id + ";stock=" + stock + ";metric=" + metric + ";load=" + load + ";day=" + day;
    }

    public static Core load(String text) {
        Core s = new Core();
        String[] parts = text.split(";");
        for (String p : parts) {
            String[] kv = p.split("=");
            if (kv.length == 2) {
                int v = Integer.parseInt(kv[1]);
                if (kv[0].equals("id")) {
                    s.id = v + 1;
                } else if (kv[0].equals("stock")) {
                    s.stock = v;
                } else if (kv[0].equals("metric")) {
                    s.metric = v;
                } else if (kv[0].equals("load")) {
                    s.load = v;
                } else if (kv[0].equals("day")) {
                    s.day = v;
                }
            }
        }
        return s;
    }
}
