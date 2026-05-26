package kr.hcnc.vo;

public class StudentSearchVO {
    private String studentId;
    private String birthDate;
    private String dormitoryId;
    private String phoneNumber;

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getBirthDate() { return birthDate; }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }
	
    public String getDormitoryId() { return dormitoryId; }
    public void setDormitoryId(String dormitoryId) { this.dormitoryId = dormitoryId; }
    
	public String getPhoneNumber() {return phoneNumber;}
	public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}