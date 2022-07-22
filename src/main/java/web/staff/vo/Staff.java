package web.staff.vo;

import java.io.Serializable;
import java.sql.Date;

public class Staff implements Serializable{

	private static final long serialVersionUID = 1L;

	private String staffName;
	private String staffEmail;
	private String staffIdNumber;
	private Date staffBirthday;
	private String staffPhone;
	private byte[] staffPicture;
	private String annualLeave;
	private String personalLeave;
	private String officialLeave;

	@Override
	public String toString() {
		return "staff [  staffEmail=" + staffEmail + ", staffIdNumber=" + staffIdNumber + "]";
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

	public Date getStaffBirthday() {
		return staffBirthday;
	}

	public void setStaffBirthday(Date staffBirthday) {
		this.staffBirthday = staffBirthday;
	}

	public String getStaffPhone() {
		return staffPhone;
	}

	public void setStaffPhone(String staffPhone) {
		this.staffPhone = staffPhone;
	}

	public byte[] getStaffPicture() {
		return staffPicture;
	}

	public void setStaffPicture(byte[] staffPicture) {
		this.staffPicture = staffPicture;
	}

	public String getAnnualLeave() {
		return annualLeave;
	}

	public void setAnnualLeave(String annualLeave) {
		this.annualLeave = annualLeave;
	}

	public String getPersonalLeave() {
		return personalLeave;
	}

	public void setPersonalLeave(String personalLeave) {
		this.personalLeave = personalLeave;
	}

	public String getOfficialLeave() {
		return officialLeave;
	}

	public void setOfficialLeave(String officialLeave) {
		this.officialLeave = officialLeave;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}