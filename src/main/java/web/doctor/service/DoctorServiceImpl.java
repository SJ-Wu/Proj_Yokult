package web.doctor.service;

import java.util.List;

import javax.naming.NamingException;

import web.booking.dao.DoctorDAOImpl;
import web.booking.vo.Doctor;

public class DoctorServiceImpl implements DoctorService{
	private DoctorDAOImpl doctorDAOImpl ;
	
	public List<Doctor> getDoctorAll() {
		try {
			doctorDAOImpl = new DoctorDAOImpl();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		List<Doctor> list = doctorDAOImpl.selectAll();
		if(list.size() != 0) {
			return list;
		}
		return null;
	}
}
