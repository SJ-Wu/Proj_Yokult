package web.staff.service;

import java.util.List;

import web.staff.vo.Staff;

public interface StaffService {
	List<Staff> getAll();
	
	Integer addOrModify(Staff staff);

	Staff login(Staff staff);

	Integer remove(Staff staff);

}
