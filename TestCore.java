public class TestCore {
    static int failures = 0;

    public static void main(String[] args) {
        if (!test01()) { System.out.println("test01 FAIL"); failures++; }
        if (!test02()) { System.out.println("test02 FAIL"); failures++; }
        if (!test03()) { System.out.println("test03 FAIL"); failures++; }
        if (!test04()) { System.out.println("test04 FAIL"); failures++; }
        if (!test05()) { System.out.println("test05 FAIL"); failures++; }
        if (!test06()) { System.out.println("test06 FAIL"); failures++; }
        if (!test07()) { System.out.println("test07 FAIL"); failures++; }
        if (!test08()) { System.out.println("test08 FAIL"); failures++; }
        if (failures == 0) {
            System.out.println("all passed");
        } else {
            System.out.println(failures + " failures");
            System.exit(1);
        }
    }

    static boolean test01() {
        Core s = new Core();
        return s.add(1, 10) && !s.add(1, 20);
    }

    static boolean test02() {
        Core s = new Core();
        s.load = 2;
        return !s.receive(1);
    }

    static boolean test03() {
        Core s = new Core();
        return s.fee(1, 3) == 4;
    }

    static boolean test04() {
        Core s = new Core();
        s.add(1, 5);
        s.cancel(1);
        return s.stock == 100;
    }

    static boolean test05() {
        Core s = new Core();
        s.fault = true;
        return !s.produce(5);
    }

    static boolean test06() {
        Core s = new Core();
        s.event();
        return s.metric == 90;
    }

    static boolean test07() {
        Core s = new Core();
        s.resource = 0;
        return !s.guard(1);
    }

    static boolean test08() {
        Core s = new Core();
        s.id = 4;
        Core loaded = Core.load(s.save());
        return loaded.id == 4;
    }
}
