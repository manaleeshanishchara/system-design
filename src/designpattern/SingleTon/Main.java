package designpattern.SingleTon;

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

class MethodSingleTon {
    private static MethodSingleTon instance;

    private MethodSingleTon() {
    }

    public static synchronized MethodSingleTon getInstance() {
        if (instance == null) {
            instance = new MethodSingleTon();
        }
        return instance;
    }
}

class DoubleCheckLockingSingleTon {
    private static volatile DoubleCheckLockingSingleTon instance;

    private DoubleCheckLockingSingleTon() {
    }

    public static DoubleCheckLockingSingleTon getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckLockingSingleTon.class) {
                if (instance == null) {
                    instance = new DoubleCheckLockingSingleTon();
                }
            }
        }
        return instance;
    }
}

class BillPughSingleTon {
    private BillPughSingleTon() {
    }

    private static class Holder {
        private static final BillPughSingleTon instance = new BillPughSingleTon();
    }

    public static BillPughSingleTon getInstance() {
        return Holder.instance;
    }
}

enum EnumSingleTon {
    INSTANCE;

    public void doSomething() {
        System.out.println("Doing something in EnumSingleTon");
    }

}// this need to check ENUM I need to understand.