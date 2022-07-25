package web.staff.service.impl;

import java.util.Set;

import javax.naming.NamingException;

import org.apache.commons.lang3.StringUtils;

import web.staff.dao.StaffDao;
import web.staff.dao.impl.StaffDaoImpl;
import web.staff.service.StaffService;
import web.staff.vo.Staff;

public class StaffServiceImpl implements StaffService {
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
		String staffId = staff.getStaff_id();
		if (StringUtils.isBlank(staffId)) {
			System.out.println("ID格式錯誤");
			return -1;
		}
		return dao.delete(staffId);
	}

	@Override
	public Staff login(Staff staff) {
		String staffId = staff.getStaff_id();
		String staffIdnumber = staff.getStaff_idnumber();
		if (StringUtils.isBlank(staffId) || StringUtils.isBlank(staffIdnumber)) {
			System.out.println("員工編號或密碼錯誤");
			return null;
		}
		staff = dao.selectByStaff_idAndstaff_idnumber(staff);

		if (staff == null) {
			return null;
		}
		return staff;
	}

	@Override
	public String addOrModify(Staff staff) {
		String staffId = staff.getStaff_id();
		if (StringUtils.isBlank(staffId)) {// 新增
			String maxId = dao.getMaxId();
			int maxNum = Integer.parseInt(maxId.substring(3));
			maxNum++;
			String laftAdd0 = "%03d";
			String add0 = String.format("tga" + laftAdd0, maxNum);
			staff.setStaff_id(add0);
			if (dao.insert(staff) > 0) {
				return "insert success";
			} else {
				return "insert fail";

			}

		} else {// 修改
			if (dao.update(staff) > 0) {
				return "update success";
			} else {
				return "update fail";

			}

		}
	}
}
