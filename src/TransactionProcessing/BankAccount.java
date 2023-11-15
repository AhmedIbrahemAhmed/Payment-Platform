package TransactionProcessing;

import Provider.Bank;

public class BankAccount implements Recipient {
    public boolean check(String ID){
        Bank reciever=new Bank();
        return reciever.verify(ID);
    }
    public void pay(double amount, String ID) {
        Bank reciever=new Bank();
        reciever.addBalance(amount, ID);
    }
}
