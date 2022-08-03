package web.schedule.vo;

import java.io.Serializable;
import java.sql.Date;


public class Schedule implements Serializable{
	private static final long serialVersionUID = 1L;

	private Date schedule_date;
	private String morning_shift;
	private String night_shift;
	private String day_off;
	@Override
	public String toString() {
		return "Schedule [schedule_date=" + schedule_date + ", morning_shift=" + morning_shift + ", night_shift="
				+ night_shift + ", day_off=" + day_off + "]";
	}
	public Date getSchedule_date() {
		return schedule_date;
	}
	public void setSchedule_date(Date schedule_date) {
		this.schedule_date = schedule_date;
	}
	public String getMorning_shift() {
		return morning_shift;
	}
	public void setMorning_shift(String morning_shift) {
		this.morning_shift = morning_shift;
	}
	public String getNight_shift() {
		return night_shift;
	}
	public void setNight_shift(String night_shift) {
		this.night_shift = night_shift;
	}
	public String getDay_off() {
		return day_off;
	}
	public void setDay_off(String day_off) {
		this.day_off = day_off;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
