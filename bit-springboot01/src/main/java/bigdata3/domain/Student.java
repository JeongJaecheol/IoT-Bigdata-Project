package bigdata3.domain;

public class Student extends Member {
  protected char workingYn; // 재직여부
  protected String lastEducation; // 최종학력
  protected String schoolName; // 학교명
  protected String postNumber; // 우편번호
  protected String primaryAddress; // 기본주소
  protected String detailAddress; // 상세주소
  protected String photoName; // 사진
   
  
  @Override
  public String toString() {
    return "Student [workingYn=" + workingYn + ", lastEducation=" + lastEducation + ", schoolName=" + schoolName
        + ", postNumber=" + postNumber + ", primaryAddress=" + primaryAddress + ", detailAddress=" + detailAddress
        + ", photoName=" + photoName + "]";
  }


  public char getWorkingYn() {
    return workingYn;
  }
  public void setWorkingYn(char workingYn) {
    this.workingYn = workingYn;
  }
  public String getLastEducation() {
    return lastEducation;
  }
  public void setLastEducation(String lastEducation) {
    this.lastEducation = lastEducation;
  }
  public String getSchoolName() {
    return schoolName;
  }
  public void setSchoolName(String schoolName) {
    this.schoolName = schoolName;
  }
  public String getPostNumber() {
    return postNumber;
  }
  public void setPostNumber(String postNumber) {
    this.postNumber = postNumber;
  }
  public String getPrimaryAddress() {
    return primaryAddress;
  }
  public void setPrimaryAddress(String primaryAddress) {
    this.primaryAddress = primaryAddress;
  }
  public String getDetailAddress() {
    return detailAddress;
  }
  public void setDetailAddress(String detailAddress) {
    this.detailAddress = detailAddress;
  }
  

  public String getPhotoName() {
    return photoName;
  }

  public void setPhotoName(String photoName) {
    this.photoName = photoName;
  }
  
  
  
}
