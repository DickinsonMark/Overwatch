package overwatch.db;

import java.sql.*;

public class Db {

  public static Connection DB() {

    Connection connection = null;

    try {

      connection = DriverManager.getConnection(
          "jdbc:postgresql://localhost:5432/overwatch");

    } catch (SQLException e) {

      System.out.println("Connection Failed! Check output console");
      e.printStackTrace();
    }

    return connection;
  }
}