package bigdata3.domain;

public class IoTDevice {
  long no;
  int userNo;
  String serialNo;
  
  public IoTDevice() {}
  
  public IoTDevice(long no, int userNo, String serialNo) {
    this.no = no;
    this.userNo = userNo;
    this.serialNo = serialNo;
  }

  @Override
  public String toString() {
    return "IoTDevice [no=" + no + ", userNo=" + userNo + ", serialNo=" + serialNo + "]";
  }

  public long getNo() {
    return no;
  }

  public void setNo(long no) {
    this.no = no;
  }

  public int getUserNo() {
    return userNo;
  }

  public void setUserNo(int userNo) {
    this.userNo = userNo;
  }

  public String getSerialNo() {
    return serialNo;
  }

  public void setSerialNo(String serialNo) {
    this.serialNo = serialNo;
  }

  
}
