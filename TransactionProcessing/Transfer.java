package TransactionProcessing;

import Account.InstaPayAccount;
import Provider.*;
import java.util.Scanner;

public class Transfer {
    private InstaPayAccount source;
    private Recipient distination;
    public Transfer(InstaPayAccount source){
        this.source=source;
    }
    public void transfer(){
       
        String className = source.getAccountType();
       

        try {
            Class<?> clazz = Class.forName(className); 
            
            Object obj = clazz.getDeclaredConstructor().newInstance();
            Provider provider =  (Provider) obj;
        
        Scanner scanner = new Scanner(System.in);
        while(true){
        System.out.print("1-Transfer to InstapayUser.\n2-Transfer to BankAccount.\n3-Transfer to Wallet.\n4-Pay pills.\n5-Quit.\nPlease enter your choice");
      
        String choice = scanner.nextLine();
        
        if(choice.equals("1")){
            //unfinsihed business
            
        }
        else  if(choice.equals("2")){
            System.out.print("PLease enter the Phone number of the Bank Account you want to transfer to : ");
            String ID=scanner.nextLine();
            System.out.print("PLease enter the amount you want to transfer : ");
            double balance=scanner.nextDouble();
            scanner.nextLine();
            
            if(provider.getBalance(source.getPhoneNumber())>=balance){
                provider.deduceBalance(balance, source.getPhoneNumber());
                this.distination=new BankAccount();
                if(distination.check(ID)){
                    distination.pay(balance, ID);
                }else{
                    System.out.println("there is no such Bank Account.");
                    
                }
            }else {
                System.out.println("not enouph balance");
            }

        } 
        else  if(choice.equals("3")){
            System.out.print("PLease enter the Phone number of the Bank Account you want to transfer to : ");
            String ID=scanner.nextLine();
            System.out.print("PLease enter the amount you want to transfer : ");
            double balance=scanner.nextDouble();
            scanner.nextLine();
            
            if(provider.getBalance(source.getPhoneNumber())>=balance){
                provider.deduceBalance(balance, source.getPhoneNumber());
                this.distination=new WalletAccount();
                if(distination.check(ID)){
                    distination.pay(balance, ID);
                }else{
                    System.out.println("there is no such Wallet Account.");
                    
                }
            }else {
                System.out.println("not enouph balance");
            }

        }
        else  if(choice.equals("4")){
             //unfinsihed business
             
             
        }
        else {
            
            break ;
        }
    }
    scanner.close();
    } catch ( ReflectiveOperationException e) {
        e.printStackTrace();
    }
    }
}

