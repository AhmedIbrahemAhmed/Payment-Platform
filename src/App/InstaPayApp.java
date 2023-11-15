package App;

import Account.InstaPayAccount;
import TransactionProcessing.Transfer;
import Provider.*;
import Registration.Login;
import Registration.Signup;
import java.util.Scanner;

public class InstaPayApp {
    private final Scanner scan = new Scanner(System.in);
    
    public void run(){
    boolean loop = true;
        while (loop) {
            System.out.println("------Welcome To InstaPay------\n\n");
            System.out.println("Choose One Of The Following Options:");
            System.out.println("1.Register");
            System.out.println("2.Login");
            System.out.println("3.Exit");
            System.out.print("-->");
            int choice = Integer.parseInt(scan.nextLine());
            switch (choice) {
                case 1 -> registerInterface();
                case 2 -> loginInterface();
                case 3 ->  loop = false;
                default -> System.out.println("Invalid choice");
            }
        }
        scan.close();
    }

    private void registerInterface() {
        boolean registered = false;
        do {
            try {
                System.out.print("Enter username (has to be unique): ");
                String username = scan.nextLine();
                System.out.print("Enter password: ");
                String password = scan.nextLine();
                System.out.print("Enter your display name: ");
                String fullName = scan.nextLine();
                System.out.print("Enter your phone number: ");
                String phoneNum = scan.nextLine();
                System.out.println("Your phone number is registered with:");
                System.out.println("1.Bank");
                System.out.println("2.Online Wallet");
                System.out.println("-->");
                int accountType = Integer.parseInt(scan.nextLine());
            
                Signup signup = new Signup();
                int otp = signup.otp(phoneNum);
                System.out.print("your otp: ");
                System.out.println(otp);
                System.out.println("confirm otp: ");
                int userOtp = scan.nextInt();

                switch (accountType) {
                    case 1:
                        registered = signup.register(username, password, fullName, "Bank", phoneNum, otp, userOtp);
                        break;
                    case 2:
                         registered = signup.register(username, password, fullName, "Wallet", phoneNum, otp, userOtp);
                        break;
                    default:
                        System.out.println("Invalid choice!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (!registered);
    }

    private void loginInterface() {
        InstaPayAccount account = null;
        do {
            try {
                System.out.print("Enter username: ");
                String username = scan.nextLine();
                System.out.print("Enter password: ");
                String password = scan.nextLine();

                Login login = new Login();
                account = login.login(username, password);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (account == null);
        mainInterface(account);
    }


    private void mainInterface(InstaPayAccount account){
        boolean loop = true;
        System.out.println("------Welcome "+account.getFullName()+" To InstaPay------\n\n");
        while (loop){
            System.out.println("Choose One Of The Following Options:");
            System.out.println("1.Make a Transaction");
            System.out.println("2.Display balance");
            System.out.println("3.logout");
            System.out.print("-->");
            int choice = Integer.parseInt(scan.nextLine());

            switch(choice){
                case 1:
                    Transfer transfer = new Transfer(account);
                    transfer.transfer();
                    break;

                case 2:
                    Provider provider;
                    double balance;
                    if (account.getAccountType().equalsIgnoreCase("bank"))
                        provider = new Bank();
                    else
                        provider = new Wallet();
                    balance = provider.getBalance(account.getPhoneNumber());
                    System.out.println(account.getFullName()+"'s balance: "+balance);
                    break;
                case 3:
                    System.out.println("Logged out successfully. Goodbye!");
                    loop = false;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }
}



