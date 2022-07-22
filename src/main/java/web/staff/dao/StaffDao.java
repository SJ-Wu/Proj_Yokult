package web.staff.dao;

import java.util.Set;

import web.staff.vo.Staff;


public interface StaffDao {
	Integer insert (Staff staff);
	Staff selectByStaffEmailAndIdNumber(Staff staff);
	Set<Staff> selectAll() ;
	Integer update (Staff staff);
	Integer delete (Staff staff) ;
}
