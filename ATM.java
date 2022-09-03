import java.util.Scanner;

public class ATM {

    private static final int MAX_ENTERING_PIN_TRIAL = 5;
    private String card_number;
    private String account;
    private Bank bank;
    private String[] modes;

    Scanner scanner = new Scanner(System.in);

    public ATM() {
        init();
        this.bank = new TestBank();
    }

    public ATM(Bank bank) {
        init();
        this.bank = bank;
    }

    private void init() {
        this.card_number = "";
        this.account = "";
        this.modes = new String[]{"See Balance", "Deposit", "Withdraw"};
    }

    public void start() {
        init();

        while(true) {
            //  ATM should work permanently until power it off
            System.out.println("Please insert your card.");
            card_number = scanner.nextLine();
            if (card_number.trim().length() == 0) {
                card_number = scanner.nextLine();
            }

            if (bank.isValidCard(card_number)) {
                getPIN();
            } else {
                System.out.println("Invalid card number(" + card_number + "). Please input the correct card number.");
            }
        }
    }

    void getPIN() {
        for (int i = 0; i < MAX_ENTERING_PIN_TRIAL; i++) {
            System.out.println("Please enter the PIN.");
            int pin = scanner.nextInt();
            if (bank.isValidPIN(card_number, pin)) {
                String[] accounts = bank.getAccounts(card_number);
                if (accounts.length == 0) {
                    System.out.println("There's no account connected with your card. Please visit the bank.");
                } else {
                    selectAccount(accounts);
                }
                return ;
            } else {
                System.out.println("Wrong PIN number. Please try again.");
            }
        }
        System.out.println("You entered wrong PIN. No more try anymore. Please visit the bank.");
    }

    void selectAccount(String[] accounts) {
        System.out.println("Please select your account.");
        for (int i = 0; i < accounts.length; i++) {
            System.out.printf("%d: %s\n", (i+1), accounts[i]);
        }
        int account_index;
        while(true) {
            account_index = scanner.nextInt() - 1;
            if (0 <= account_index && account_index < accounts.length) break;
            System.out.println("Please select the account from the list.");
        }
        this.account = accounts[account_index];
        selectMode();
    }

    void selectMode() {
        System.out.println("Please select transaction you'd like to proceed.");
        for (int i = 0; i < modes.length; i++) {
            System.out.printf("%d: %s\n", (i+1), modes[i]);
        }
        int mode;
        while(true) {
            mode = scanner.nextInt() - 1;
            if (0 <= mode && mode < modes.length) break;
            System.out.println("Please select the transaction from the list.");
        }
        switch (mode) {
            case 0: seeBalance();   break;
            case 1: deposit();      break;
            case 2: withdraw();     break;
        }
    }

    void seeBalance() {
        int balance = bank.getBalance(account);
        if (balance < 0) {
            System.out.println("Something wrong with your account. Please visit the bank");
        } else {
            System.out.printf("Your balance : %d\nEnd the transaction.\n", balance);
        }
    }

    void deposit() {
        System.out.println("Please enter amount of money you'd like to deposit.");
        int amount = scanner.nextInt();
        if (amount < 0) {
            System.out.println("You cannot enter the negative amount.\nEnd the transaction");
            return;
        }
        int balance = bank.deposit(account, amount);
        if (balance < 0) {
            System.out.println("Something wrong with your account. Please visit the bank");
        } else {
            System.out.printf("Done to deposit. Your balance : %d\nEnd the transaction", balance);
        }
    }

    void withdraw() {
        System.out.println("Please enter amount of money you'd like to withdraw.");
        int amount = scanner.nextInt();
        if (amount < 0) {
            System.out.println("You cannot enter the negative amount.\nEnd the transaction");
            return;
        }
        boolean success = bank.withdraw(account, amount);
        if (success) {
            System.out.print("Done to withdraw. ");
            seeBalance();
        } else {
            System.out.println("Failed to withdraw. Something wrong with your account or balance.\nEnd the transaction");
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();    //  TestBank
        atm.start();
    }
}