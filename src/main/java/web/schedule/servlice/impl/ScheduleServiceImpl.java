package web.schedule.servlice.impl;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import web.schedule.dao.ScheduleDao;
import web.schedule.dao.impl.ScheduleDaoImpl;
import web.schedule.servlice.ScheduleService;
import web.schedule.vo.ResultSchedule;
import web.schedule.vo.Schedule;
import web.staff.vo.Staff;

public class ScheduleServiceImpl implements ScheduleService{
	private ScheduleDao dao;

	public ScheduleServiceImpl() throws NamingException {
	dao = new ScheduleDaoImpl();
	
}
	@Override
	public List<ResultSchedule> getAll() {
		List<Schedule> schedules = dao.selectAll();
		
		List<ResultSchedule> resultScheduleList = new ArrayList<ResultSchedule>();
		for(Schedule schedule : schedules) {
			ResultSchedule resultSchedule = new ResultSchedule();
			resultSchedule.setSchedule_date(schedule.getSchedule_date());
			resultSchedule.setWorkStaff(schedule.getMorning_shift());
			resultSchedule.setDayOffstaff(schedule.getDay_off());
			resultScheduleList.add(resultSchedule);
			
			resultSchedule = new ResultSchedule();
			resultSchedule.setSchedule_date(schedule.getSchedule_date());
			resultSchedule.setWorkStaff(schedule.getNight_shift());
			resultSchedule.setDayOffstaff(schedule.getDay_off());
			resultScheduleList.add(resultSchedule);
		}
		
		return resultScheduleList;
	}
	
	@Override
	public String addOrModify(Schedule schedule) {
		return null;
	}
	
	@Override
	public Staff staffData(Staff staff) {
		String staffId = staff.getStaff_id();
		Staff resultStaff = dao.selectByStaffId(staffId);

		return resultStaff;
	}
	


}
