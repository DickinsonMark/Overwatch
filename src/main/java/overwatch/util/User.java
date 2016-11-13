package overwatch.util;

public class User {
  private String username;
  private String system;
  private String region;

  public User(String username, String system, String region) {
    this.username = username;
    this.system = system;
    this.region = region;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getSystem() {
    return this.system;
  }

  public void setSystem(String system) {
    this.system = system;
  }

  public String getRegion() {
    return this.region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

}
