// create simple bank account class. the class should encapsulate thr following details:
// account holder name, account number, balance.
// implement following functionality using getters and setters
// 1. get account number and balance
// 2. deposit money only if amount is positive
// 3. withdraw money only if sufficient balance is available
// 4. print account summary

import java.util.Scanner;

public class BankAccount {

    private String accountHolderName;
    private String accountNumber;
    private double balance;

    public BankAccount(String accountHolderName, String accountNumber, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            System.out.println("Initial balance cannot be negative. Setting to 0.");
            this.balance = 0;
        }
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposit of " + amount + " successful. New balance: " + this.balance);
            return true;
        } else {
            System.out.println("Deposit amount must be positive.");
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        }
        if (this.balance >= amount) {
            this.balance -= amount;
            System.out.println("Withdrawal of " + amount + " successful. New balance: " + this.balance);
            return true;
        } else {
            System.out.println("Insufficient balance. Available balance: " + this.balance);
            return false;
        }
    }

    public void printAccountSummary() {
        System.out.println("\n--- Account Summary ---");
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Account Holder Name:");
        String name = scanner.nextLine();

        System.out.println("Enter Account Number:");
        String accNum = scanner.nextLine();

        System.out.println("Enter Initial Balance:");
        double initialBal = scanner.nextDouble();

        BankAccount myAccount = new BankAccount(name, accNum, initialBal);
        myAccount.printAccountSummary();

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Print Account Summary");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depAmount = scanner.nextDouble();
                    myAccount.deposit(depAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withAmount = scanner.nextDouble();
                    myAccount.withdraw(withAmount);
                    break;
                case 3:
                    myAccount.printAccountSummary();
                    break;
                case 4:
                    System.out.println("Exiting application. Thank you!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
