package bigdata3.domain;

public class User {
  int userNo;
  String email;
  String name;
  String password;
  String fbUserId;
  
  public int getUserNo() {
    return userNo;
  }
  public void setUserNo(int userNo) {
    this.userNo = userNo;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getFbUserId() {
    return fbUserId;
  }
  public void setFbUserId(String fbUserId) {
    this.fbUserId = fbUserId;
  }
  
  
}
