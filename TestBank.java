import java.math.BigInteger;
import java.util.HashMap;

public class TestBank implements Bank {
    HashMap<String, String[]> cardAccountsTestDB = new HashMap<>();
    HashMap<String, Integer> cardPINTestDB = new HashMap<>();
    HashMap<String, BigInteger> accountBalanceTestDB = new HashMap<>();

    public TestBank() {
        cardAccountsTestDB.put("1111 1111 1111 1111", new String[]{"111-111-111", "111-111-222"});
        cardAccountsTestDB.put("2222 2222 2222 2222", new String[]{"222-222-222", "222-222-333"});
        cardAccountsTestDB.put("3333 3333 3333 3333", new String[]{"333-333-333", "333-333-444"});

        cardPINTestDB.put("1111 1111 1111 1111", 1234);
        cardPINTestDB.put("2222 2222 2222 2222", 5678);
        cardPINTestDB.put("3333 3333 3333 3333", 9012);

        accountBalanceTestDB.put("111-111-111", BigInteger.valueOf(100));
        accountBalanceTestDB.put("111-111-222", BigInteger.valueOf(1502));
        accountBalanceTestDB.put("222-222-222", BigInteger.valueOf(5030));
        accountBalanceTestDB.put("222-222-333", BigInteger.valueOf(10));
        accountBalanceTestDB.put("333-333-333", BigInteger.valueOf(8));
        accountBalanceTestDB.put("333-333-444", BigInteger.valueOf(10235));
    }

    @Override
    public boolean isValidCard(String card_number) {
        return cardAccountsTestDB.containsKey(card_number);
    }

    @Override
    public boolean isValidPIN(String card_number, int pin) {
        if (!cardPINTestDB.containsKey(card_number)) {
            return false;
        }
        else {
            return (cardPINTestDB.get(card_number) == pin);
        }
    }

    @Override
    public String[] getAccounts(String card_number) {
        if (!cardAccountsTestDB.containsKey(card_number)) return new String[0];
        else return cardAccountsTestDB.get(card_number);
    }

    @Override
    public BigInteger getBalance(String account) {
        if (!accountBalanceTestDB.containsKey(account)) return new BigInteger("-1");
        else return accountBalanceTestDB.get(account);
    }

    @Override
    public BigInteger deposit(String account, BigInteger amount) {
        if (!accountBalanceTestDB.containsKey(account)) {
            return new BigInteger("-1");
        }
        else {
            BigInteger newBalance = accountBalanceTestDB.get(account).add(amount);
            accountBalanceTestDB.put(account, newBalance);
            return newBalance;
        }
    }

    @Override
    public boolean withdraw(String account, BigInteger amount) {
        if (!accountBalanceTestDB.containsKey(account)) {
            return false;
        }
        else {
            if (accountBalanceTestDB.get(account).compareTo(amount) < 0) return false;
            BigInteger newBalance = accountBalanceTestDB.get(account).subtract(amount);
            accountBalanceTestDB.put(account, newBalance);
            return true;
        }
    }
}