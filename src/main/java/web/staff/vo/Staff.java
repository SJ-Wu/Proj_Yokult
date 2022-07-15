package web.staff.vo;

public class Staff {
	
	private static final long serialVersionUID = 1L;

	private String staffName;
	private String staffEmail;
	private String staffIdNumber;
	private String staffBirthday;
	private String staffPhone;

	
	@Override
	public String toString() {
		return "staff [  staffEmail=" + staffEmail + ", staffIdNumber=" + staffIdNumber
				+ "]";
	}

	
	
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffEmail() {
		return staffEmail;
	}
	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}
	public String getStaffIdNumber() {
		return staffIdNumber;
	}
	public void setStaffIdNumber(String staffIdNumber) {
		this.staffIdNumber = staffIdNumber;
	}
	public String getStaffBirthday() {
		return staffBirthday;
	}
	public void setStaffBirthday(String staffBirthday) {
		this.staffBirthday = staffBirthday;
	}
	public String getStaffPhone() {
		return staffPhone;
	}
	public void setStaffPhone(String staffPhone) {
		this.staffPhone = staffPhone;
	}
}