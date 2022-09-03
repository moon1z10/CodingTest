import java.math.BigInteger;

public interface Bank {
    boolean isValidCard(String card_number);
    boolean isValidPIN(String card_number, int pin);
    String[] getAccounts(String card_number);
    BigInteger getBalance(String account);
    //  return the balance after deposit
    BigInteger deposit(String account, BigInteger amount);
    //  return the result of withdraw
    boolean withdraw(String account, BigInteger amount);
}
