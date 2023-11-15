package TransactionProcessing;

public interface Recipient {
    public void pay(double amount,String ID);
    public boolean check(String ID);
} 