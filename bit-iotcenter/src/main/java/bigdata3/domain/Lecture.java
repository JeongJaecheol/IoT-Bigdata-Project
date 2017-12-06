package bigdata3.domain;

public class Lecture {
	int lectureNo;
	int classroomNo;
	int managerNo;
	String title;
	String descript;
	String startDate; 
	String endDate;
	int qty; 
	int price;
	int thours;
	
	@Override
	public String toString() {
		return "Lecture [lectureNo=" + lectureNo + ", classroomNo=" + classroomNo + ", managerNo=" + managerNo
				+ ", title=" + title + ", descript=" + descript + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", qty=" + qty + ", price=" + price + ", thours=" + thours + "]";
	}

	public int getLectureNo() {
		return lectureNo;
	}

	public void setLectureNo(int lectureNo) {
		this.lectureNo = lectureNo;
	}

	public int getClassroomNo() {
		return classroomNo;
	}

	public void setClassroomNo(int classroomNo) {
		this.classroomNo = classroomNo;
	}

	public int getManagerNo() {
		return managerNo;
	}

	public void setManagerNo(int managerNo) {
		this.managerNo = managerNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getPrice() {
		return price; 
	}   
 
	public void setPrice(int price) {
		this.price = price;
	}

	public int getThours() {
		return thours;
	}

	public void setThours(int thours) {
		this.thours = thours;
	}
	
}
