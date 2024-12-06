import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        //creating account
        Account account = new Account(1000.00);

        // Creating list of transactions
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(account, false, 200.00)); // Withdraw
        transactions.add(new Transaction(account, true, 500.00));  // Deposit
        transactions.add(new Transaction(account, false, 300.00)); // Withdraw

        // Create threads
        Thread thread1 = new Thread(transactions.get(0), "Thread 1");
        Thread thread2 = new Thread(transactions.get(1), "Thread 2");
        Thread thread3 = new Thread(transactions.get(2), "Thread 3");

        // Starting threads
        thread1.start();
        thread2.start();
        thread3.start();

        // waiting for threads to complete
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("A thread was interrupted");
        }


        // Printing final balance
        System.out.println("Final Balance: $" + account.getBalance());
    }
}


class Account {

    private double balance;


    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    //synchronized method for deposit
    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited: $" + amount + ", New Balance: $" + balance);
    }

    //synchronized method for withdraw
    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew: $" + amount + ", New Balance: $" + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " attempted to withdraw: $" + amount + ", Insufficient Funds. Balance: $" + balance);
        }
    }


    public double getBalance() {
        return balance;
    }
}

//implementing runabble class for run method
class Transaction implements Runnable {
    private Account account;
    private boolean _isDeposit;
    private double _amount;


    public Transaction(Account account, boolean isDeposit, double amount) {
        this.account = account;
        this._isDeposit = isDeposit;
        this._amount = amount;

    }

    @Override
    public void run() {
        System.out.println("Transaction started by " + Thread.currentThread().getName());
        if (_isDeposit) {
            account.deposit(_amount);
        } else {
            account.withdraw(_amount);
        }
        System.out.println("Transaction completed by " + Thread.currentThread().getName());
    }

}