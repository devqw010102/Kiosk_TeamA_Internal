package kr.hcnc.vo;

public class StudentVO {
	private String studentID;
	private String studentName;
	private String birthDate;
	private String eduId;
	private String attendYn;
	private String dormYn;
	private String dormitoryId;
	private String delYn;
	private String createdAt;
	
	private String eduName;
	private String eduRoomname;
	private String startDate;
	private String endDate;
	
	private int currentCount;
	private int maxCount;
	
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getEduId() {
		return eduId;
	}
	public void setEduId(String eduId) {
		this.eduId = eduId;
	}
	public String getAttendYn() {
		return attendYn;
	}
	public void setAttendYn(String attendYn) {
		this.attendYn = attendYn;
	}
	public String getDormYn() {
		return dormYn;
	}
	public void setDormYn(String dormYn) {
		this.dormYn = dormYn;
	}
	public String getDormitoryId() {
		return dormitoryId;
	}
	public void setDormitoryId(String dormitoryId) {
		this.dormitoryId = dormitoryId;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	
	public String getCreatedAt() {
		return createdAt;
	}
	
	
	public String getEduName() {
		return eduName;
	}
	public void setEduName(String eduName) {
		this.eduName = eduName;
	}
	public String getEduRoomname() {
		return eduRoomname;
	}
	public void setEduRoomname(String eduRoomname) {
		this.eduRoomname = eduRoomname;
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
	
	public int getCurrentCount() {
		return currentCount;
	}
	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}
	public int getMaxCount() {
		return maxCount;
	}
	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}
	
	
}
