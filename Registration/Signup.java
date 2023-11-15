package Registration;

import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Account.InstaPayAccount;
import ApplicationDB.InstaPayAccountDB;

public class Signup {
  private boolean isUniqueUsername(String username) {
    InstaPayAccountDB accountDB = new InstaPayAccountDB();
    return !accountDB.checkUsernameExist(username);
  }

  private boolean isValidPassword(String password) {
    Pattern regexPattern = Pattern
    .compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$");
    Matcher matcher = regexPattern.matcher(password);
    return matcher.find();
  }

  private boolean saveNewUser(InstaPayAccount user) {
    InstaPayAccountDB accountDB = new InstaPayAccountDB();
    return accountDB.saveInstaPayAccount(user);
  }

  public int otp(String phoneNumber) {
    SecureRandom random = new SecureRandom();
    return random.nextInt(999999);
  }

  private boolean ValidOtp(int otp, int userOtp) {
    return otp == userOtp;
  }

  public boolean register(String username, String password, String fullName,
  String accountType, String phoneNumber, int userOtp, int otp) throws Exception {
    if (!isUniqueUsername(username)) {
      throw new Exception("invaild username");
    }
    if (!isValidPassword(password)) {
      throw new Exception("invaild password");
    }
    if (!ValidOtp(otp, userOtp)) {
      throw new Exception("invaild otp");
    }
    InstaPayAccount account = new InstaPayAccount(username, password, 
    fullName, accountType, phoneNumber);
    saveNewUser(account);
    return true;
  }
}
