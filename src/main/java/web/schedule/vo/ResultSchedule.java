package web.schedule.vo;

import java.io.Serializable;
import java.sql.Date;

public class ResultSchedule implements Serializable {
	private static final long serialVersionUID = 1L;

	private Date schedule_date;
	private String workStaff;
	private String dayOffstaff;

	@Override
	public String toString() {
		return "ResultSchedule [schedule_date=" + schedule_date + ", workStaff=" + workStaff + ", dayOffstaff="
				+ dayOffstaff + "]";
	}

	public Date getSchedule_date() {
		return schedule_date;
	}

	public void setSchedule_date(Date schedule_date) {
		this.schedule_date = schedule_date;
	}

	public String getWorkStaff() {
		return workStaff;
	}

	public void setWorkStaff(String workStaff) {
		this.workStaff = workStaff;
	}

	public String getDayOffstaff() {
		return dayOffstaff;
	}

	public void setDayOffstaff(String dayOffstaff) {
		this.dayOffstaff = dayOffstaff;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
