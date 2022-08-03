package web.shiftSchedule.vo;

import java.io.Serializable;
import java.sql.Date;

public class ShiftSchedule implements Serializable {
	private static final long serialVersionUID = 1L;

	private Date scheduleDate;
	private String staffId;
	private String shiftScheduleTypeOfLeave;
	private String shiftScheduleMorningshiftNightshift;

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public String getShiftScheduleTypeOfLeave() {
		return shiftScheduleTypeOfLeave;
	}

	public void setShiftScheduleTypeOfLeave(String shiftScheduleTypeOfLeave) {
		this.shiftScheduleTypeOfLeave = shiftScheduleTypeOfLeave;
	}

	public String getShiftScheduleMorningshiftNightshift() {
		return shiftScheduleMorningshiftNightshift;
	}

	public void setShiftScheduleMorningshiftNightshift(String shiftScheduleMorningshiftNightshift) {
		this.shiftScheduleMorningshiftNightshift = shiftScheduleMorningshiftNightshift;
	}

	@Override
	public String toString() {
		return "ShiftSchedule [" + (scheduleDate != null ? "scheduleDate=" + scheduleDate + ", " : "")
				+ (staffId != null ? "staffId=" + staffId + ", " : "")
				+ (shiftScheduleTypeOfLeave != null ? "shiftScheduleTypeOfLeave=" + shiftScheduleTypeOfLeave + ", "
						: "")
				+ (shiftScheduleMorningshiftNightshift != null
						? "shiftScheduleMorningshiftNightshift=" + shiftScheduleMorningshiftNightshift
						: "")
				+ "]";
	}

}
