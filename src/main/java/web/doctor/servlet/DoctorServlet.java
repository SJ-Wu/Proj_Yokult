package web.doctor.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import web.booking.service.DoctorServiceIImpl;
import web.booking.vo.Doctor;
import web.booking.vo.DoctorChartVO;
import web.booking.vo.Patient;

@WebServlet("/api/0.01/doctor/*")
public class DoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DoctorServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//開啟跨網域，html才能接收到servlet傳出的東西
		setHeaders(response);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		BufferedReader br = request.getReader();
		PrintWriter out = response.getWriter();
		String pathInfo = request.getPathInfo();
		String[] infos = pathInfo.split("/");
	//過濾同樣dr 有報到過的病人們 身分證字號名單
		if ("getDrPatientIdcard".equals(infos[1])) {
			out.append(gson.toJson(getDrPatientIdcard(gson, request)));
			br.close();
			out.close();
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setHeaders(response);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		BufferedReader br = request.getReader();
		PrintWriter out = response.getWriter();
		String pathInfo = request.getPathInfo();
		String[] infos = pathInfo.split("/");

	//回傳index_doctor_chart.html 的  依據所選的醫師和有報到的病患的身分證字號 回傳看診日期選單
		if ("getDrPatientDates".equals(infos[1])) {
			out.append(gson.toJson(getDrPatientDates(gson, br)));
			br.close();
			out.close();
			return;
			
		} else if ("returnChart".equals(infos[1])) {
			out.append(gson.toJson(returnChart(gson, br)));
			br.close();
			out.close();
			return;
			
		}
	}
	
	//儲存前端傳來的病歷紀錄
	private JsonObject updateChart(Gson gson, Reader br) {
		DoctorServiceIImpl doctorServiceIImpl = null;
		try {
			doctorServiceIImpl = new DoctorServiceIImpl();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		Patient patient = gson.fromJson(br, Patient.class);
		JsonObject jsonObject = new JsonObject();
		int result = 0;
		result = doctorServiceIImpl.updateChart(patient);
		if (result == 1) {
			jsonObject.addProperty("msg", "updateChart success");
		} else {
			jsonObject.addProperty("msg", "updateChart failure");
		}
		return jsonObject;
	}
	
	//回傳index_doctor_chart.html 的 病患身分證字號
	private JsonObject getDrPatientIdcard(Gson gson, HttpServletRequest request) {
		DoctorServiceIImpl doctorServiceIImpl = null;
		try {
			doctorServiceIImpl = new DoctorServiceIImpl();
		} catch (NamingException e1) {
			e1.printStackTrace();
		}
//		Doctor doctor = gson.fromJson(br, Doctor.class);
		Doctor doctor = new Doctor();
		doctor.setDoctorId(Integer.valueOf(request.getParameter("doctorId")));
//		System.out.println(doctor);
		JsonObject jsonObject = new JsonObject();
		try {
			Set<String> set = doctorServiceIImpl.returnDrPatientIdcard(doctor);
			if(set == null) {
				jsonObject.addProperty("msg", "get no Patients booked");
			} else {
				jsonObject.addProperty("msg", "get patient id success");
				jsonObject.add("IDSet", gson.toJsonTree(set, new TypeToken<Set<String>>() {}.getType()).getAsJsonArray());
			}
			
		} catch (NamingException e) {
			System.out.println("getDrPatientID failure");
			jsonObject.addProperty("msg", "getDrPatientID failure");
			e.printStackTrace();
		}
		
		return jsonObject;
	}

	//回傳index_doctor_chart.html 的  依據所選的醫師和有報到的病患的身分證字號 回傳看診日期選單
	private JsonObject getDrPatientDates(Gson gson, Reader br) {
		DoctorServiceIImpl doctorServiceIImpl = null;
		try {
			doctorServiceIImpl = new DoctorServiceIImpl();
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DoctorChartVO doctorChartVO = gson.fromJson(br, DoctorChartVO.class);
		Doctor doctor = new Doctor();
		Patient patient = new Patient();
		doctor.setDoctorId(doctorChartVO.getDoctorId());
		patient.setPatientIdcard(doctorChartVO.getPatientIdcard());
//		System.out.println(patient);		
		JsonObject jsonObject = new JsonObject();
		try {
			List<Date> list = doctorServiceIImpl.returnDrPatientDates(doctor, patient);
			if (list != null) {
				jsonObject.addProperty("msg", "get patient dates success");
				jsonObject.add("list", gson.toJsonTree(list, new TypeToken<List<Date>>() {}.getType()).getAsJsonArray());
				System.out.println("servelt: return List<Date>");
			}
			if (list == null) {
				jsonObject.addProperty("msg", "get no Patients booked");
			} 
			
			
			
		} catch (NamingException e) {
			System.out.println("getDrPatientDates failure");
			jsonObject.addProperty("msg", "getDrPatientDates failure");
			e.printStackTrace();
		}
		
		return jsonObject;
	}
	
	
	//顯示原本的病歷紀錄
	private JsonObject returnChart(Gson gson, Reader br) {
		DoctorServiceIImpl doctorServiceIImpl = null;
		try {
			doctorServiceIImpl = new DoctorServiceIImpl();
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DoctorChartVO doctorChartVO = gson.fromJson(br, DoctorChartVO.class);
		Doctor doctor = new Doctor();
		Patient patient = new Patient();
		doctor.setDoctorId(doctorChartVO.getDoctorId());
		patient.setPatientIdcard(doctorChartVO.getPatientIdcard());
		patient.setBookingDate(doctorChartVO.getBookingDate());
		JsonObject jsonObject = new JsonObject();
		try {
			Patient patientChart = doctorServiceIImpl.returnDrPatientChart(doctor, patient);
			if (patientChart != null) {
				jsonObject.addProperty("msg", "returnChart success");
				jsonObject.addProperty("list", gson.toJson(patientChart.getChart()));
			}
			
		} catch (NamingException e) {
			System.out.println("returnChart failure");
			jsonObject.addProperty("msg", "returnChart failure");
			e.printStackTrace();
		}
		
		return jsonObject;
	}
	
	private void setHeaders(HttpServletResponse response) {
		// 重要
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Cache-control", "no-cache, no-store");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "-1");

		// 重要
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "*");
		response.setHeader("Access-Control-Allow-Headers", "*");
		response.setHeader("Access-Control-Max-Age", "86400");
	}

}
