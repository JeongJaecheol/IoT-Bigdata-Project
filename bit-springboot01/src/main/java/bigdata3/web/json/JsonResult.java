package bigdata3.web.json;

public class JsonResult {
  
  public static final String STATE_SUCCESS = "success";
  public static final String STATE_FAIL = "fail";
  
  String state;
  Object data;
  
  public JsonResult() {}
  
  public JsonResult(String state, Object data) {
    this.state = state;
    this.data = data;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }
  
  
  
}
