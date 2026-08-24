public class Main {
    public static void main(String[] args) {
        System.out.println("Hello from SimpleSingleTon!");

        SimpleSingleTon SimpleSingleTon1 = SimpleSingleTon.getInstance();
        System.out.println("SimpleSingleTon instance 1: " + SimpleSingleTon1);

        LazySingleTon LazySingleTon1 = LazySingleTon.getInstance();
        System.out.println("LazySingleTon instance 1: " + LazySingleTon1);
    }
}

class SimpleSingleTon {
    private static SimpleSingleTon instance = new SimpleSingleTon();

    private SimpleSingleTon() {
    }

    public static SimpleSingleTon getInstance() {
        return instance;
    }
}

class LazySingleTon {
    private static LazySingleTon instance;

    private LazySingleTon() {
    }

    public static LazySingleTon getInstance() {
        if (instance == null) {
            instance = new LazySingleTon();
        }
        return instance;
    }
}