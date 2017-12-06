package bigdata3.domain;

public class IoTUser {
  int no;
  String email;
  String name;
  String password;
  String token;
  
  public IoTUser() {}
  
  public IoTUser(String email, String password, String token) {
    this.email = email;
    this.password = password;
    this.token = token;
  }

  @Override
  public String toString() {
    return "IoTUser [no=" + no + ", email=" + email + ", name=" + name + ", password=" + password + ", token=" + token
        + "]";
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
  
  
}
