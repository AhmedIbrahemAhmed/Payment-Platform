package Provider;
import java.util.HashMap;

public class Bank implements Provider{

    @Override
    public boolean verify(String phoneNumber,HashMap<String,Double> bankAPIS) {
        for(String number: bankAPIS.keySet()){
            if(number == phoneNumber){
                return true ;
            }
        }
        return false ;

    }

    @Override
    public double getBalance(String phoneNumber,HashMap<String,Double> bankAPIS) {
        for (String number : bankAPIS.keySet()) {
            if (number == phoneNumber) {
                return bankAPIS.get(number);
            }
        }
        System.out.println("couldn't find that phone number");
        return 0 ;
    }

    @Override
    public void setBalance(double balance,String phoneNumber,HashMap<String,Double> bankAPIS) {
        for (String number : bankAPIS.keySet()) {
            if (number == phoneNumber) {
                bankAPIS.put(number, balance);
                return ;
            }
        }
        System.out.println("couldn't find that phone number");
    }

    @Override
    public void addBalance(double balance,String phoneNumber,HashMap<String,Double> bankAPIS) {
        for (String number : bankAPIS.keySet()) {
            if (number == phoneNumber) {
                bankAPIS.put(number, bankAPIS.get(number)+balance);
                return;
            }
        }
        System.out.println("couldn't find that phone number");
    }

    @Override
    public void deduceBalance(double balance,String phoneNumber,HashMap<String,Double> bankAPIS) {
        for (String number : bankAPIS.keySet()) {
            if (number == phoneNumber) {
                if (bankAPIS.get(number) >= balance) {
                    bankAPIS.put(number, bankAPIS.get(number) - balance);
                    return;
                } else {
                    System.out.println("no enough money to deduce");
                    return;
                }
            }
        }
        System.out.println("couldn't find that phone number");
    }
}
