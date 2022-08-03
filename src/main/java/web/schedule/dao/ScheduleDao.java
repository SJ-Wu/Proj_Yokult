package web.schedule.dao;

import java.util.List;

import web.schedule.vo.Schedule;
import web.staff.vo.Staff;

public interface ScheduleDao {
	
	Staff selectByStaffId(String StaffId);
	
	List<Schedule> selectAll() ;
	Integer insert (Schedule schedule);
	Schedule selectByScheduleDate(Schedule schedule);
	Integer update (Schedule schedule);

}
