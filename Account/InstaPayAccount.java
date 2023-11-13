package Account;

public class InstaPayAccount {
    private String userName ;
    private String password ;
    private String fullName ;
    private String accountType;
    private String phoneNumber ;

    public InstaPayAccount(String userName, String password, String fullName, String providerType, String phoneNumber) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.accountType = providerType;
        this.phoneNumber = phoneNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;
    }






    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }



}
