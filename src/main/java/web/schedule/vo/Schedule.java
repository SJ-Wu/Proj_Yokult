package web.schedule.vo;

import java.util.Date;

public class Schedule {
	private static final long serialVersionUID = 1L;

	private Date scheduleDate;
	private String workingStaff;
	private String dayOffStaff;
	
	
	@Override
	public String toString() {
		return "Schedule [scheduleDate=" + scheduleDate + ", workingStaff=" + workingStaff + ", dayOffStaff="
				+ dayOffStaff + "]";
	}
	
	public Date getScheduleDate() {
		return scheduleDate;
	}
	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	public String getWorkingStaff() {
		return workingStaff;
	}
	public void setWorkingStaff(String workingStaff) {
		this.workingStaff = workingStaff;
	}
	public String getDayOffStaff() {
		return dayOffStaff;
	}
	public void setDayOffStaff(String dayOffStaff) {
		this.dayOffStaff = dayOffStaff;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
