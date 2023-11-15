import java.sql.*;

public class InstaPayAccountDB {
  private static final String URL = "jdbc:postgres://instapay_j6jt_user:ZWdgT2UzAESbdOz7CO4F1YPr9srQXDKX@dpg-cl94dpdo7jlc739ob66g-a.oregon-postgres.render.com/instapay_j6jt";
  private static final String USER = "instapay_j6jt_user";
  private static final String PASSWORD = "";

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
          + "id INT PRIMARY KEY AUTO_INCREMENT,"
          + "username VARCHAR(255) NOT NULL,"
          + "password VARCHAR(20) NOT NULL,"
          + "full-name DECIMAL(10, 2) NOT NULL,"
          + "phone-number  VARCHAR(30) NOT NULL"
          + "type);";
      statement.executeUpdate(createTableSQL);
    } catch (SQLException e) {
      System.out.println("Schema creation failed: " + e.getMessage());
    }
  }

  public boolean checkUsernameExist(String username) {
    boolean exists = false;
    try (Connection connection = getConnection()) {
      String query = "SELECT COUNT(*) " +
          "FROM InstaPayAccount" +
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
          "FROM InstaPayAccount" +
          "WHERE phone-number = ?";
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
      String query = "INSERT INTO InstaPayAccount" +
          "(username, password, full-name, phone-number)" +
          "VALUES(?, ?, ?, ?)";
      try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, user.username);
        preparedStatement.setString(2, user.password);
        preparedStatement.setString(3, user.fullName);
        preparedStatement.setString(4, user.phoneNumber);

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
      String query = "SELECT full-name, phone-number" +
          " FROM InstaPayAccount " +
          "WHERE username = ? and password = ?";

      try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
          if (resultSet.next()) {
            String fullName = resultSet.getString("full-name");
            String phoneNumber =  resultSet.getString("phone-number");
            instaPayAccount = new InstaPayAccount(username, password, fullName, phoneNumber);
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
      String query = "SELECT phone-number" +
          " FROM InstaPayAccount " +
          "WHERE username = ?";

      try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, username);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
          if (resultSet.next()) {
            phoneNumber = resultSet.getString("phone-number");
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
