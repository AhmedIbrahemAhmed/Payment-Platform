package ApplicationDB;
import java.sql.*;

import Account.InstaPayAccount;
public class InstaPayAccountDB {
  private static final String URL = "jdbc:postgresql://dpg-cl94dpdo7jlc739ob66g-a.oregon-postgres.render.com:5432/instapay_j6jt";
  private static final String USER = "instapay_j6jt_user";
  private static final String PASSWORD = "ZWdgT2UzAESbdOz7CO4F1YPr9srQXDKX";

  public InstaPayAccountDB () {
    establishSchema();
  }

  private static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL, USER, PASSWORD);
  }

  private void closeConnection(Connection connection) {
    if (connection != null) {
      try {
        connection.close();
      } catch (SQLException e) {
        System.out.println("error while closing DB" + e.getMessage());
      }
    }
  }

  public void establishSchema() {
    try (Connection connection = getConnection();
         Statement statement = connection.createStatement()) {
      String createTableSQL = "CREATE TABLE IF NOT EXISTS InstaPayAccount ("
          + "id SERIAL PRIMARY KEY,"
          + "username VARCHAR(255) NOT NULL,"
          + "password VARCHAR(20) NOT NULL,"
          + "fullname VARCHAR(255) NOT NULL,"
          + "phonenumber VARCHAR(30) NOT NULL,"
          + "type VARCHAR(30) NOT NULL);";
      statement.executeUpdate(createTableSQL);
    } catch (SQLException e) {
      System.out.println("Schema creation failed: " + e.getMessage());
    }
  }

  public boolean checkUsernameExist(String username) {
    boolean exists = false;
    try (Connection connection = getConnection()) {
      String query = "SELECT COUNT(*) " +
          "FROM InstaPayAccount " +
          "WHERE username = ?";
      try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, username);
        try (ResultSet resultSet = preparedStatement.executeQuery()){
          if (resultSet.next()) {
            int count = resultSet.getInt(1);
            exists = count > 0;
          }
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return exists;
  }

  public boolean checkPhoneNumberExist(String phoneNumber) {
    boolean exists = false;
    try (Connection connection = getConnection()) {
      String query = "SELECT COUNT(*) " +
          "FROM InstaPayAccount " +
          "WHERE phonenumber = ?";
      try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, phoneNumber);
        try (ResultSet resultSet = preparedStatement.executeQuery()){
          if (resultSet.next()) {
            int count = resultSet.getInt(1);
            exists = count > 0;
          }
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return exists;
  }

  public boolean saveInstaPayAccount(InstaPayAccount user) {
    try (Connection connection = getConnection()) {
      String query = "INSERT INTO InstaPayAccount " +
          "(username, password, fullname, phonenumber, type) " +
          "VALUES(?, ?, ?, ?, ?)";
      try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, user.getUserName());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getFullName());
        preparedStatement.setString(4, user.getPhoneNumber());
        preparedStatement.setString(5, user.getAccountType());

        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected > 0;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public InstaPayAccount loadInstaPayAccount(String username, String password) {
    InstaPayAccount instaPayAccount = null;
    try (Connection connection = getConnection()) {
      String query = "SELECT fullname, phonenumber, type" +
          " FROM InstaPayAccount " +
          "WHERE username = ? and password = ?";

      try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
          if (resultSet.next()) {
            String fullName = resultSet.getString("fullname");
            String phoneNumber =  resultSet.getString("phonenumber");
            String type =  resultSet.getString("type");
            instaPayAccount = new InstaPayAccount(username, password, fullName, type, phoneNumber);
          }
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return instaPayAccount;
  }

  public String getAccountType(String username) {
    String type = "";
    try (Connection connection = getConnection()) {
      String query = "SELECT type" +
          " FROM InstaPayAccount " +
          "WHERE username = ?";

      try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, username);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
          if (resultSet.next()) {
            type = resultSet.getString("type");
            return type;
          }
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return type;
  }

  public String getPhoneNumber(String username) {
    String phoneNumber = "";
    try (Connection connection = getConnection()) {
      String query = "SELECT phonenumber " +
          " FROM InstaPayAccount " +
          "WHERE username = ?";

      try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, username);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
          if (resultSet.next()) {
            phoneNumber = resultSet.getString("phonenumber");
            return phoneNumber;
          }
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return phoneNumber;
  }
}
