package overwatch.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static overwatch.db.Db.DB;

/**
 * Created by MarkDickinson on 11/9/16.
 */
public class Users {

  public static User getUser(String username) {

    String system = "";
    String region = "";

    try {
      Connection conn = DB();
      Statement stmt = conn.createStatement();

      String sql = "Select * from users where tag='" + username + "';";
      ResultSet rs = stmt.executeQuery(sql);

      while (rs.next()) {
        username = rs.getString("tag");
        system = rs.getString("system");
        region = rs.getString("region");
      }

      stmt.close();
      conn.close();
    }
    catch (SQLException e) {
      System.out.println("Connection Failed! Check output console");
      e.printStackTrace();
    }
    return new User(username, system, region);
  }

  public static User createUser(String username, String system, String region) {
    try {
      Connection conn = DB();
      Statement stmt = conn.createStatement();

      String sql = "INSERT INTO users (tag, system, region)" + " VALUES ('" + username + "', '" + system + "', '" + region + "') RETURNING *;";
      ResultSet rs = stmt.executeQuery(sql);

      while (rs.next()) {
        username = rs.getString("tag");
        system = rs.getString("system");
        region = rs.getString("region");
      }

      stmt.close();
      conn.close();
    }
    catch (SQLException e) {
      System.out.println("Connection Failed! Check output console");
      e.printStackTrace();
    }
    return new User(username, system, region);
  }
}
