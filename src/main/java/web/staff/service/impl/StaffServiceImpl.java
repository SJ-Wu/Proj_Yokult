package web.staff.service.impl;

import java.util.Objects;
import java.util.Set;

import javax.naming.NamingException;

import web.member.vo.Member;
import web.staff.dao.StaffDao;
import web.staff.dao.impl.StaffDaoImpl;
import web.staff.service.StaffService;
import web.staff.vo.Staff;

public class StaffServiceImpl implements StaffService{
	private StaffDao dao;
	
	public StaffServiceImpl() throws NamingException {
		dao = new StaffDaoImpl();
	}
	 
	@Override
	public Set<Staff> getAll() {
		return dao.selectAll();
	}

	@Override
	public Integer remove(Staff staff) {
		if (!checkValue(staff.getStaffEmail())) {
			System.out.println("信箱錯誤");
			return -1;
		}
		return dao.delete(staff);
	}

	@Override
	public Integer modify(Staff staff) {
		// 1. check if there is any null column in the not-null column
		if (!checkValue(staff.getStaffEmail())) {
			System.out.println("信箱錯誤");
			return null;
		}
		return dao.update(staff);
	}

	@Override
	public Staff login(Staff staff) {
		String account = staff.getStaffEmail();
		String password = staff.getStaffIdNumber();
		if (!checkValue(account) || !checkValue(password)) {
			System.out.println("姓名或信箱錯誤");
			return null;
		}
		staff = dao.selectByStaffEmailAndIdNumber(staff);
		return staff;
	}

	@Override
	public Integer register(Staff staff) {
		Integer status = dao.insert(staff);
		return status;
	}

	private boolean checkValue(String value) {
		if (value == null || Objects.equals(value, "")) {
			System.out.println(value);
			return false;
		}
		return true;
	}
}
