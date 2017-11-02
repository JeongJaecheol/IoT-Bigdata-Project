package bigdata3.domain;

import java.util.List;

public class ClassRoom {
  protected int no; // field
  protected String name; // field
  List<String> photoNames;
   

  @Override
  public String toString() {
    return "ClassRoom [no=" + no + ", name=" + name + ", photoNames=" + photoNames + "]";
  }
  public List<String> getPhotoNames() {
    return photoNames;
  }
  public void setPhotoNames(List<String> photoNames) {
    this.photoNames = photoNames;
  }
  public int getNo() { // getter = property : property name = "no"
    return no;
  }
  public void setNo(int no) { // setter = property : property name = "no"
    this.no = no;
  }
  public String getName() { // getter = property
    return name;
  }
  public void setName(String name) { // setter = property
    this.name = name;
  }
  
  
}
