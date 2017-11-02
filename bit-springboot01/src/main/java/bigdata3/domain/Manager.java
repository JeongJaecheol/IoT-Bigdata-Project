package bigdata3.domain;

public class Manager extends Member {
  protected int no;
  protected String position;
  protected String fax;
  String photoName;
 

  public String getPhotoName() {
    return photoName;
  }

  public void setPhotoName(String photoName) {
    this.photoName = photoName;
  }

  @Override
  public String toString() {
    return "Manager [position=" + position + ", fax=" + fax + ", photoName=" + photoName + ", no=" + no + ", name="
        + name + ", tel=" + tel + ", email=" + email + ", password=" + password + "]";
  }
  
  
  public int getNo() {
    return no;
  }
  
  public void setNo(int no) {
    this.no = no;
  }
  
  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }
  

  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

}

