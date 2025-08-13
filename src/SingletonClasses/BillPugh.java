package SingletonClasses;

public class BillPugh {
    private BillPugh() {
        // private constructor to prevent instantiation
    }

    private static class SingletonHelper {
        private static final BillPugh INSTANCE = new BillPugh();
    }

    public static BillPugh getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void displayMessage() {
        System.out.println("Bill Pugh Singleton Instance");
    }
}

/***
 * Lazy loaded as the inner class is not loaded until the getInstance method is called.
 * Thread-safe without synchronization as the classloader ensures that the instance is created only once.
 */