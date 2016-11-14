package overwatch.main;

import org.json.simple.JSONObject;
import overwatch.util.JsonUtil;
import overwatch.util.Users;

import static spark.Spark.*;

/*
 * Created by Mark Dickinson on 11/7/16.
 */

public class Main {

  private static void enableCORS() {
    before((request, response) -> {
      response.header("Access-Control-Allow-Origin", "*");
      response.header("Access-Control-Request-Method", "*");
      response.header("Access-Control-Allow-Headers", "*");
    });
  }

  public static void main(String[] args) {
    enableCORS();
    get("/login/:username", (req, res) -> Users.getUser(req.params("username")), JsonUtil.json());
    post("/register/:username/:system/:region", (req, res) -> {
      JSONObject obj = new JSONObject();
      obj.put("battle tag", req.params("username"));
      obj.put("system", req.params("system"));
      obj.put("balance", req.params("region"));
      return Users.createUser(
          req.params("username"),
          req.params("system"),
          req.params("region")
      );
    }, JsonUtil.json());

  }
}