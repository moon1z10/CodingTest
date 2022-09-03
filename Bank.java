public interface Bank {
    boolean isValidCard(String card_number);
    boolean isValidPIN(String card_number, int pin);
    String[] getAccounts(String card_number);
    int getBalance(String account);
    //  return the balance after deposit
    int deposit(String account, int amount);
    //  return the result of withdraw
    boolean withdraw(String account, int amount);
}
