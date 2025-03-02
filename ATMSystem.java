import java.util.Scanner;

// Bank Account Class
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            System.out.println("Invalid initial balance! Setting balance to rs0.");
            this.balance = 0;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited rs" + amount);
        } else {
            System.out.println("Invalid deposit amount! Please enter a positive number.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn rs" + amount);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient balance! Your balance is rs" + balance);
        } else {
            System.out.println("Invalid withdrawal amount! Please enter a positive number.");
        }
        return false;
    }
}

// ATM Machine Class
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); // Clear invalid input
                continue;
            }

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private void withdraw() {
        System.out.print("Enter withdrawal amount:");
        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid amount! Please enter a valid number.");
            scanner.next();
            return;
        }
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }

    private void deposit() {
        System.out.print("Enter deposit amount:");
        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid amount! Please enter a valid number.");
            scanner.next();
            return;
        }
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    private void checkBalance() {
        System.out.println("Your current balance is: rs" + account.getBalance());
    }
}

// Main Class
public class ATMSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your initial account balance:");
        while (!scanner.hasNextDouble()) {  // Input validation for numbers
            System.out.println("Invalid input! Please enter a valid number.");
            scanner.next();
        }
        double initialBalance = scanner.nextDouble();

        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(userAccount);
        atm.start();

        scanner.close();
    }
}
