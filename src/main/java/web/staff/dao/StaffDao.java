package web.staff.dao;

import java.util.List;

import web.staff.vo.Staff;


public interface StaffDao {
	Integer insert (Staff staff);
	List<Staff> selectAll() ;
	Integer update (Staff staff);
	Integer delete (String staffId) ;
	Staff selectByStaff_idAndstaff_idnumber(Staff staff);
	String getMaxId();
}
