package TransactionProcessing;

import ApplicationDB.*;
import Provider.*;

public class InstapayAccountPayment implements Recipient{
    @Override
    public boolean check(String ID) {
        InstaPayAccountDB Db =new InstaPayAccountDB();
        return Db.checkUsernameExist(ID);
        
    }
    @Override
    public void pay(double amount, String ID) {
        InstaPayAccountDB Db =new InstaPayAccountDB();
         String type=Db.getAccountType(ID);
         String phoneNumber=Db.getPhoneNumber(ID);
         Provider pro;
         if(type=="Bank"){
            pro= new Bank();
         }
         else if (type=="Wallet"){
            pro =new Wallet();
         }
         else {
            System.out.println("wrong Account type");
            return;
         }
         pro.addBalance(amount, phoneNumber);
    }
}
