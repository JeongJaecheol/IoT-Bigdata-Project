package bigdata3.util;

public class FcmMessage {
  String to;
  String message;
  String title;
  String text;
  
  public FcmMessage() {}
  
  public FcmMessage(String to, String message, String title, String text) {
    this.to = to;
    this.message = message;
    this.title = title;
    this.text = text;
  }

  @Override
  public String toString() {
    return "FcmMessage [to=" + to + ", message=" + message + ", title=" + title + ", text=" + text + "]";
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
  
  
}
