package Registration;

import Account.InstaPayAccount;
import ApplicationDB.InstaPayAccountDB;

public class Login {
  public InstaPayAccount login(String username, String password) throws Exception {
    InstaPayAccountDB accountDB = new InstaPayAccountDB();
    InstaPayAccount account = null;
    try {
      account =  accountDB.loadInstaPayAccount(username, password);
      System.out.println(account);
    } catch (Exception e) {
     throw new Exception(e.getMessage());
    }
    return account;
  }
}
