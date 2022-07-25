package web.staff.dao;

import java.util.Set;

import web.staff.vo.Staff;


public interface StaffDao {
	Integer insert (Staff staff);
	Set<Staff> selectAll() ;
	Integer update (Staff staff);
	Integer delete (String staffId) ;
	Staff selectByStaff_idAndstaff_idnumber(Staff staff);
	String getMaxId();
}
