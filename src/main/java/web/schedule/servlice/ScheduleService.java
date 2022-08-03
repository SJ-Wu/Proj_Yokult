package web.schedule.servlice;

import java.util.List;

import web.schedule.vo.ResultSchedule;
import web.schedule.vo.Schedule;
import web.staff.vo.Staff;

public interface ScheduleService {
	List<ResultSchedule> getAll();

	String addOrModify(Schedule schedule);

	Staff staffData(Staff staff);
}