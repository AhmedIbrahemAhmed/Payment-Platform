package App;

import java.util.Scanner;

public class InstapayApp {
    private final Scanner scan = new Scanner(System.in);
//    private InstapayAccount account;
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

                case 1:
                    doRegistration();
                    break;
                case 2:
                    doLogin();
                    break;
                case 3:
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void doRegistration() {
        Instapayaccount account = null;
        do {
            try {
                System.out.print("Enter username: ");
                String username = scan.nextLine();
                System.out.print("Enter password: ");
                String password = scan.nextLine();
                System.out.print("Enter your phone number: ");
                String phoneNum = scan.nextLine();
                System.out.print("Your phone number is registered with:\n1. Bank\n2. Online Wallet\n-->");
                int accountType = Integer.parseInt(scan.nextLine());

                Signup signup = new Signup();
                switch (accountType) {
                    case 1:
                        account = signup.register(username, password, phoneNum, "Bank");
                        break;
                    case 2:
                        account = signup.register(username, password, phoneNum, "Wallet");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (account == null);
        mainInterface(account);
    }

    private void doLogin() {
        Instapayaccount account = null;
        do {
            try {
                System.out.print("Enter username: ");
                String username = scan.nextLine();
                System.out.print("Enter password: ");
                String password = scan.nextLine();

                Login login = new Login();
                account = login.loginfunc(username, password);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (account == null);
        mainInterface(account);
    }


    private void mainInterface(InstapayAccount account){
        System.out.println("------Welcome "+account.getname()+" To InstaPay------\n\n");
        System.out.println("Choose One Of The Following Options:");
        System.out.println("1.Tranfer Money");
        System.out.println("2.Pay Bills");

    }
}



