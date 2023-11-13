import java.util.HashMap;

import Provider.* ;
public class Test {
    public static void main(String[] args) {
        HashMap<String,Double> bankapis = new HashMap() ;
        HashMap<String,Double> walletapis = new HashMap() ;

        bankapis.put("01234567890", 1000.0);
        bankapis.put("02134567891",2000.0) ;
        bankapis.put("02154567891",3000.0) ;
        bankapis.put("02164567891",4000.0) ;
        bankapis.put("02174567891",5000.0) ;
        walletapis.put("021344267891",6000.0) ;
        walletapis.put("02124567891",7000.0) ;
        walletapis.put("021723567891",8000.0) ;
        walletapis.put("02194567891",9000.0) ;
        walletapis.put("021124567891",12000.0) ;

        Provider provider = new Bank() ;
        Provider provider1 = new Wallet() ;
        provider.deduceBalance(1000,"01234567890",bankapis);
        System.out.println(provider.getBalance("01234567890",bankapis));
        provider1.addBalance(1000,"021344267891",walletapis);

        System.out.println("Hello world!");
    }
}