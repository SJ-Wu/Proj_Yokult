package web.shiftSchedule.vo;

import java.io.Serializable;
import java.sql.Date;


public class ShiftSchedule implements Serializable{
	private static final long serialVersionUID = 1L;

	private Date  scheduleDate;
	private String  staffId ;
	private String  shiftscheduleTypeOfLeave ;
	private String  shiftscheduleMorningShift_NightShift;
	@Override
	public String toString() {
		return "ShiftSchedule [scheduleDate=" + scheduleDate + ", staffId=" + staffId + ", shiftscheduleTypeOfLeave="
				+ shiftscheduleTypeOfLeave + ", shiftscheduleMorningShift_NightShift=" + shiftscheduleMorningShift_NightShift + "]";
	}
	public Date getScheduleDate() {
		return scheduleDate;
	}
	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getScheduleTypeOfLeave() {
		return shiftscheduleTypeOfLeave;
	}
	public void setScheduleTypeOfLeave(String shiftscheduleTypeOfLeave) {
		this.shiftscheduleTypeOfLeave = shiftscheduleTypeOfLeave;
	}
	public String getMorningShift_NightShift() {
		return shiftscheduleMorningShift_NightShift;
	}
	public void setMorningShift_NightShift(String shiftschedulemorningShift_NightShift) {
		this.shiftscheduleMorningShift_NightShift = shiftschedulemorningShift_NightShift;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
