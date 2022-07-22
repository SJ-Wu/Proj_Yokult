package web.schedule.vo;

import java.io.Serializable;
import java.sql.Date;


public class Schedule implements Serializable{
	private static final long serialVersionUID = 1L;

	private Date scheduleDate;
	private String scheduleWorkingStaff;
	private String scheduleDayOffStaff;
	
	@Override
	public String toString() {
		return "Schedule [scheduleDate=" + scheduleDate + ", scheduleWorkingStaff=" + scheduleWorkingStaff
				+ ", scheduleDayOffStaff=" + scheduleDayOffStaff + "]";
	}
	
	public Date getScheduleDate() {
		return scheduleDate;
	}
	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	public String getScheduleWorkingStaff() {
		return scheduleWorkingStaff;
	}
	public void setScheduleWorkingStaff(String scheduleWorkingStaff) {
		this.scheduleWorkingStaff = scheduleWorkingStaff;
	}
	public String getScheduleDayOffStaff() {
		return scheduleDayOffStaff;
	}
	public void setScheduleDayOffStaff(String scheduleDayOffStaff) {
		this.scheduleDayOffStaff = scheduleDayOffStaff;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
