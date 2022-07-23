package web.booking.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.naming.NamingException;

import web.booking.dao.PatientDAOImpl;
import web.booking.vo.Doctor;
import web.booking.vo.Patient;

public class DoctorServiceIImpl {
	//index_doctor_chart  填寫病歷 
	private PatientDAOImpl patientDAOImpl;
	
	public DoctorServiceIImpl() throws NamingException {
		patientDAOImpl = new PatientDAOImpl();
		}
	//儲存病歷
	public int updateChart(Patient patient)  {
		int rowcount = patientDAOImpl.updateChart(patient);
		return rowcount;
	}
	
	
	//回傳某醫師所有病人MEMID
	public Set<String> returnDrPatientIdcard(Doctor doctor) throws NamingException  {
		
		List<Patient> list = filterPatient(doctor);
		if(list.size() != 0) {
			Set<String> set = new HashSet<String>();
			for(Patient patient : list) {
				set.add(patient.getPatientIdcard());
			}
			System.out.println("service: returnDrPatientIdcard: " + set);
		return set;
		}
		return null;
	}
	
	//回傳某醫師某病人的   已報到日期
	public List<Date> returnDrPatientDates(Doctor doctor, Patient patient) throws NamingException {
		//回傳某醫師的已報到所有病人資料
		List<Patient> list = filterPatient(doctor);
		if(list.size() != 0) {
			List<Date> listofDate = new ArrayList<Date>();
			for(Patient vo : list) {
				if(vo.getPatientIdcard().equals(patient.getPatientIdcard())) {
					listofDate.add(vo.getBookingDate());
				}
			}
		return listofDate;
		}
		return null;
	}
	
	//回傳某醫師某病人已報到日期 的病歷資料
	public Patient returnDrPatientChart(Doctor doctor, Patient patient) throws NamingException {
		//過濾同樣dr 有報到的病人們的list
		List<Patient> list = filterPatient(doctor);
		if(list!= null) {
			for(Patient vo : list) {
				if(vo.getPatientIdcard().equals(patient.getPatientIdcard()) && vo.getBookingDate().equals(patient.getBookingDate())) {
					System.out.println("service: get Chart success");
					return vo;
				}
			}
		}
		return null;
	}
	
	
	

	
	
	
	//過濾同樣dr 有報到的病人們 但名字重複 只顯示已經報到過的名單
	public List<Patient> filterPatient(Doctor doctor) throws NamingException{
		int drId = doctor.getDoctorId();
		List<Patient> list = patientDAOImpl.selectAll();
		if(list.size()!=0) {
			for (int i = list.size()-1; i >= 0; i--) {
				if((list.get(i).getDoctorId()) != drId || (list.get(i).getCheckinCondition()) != 1) {
					list.remove(i);
				};
			}
			System.out.println("service: filterDrPatient success =" + list);
			return list;
		}
		return null;
	}
	
//	//過濾 某醫生的已經報到病人們
//	public List<Patient> filterPatientDate(Doctor doctor) throws NamingException{
//		PatientDAOImpl patientDAOImpl = new PatientDAOImpl();
//		List<Patient> list = this.filterPatientNames(doctor);
//		if(list.size()!=0) {
//			for (int i = list.size()-1; i >= 0; i--) {
//				if((list.get(i).getCheckinCondition()) != 1) {
//					list.remove(i);
//				};
//			}
//			return list;
//		}
//		return null;
//	}
	
}
