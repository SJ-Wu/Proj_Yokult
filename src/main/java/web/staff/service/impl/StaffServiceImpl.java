package web.staff.service.impl;

import java.util.List;

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
	public List<Staff> getAll() {
		return dao.selectAll();
	}

	// 登入
	@Override
	public Staff login(Staff staff) {
		if (StringUtils.isBlank(staff.getStaff_id()) || StringUtils.isBlank(staff.getStaff_idnumber())) {
			System.out.println("員工編號或密碼錯誤");
			return null;
		}
		staff = dao.selectByStaff_idAndstaff_idnumber(staff);

		if (staff == null) {
			return null;
		}
		return staff;
	}

	// 刪除
	@Override
	public Integer remove(Staff staff) {
		if (StringUtils.isBlank(staff.getStaff_id())) {
			System.out.println("ID格式錯誤");
			return -1;
		}
		return dao.delete(staff.getStaff_id());
	}

	// 新，修
	@Override
	public Integer addOrModify(Staff staff) {
		if (StringUtils.isBlank(staff.getStaff_id())) {// 新增
			String maxId = dao.getMaxId();
			System.out.println("目前最新員工編號 : " + maxId);
			int maxNum = Integer.parseInt(maxId.substring(3));
			maxNum++;
			String laftAdd0 = "%03d";
			String add0 = String.format("tga" + laftAdd0, maxNum);
			System.out.println("預計新增員工編號 : " + add0);
			staff.setStaff_id(add0);
			return dao.insert(staff);
		} else {// 修改
			return dao.update(staff);
		}
	}
}
