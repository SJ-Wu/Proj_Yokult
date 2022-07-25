package web.staff.service;

import java.util.Set;

import web.staff.vo.Staff;

public interface StaffService {
	Set<Staff> getAll();
	
	String addOrModify(Staff staff);

	Staff login(Staff staff);

	Integer remove(Staff staff);

}
