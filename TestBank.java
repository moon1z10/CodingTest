import java.util.HashMap;

public class TestBank implements Bank {
    HashMap<String, String[]> cardAccountsTestDB = new HashMap<>();
    HashMap<String, Integer> cardPINTestDB = new HashMap<>();
    HashMap<String, Integer> accountBalanceTestDB = new HashMap<>();

    public TestBank() {
        cardAccountsTestDB.put("1111 1111 1111 1111", new String[]{"111-111-111", "111-111-222"});
        cardAccountsTestDB.put("2222 2222 2222 2222", new String[]{"222-222-222", "222-222-333"});
        cardAccountsTestDB.put("3333 3333 3333 3333", new String[]{"333-333-333", "333-333-444"});

        cardPINTestDB.put("1111 1111 1111 1111", 1234);
        cardPINTestDB.put("2222 2222 2222 2222", 5678);
        cardPINTestDB.put("3333 3333 3333 3333", 9012);

        accountBalanceTestDB.put("111-111-111", 100);
        accountBalanceTestDB.put("111-111-222", 1502);
        accountBalanceTestDB.put("222-222-222", 5030);
        accountBalanceTestDB.put("222-222-333", 10);
        accountBalanceTestDB.put("333-333-333", 8);
        accountBalanceTestDB.put("333-333-444", 10235);
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
    public int getBalance(String account) {
        if (!accountBalanceTestDB.containsKey(account)) return -1;
        else return accountBalanceTestDB.get(account);
    }

    @Override
    public int deposit(String account, int amount) {
        if (!accountBalanceTestDB.containsKey(account)) {
            return -1;
        }
        else {
            int newBalance = accountBalanceTestDB.get(account) + amount;
            accountBalanceTestDB.put(account, newBalance);
            return newBalance;
        }
    }

    @Override
    public boolean withdraw(String account, int amount) {
        if (!accountBalanceTestDB.containsKey(account)) {
            return false;
        }
        else {
            if (accountBalanceTestDB.get(account) < amount) return false;
            int newBalance = accountBalanceTestDB.get(account) - amount;
            accountBalanceTestDB.put(account, newBalance);
            return true;
        }
    }
}