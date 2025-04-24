package locks;

import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private final ReentrantLock lock = new ReentrantLock();
    private double balance;
    private String owner;

    public BankAccount(String owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
    }

    // Outer method with lock
    public void transfer(BankAccount toAccount, double amount) {
        lock.lock();  // Acquire lock for this account
        System.out.println(Thread.currentThread().getName() +
                " acquired lock for " + owner + "'s account");

        try {
            // Simulate some processing
            Thread.sleep(100);

            // Nested lock - calling another synchronized method
            this.withdraw(amount);
            toAccount.deposit(amount);

            System.out.println("Transferred " + amount + " from " +
                    owner + " to " + toAccount.owner);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() +
                    " released lock for " + owner + "'s account");
        }
    }

    // Inner method with same lock
    public void withdraw(double amount) {
        lock.lock();  // Reentrant lock - same thread can acquire again
        try {
            if (balance >= amount) {
                balance -= amount;
                System.out.println(owner + " withdrew " + amount +
                        ". New balance: " + balance);
            } else {
                System.out.println(owner + " insufficient funds for withdrawal of " + amount);
            }
        } finally {
            lock.unlock();
        }
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            balance += amount;
            System.out.println(owner + " deposited " + amount +
                    ". New balance: " + balance);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("John", 1000);
        BankAccount account2 = new BankAccount("Mary", 1000);

        // Thread transferring from John to Mary
        new Thread(() -> account1.transfer(account2, 200)).start();

        // Thread transferring from Mary to John
        new Thread(() -> account2.transfer(account1, 300)).start();
    }
}

/*
* Timeline:
T1: lock.lock()       [Hold=1]
T1: withdraw()        [Hold=2 → Hold=1]
T1: transfer()        [Hold=0] → Lock released
                       ↓
T2: (Waiting) ──────► lock.lock()  [T2 now acquires lock]
*
* Reentrancy:

Same thread (T1) can acquire the lock multiple times.

Hold count tracks nested acquisitions.

Blocking Other Threads:

While T1 holds the lock (even with Hold=1), T2 cannot acquire it.

T2 blocks until Hold=0.

Fairness:

If ReentrantLock(true), longest-waiting thread gets priority.

Default is unfair (no guaranteed order).
* */

