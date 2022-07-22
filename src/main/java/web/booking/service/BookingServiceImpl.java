package web.booking.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.xml.crypto.dsig.spec.XPathType;

import web.booking.dao.DoctorDAOImpl;
import web.booking.dao.DoctorScheduleDAOImpl;
import web.booking.dao.PatientDAOImpl;
import web.booking.vo.DoctorSchedule;
import web.booking.vo.Patient;

public class BookingServiceImpl implements BookingService  {
	//例外通常是放在service層 才能夠決定導向到哪裡去 不要在DAOimpl把exception處理掉
	//		
	private PatientDAOImpl patientDAOImpl;
	private DoctorDAOImpl doctorDAOImpl;
	
	public BookingServiceImpl() throws NamingException {
		patientDAOImpl = new PatientDAOImpl();
		doctorDAOImpl = new DoctorDAOImpl();
	}
	
	//報到 patient checkin方法 成功回傳1(影響筆數) 失敗回傳-1
	@Override
	public int patientCheckIn(Patient patient) throws NamingException {
		patient.setCheckinCondition(1);
		patient.setBookingDate(Date.valueOf(LocalDate.now()));
		int result = patientDAOImpl.updatePatientCheckinConditionByBookingDate(patient);
		System.out.println("change patientCheckIn condition rowcount = "+ result);
		
		return result;
	}
	
	//取消預約 傳一筆p進來 回傳int
	@Override
	public int patientCancel(Patient patient) throws NamingException {
		patient.setCheckinCondition(2);
		//	patient.setBookingDate();
		int result = patientDAOImpl.updatePatientCheckinConditionByBookingDate(patient);
		System.out.println("change patientCheckIn condition rowcount= "+ result);
		
		return result;
	}
	//組裝會員編號和要booking的時段，並回傳是否新增成功 把object資料拿出來
	//在這邊計算掛幾號
	@Override
	public int setPatientBooking(String memID, Patient patient) throws NamingException {
		//先查詢是否有此筆掛號
		if(patient.getBookingDate() == null) {
			return -1;
		}
		//當天已經有掛號資料 return -1
		List<Patient>list = patientDAOImpl.selectPatientByIdcard(patient);
		if (list != null) {
			for (Patient vo : list) {
				if ((patient.getBookingDate()).equals(vo.getBookingDate())){
					System.out.println("you already booking this day");
					return -1;
				}
			}
		}
		
		//要先拿到patient中 某醫師某時段總共幾人
	 	int patientCount = patientDAOImpl.selectCountByDoctor(patient.getBookingDate(), patient.getDoctorId());
		// 得到當天有幾人掛號
	 	if(patientCount != -1) {
			patient.setBookingNumber(patientCount+1);
		}
	 	int rowcount = patientDAOImpl.insertBookingIntoPatient(memID, patient);
		if (rowcount == -1) {
			return -1;
		} else {
			return patient.getBookingNumber();
		}
	}
	
	// 組裝日期 醫師有上班的時段和姓名
	@Override
	public Map<String, Object> getDoctorScheduleAndDoctorName(Date date1, Date date2,Integer doctorId) throws NamingException {
		List<DoctorSchedule> listDr = new DoctorScheduleDAOImpl().selectDoctorSchedule(date1, date2, doctorId);
		String drName = new DoctorDAOImpl().selectDoctorNameById(doctorId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", listDr);
		map.put("name", drName);
		return map;
	}
	
	// Overloading組裝日期 醫師有上班的時段和姓名
	@Override
	public Map<String, Object> getDoctorScheduleAndDoctorName(String date1, String date2,String doctorId) throws NamingException {
//		Integer.valueOf(doctorId);
		List<DoctorSchedule> listDr = new DoctorScheduleDAOImpl().selectDoctorSchedule(java.sql.Date.valueOf(date1), java.sql.Date.valueOf(date2), Integer.valueOf(doctorId));
		String drName = new DoctorDAOImpl().selectDoctorNameById(Integer.valueOf(doctorId));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", listDr);
		map.put("name", drName);
		return map;
	}

	//回傳病人未報到的所有欄位 加上醫生姓名 有的話回傳list 沒有回null
	@Override
	public List<HashMap<String, Object>> getPatientBooking(Patient patient) throws NamingException {
		List<Patient> list = patientDAOImpl.selectPatientBymemID(patient);
		if (list != null) {
			for (int i = list.size()-1; i >= 0; i--) {
				if(list.get(i).getCheckinCondition() != 0) {
					list.remove(i);
				};
			}
			if (list.size()!=0 ) {
				List<HashMap<String, Object>> listofmap = new ArrayList<HashMap<String, Object>>();
				for(Patient vo : list) {
					HashMap<String, Object> map = new HashMap<String, Object>();
					map.put("serialNumber", vo.getSerialNumber());
					map.put("memID", vo.getMemID());
					map.put("patientIdcard", vo.getPatientIdcard());
					map.put("bookingDate", vo.getBookingDate());
					map.put("amPm", vo.getAmPm());
					map.put("bookingNumber", vo.getBookingNumber());
					map.put("doctorName",doctorDAOImpl.selectDoctorNameById(vo.getDoctorId()));
					map.put("checkinCondition", vo.getCheckinCondition());
					
					listofmap.add(map);
				}
				
				return listofmap;
			}
		}
		return null;
	}
	
	//查詢列出病患身份證字號為? getCheckinCondition=1 的病患所有欄位 的病歷資料
	@Override
	public List<Patient> getChart(Patient patient) throws NamingException {
		patient.setBookingNumber(1);
		patientDAOImpl.selectPatientBymemID(patient);
		return null;
	}
	
	public String getIdcardBymemID(Patient patient) {
		List<Patient> list = patientDAOImpl.selectPatientBymemID(patient);
		if(list.size() != 0) {
			String patientIdcard = list.get(0).getPatientIdcard();
			return patientIdcard;
		}
		return null;
	}
	


}
