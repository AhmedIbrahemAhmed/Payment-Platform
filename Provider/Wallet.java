package Provider;
import java.util.HashMap;

public class Wallet implements Provider{




    @Override
    public boolean verify(String phoneNumber,HashMap<String,Double> walletAPIS) {
        for(String number: walletAPIS.keySet()){
            if(number == phoneNumber){
                return true ;
            }
        }
        return false ;
    }

    @Override
    public double getBalance(String phoneNumber,HashMap<String,Double> walletAPIS) {
        for (String number : walletAPIS.keySet()) {
            if (number == phoneNumber) {
                return walletAPIS.get(number);
            }
        }
        return 0 ;
    }

    @Override
    public void  setBalance(double balance,String phoneNumber,HashMap<String,Double> walletAPIS) {
        for (String number : walletAPIS.keySet()) {
            if (number == phoneNumber) {
                walletAPIS.put(number, balance);
                return ;
            }
        }
        System.out.println("couldn't find that phone number");
    }

    @Override
    public void addBalance(double balance,String phoneNumber,HashMap<String,Double> walletAPIS) {
        for (String number : walletAPIS.keySet()) {
            if (number == phoneNumber) {
                walletAPIS.put(number, walletAPIS.get(number)+balance);
                return;
            }
        }
        System.out.println("couldn't find that phone number");

    }

    @Override
    public void deduceBalance(double balance,String phoneNumber,HashMap<String,Double> walletAPIS) {
        for (String number : walletAPIS.keySet()) {
            if (number == phoneNumber) {
                if (walletAPIS.get(number) >= balance) {
                    walletAPIS.put(number, walletAPIS.get(number) - balance);
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
