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
        Provider provider;
        if(className.equalsIgnoreCase("Bank")){
            provider= new Bank();
        }else if(className.equalsIgnoreCase("Wallet")){
            provider= new Wallet();
        }
        else{
            System.out.println("Wrong Provider");
            return;
        }
       
        // try {
        //     ClassLoader classLoader = getClass().getClassLoader();
        //     Class<?> clazz = classLoader.loadClass(className);
    
    
            
            
            // Object obj = clazz.getDeclaredConstructor().newInstance();
            // Provider provider =  (Provider) obj;
        
        Scanner scanner = new Scanner(System.in);
        while(true){
        System.out.print("1-Transfer to InstapayUser.\n2-Transfer to BankAccount.\n3-Transfer to Wallet.\n4-Pay pills.\n5-Quit.\nPlease enter your choice: ");
      
        String choice = scanner.nextLine();
        
        if(choice.equals("1")){
            System.out.print("PLease enter the user name of the instapay Account you want to transfer to: ");
            String ID=scanner.nextLine();
            System.out.print("PLease enter the amount you want to transfer: ");
            double balance=scanner.nextDouble();
            scanner.nextLine();
            
            if(provider.getBalance(source.getPhoneNumber())>=balance){
                
                this.distination=new InstapayAccountPayment();
                if(distination.check(ID)){
                    provider.deduceBalance(balance, source.getPhoneNumber());
                    distination.pay(balance, ID);
                }else{
                    System.out.println("there is no such Bank Account.");
                    
                }
            }else {
                System.out.println("not enough balance");
            }

            
        }
        else  if(choice.equals("2")){
           if(provider instanceof BankMarker){
            System.out.print("PLease enter the Phone number of the Bank Account you want to transfer to : ");
            String ID=scanner.nextLine();
            System.out.print("PLease enter the amount you want to transfer : ");
            double balance=scanner.nextDouble();
            scanner.nextLine();
            
            if(provider.getBalance(source.getPhoneNumber())>=balance){
                
                this.distination=new BankAccount();
                if(distination.check(ID)){
                    provider.deduceBalance(balance, source.getPhoneNumber());
                    distination.pay(balance, ID);
                }else{
                    System.out.println("there is no such Bank Account.");
                    
                }
            }else {
                System.out.println("not enough balance");
            }

           }
           else {
            System.out.println("you can not transfer to Bank Account when your InstapayAccount not based on Bank Account.\n");
           }
        } 
        else  if(choice.equals("3")){
            System.out.print("PLease enter the Phone number of the Bank Account you want to transfer to : ");
            String ID=scanner.nextLine();
            System.out.print("PLease enter the amount you want to transfer : ");
            double balance=scanner.nextDouble();
            scanner.nextLine();
            
            if(provider.getBalance(source.getPhoneNumber())>=balance){
               
                this.distination=new WalletAccount();
                if(distination.check(ID)){
                    provider.deduceBalance(balance, source.getPhoneNumber());
                    distination.pay(balance, ID);
                }else{
                    System.out.println("there is no such Wallet Account.");
                    
                }
            }else {
                System.out.println("not enouph balance");
            }

        }
        else  if(choice.equals("4")){
             while(true){
                System.out.print("1-Gas.\n2-Water.\n3-Electricity.\n4-Quit.\nplease enter your choice : ");
                String c=scanner.nextLine();
                distination=new BillPayment();
                String temp;
                if(c.equals("1")){
                     temp= source.getAccountType()+" "+"GasBill";
                    
                }
                else if(c.equals("2")){
                     temp= source.getAccountType()+" "+"WaterBill";
                    
                }
                else if(c.equals("3")){
                     temp= source.getAccountType()+" "+"ElectricityBill";
                   
                }
                else if(c.equals("4")){
                    break;
                }
                else {
                    System.out.println("wording choice.");
                    break;
                }
                if(distination.check(temp)){
                    System.out.print("please enter ID of the bill you wanna pay: ");
                    String ID=scanner.nextLine();
                    System.out.print("please enter amount of money you wanna pay: ");
                    double amount=scanner.nextDouble();
                    scanner.nextLine();
                    provider.deduceBalance(amount, source.getPhoneNumber());
                    distination.pay(amount, ID);
                }
             }
             
             
        }
        else {
            
            break ;
        }
    }
    scanner.close();
    // } catch ( ReflectiveOperationException e) {
    //     e.printStackTrace();
    // }
    }
}

