package TransactionProcessing;

import Provider.Wallet;

public class WalletAccount implements Recipient {
    public boolean check(String ID){
        Wallet reciever=new Wallet();
        return reciever.verify(ID);
    }
    public void pay(double amount, String ID) {
        Wallet reciever=new Wallet();
        reciever.addBalance(amount, ID);
    }
}
