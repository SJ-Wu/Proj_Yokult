package web.schedule.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.schedule.dao.ScheduleDao;
import web.schedule.vo.Schedule;
import web.staff.vo.Staff;

public class ScheduleDaoImpl implements ScheduleDao {
	private DataSource datasource;

	public ScheduleDaoImpl() throws NamingException {
		datasource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/Yokult");
	}

	final String SELECTALL = "SELECT sc.schedule_date, st1.staff_name as morning_shift, st2.staff_name as night_shift, st3.staff_name as day_off FROM schedule sc "
							+ "join staff st1 on sc.morning_shift = st1.staff_id "
							+ "join staff st2 on sc.night_shift = st2.staff_id "
							+ "join staff st3 on sc.day_off = st3.staff_id;";

	@Override
	public List<Schedule> selectAll() {
		try (Connection conn = datasource.getConnection(); PreparedStatement ps = conn.prepareStatement(SELECTALL);) {
			try (ResultSet rs = ps.executeQuery()) {
				List<Schedule> schedules = new ArrayList<Schedule>();
				System.out.println("Show schedule list:");
				while (rs.next()) {

					Schedule s = new Schedule();
					s.setSchedule_date(rs.getDate("schedule_date"));
					s.setMorning_shift(rs.getString("morning_shift"));
					s.setNight_shift(rs.getString("night_shift"));
					s.setDay_off(rs.getString("day_off"));

					schedules.add(s);
					System.out.println(s);
				}
				return schedules;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer insert(Schedule schedule) {
		try (Connection conn = datasource.getConnection();
				PreparedStatement ps = conn.prepareStatement(
						"insert into schedule (schedule_date, morning_shift, night_shift, day_off)"
								+ "values (?, ?, ?);");) {
			ps.setDate(1,schedule.getSchedule_date());
			ps.setString(2, schedule.getMorning_shift());
			ps.setString(3, schedule.getNight_shift());
			ps.setString(4, schedule.getDay_off());
			int rowCount = ps.executeUpdate();
			System.out.println("insert " + rowCount + "schedule.");
			return rowCount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	final String SELECT = "select schedule_date, morning_shift, night_shift, day_off from schedule where schedule_date = ?;";

	@Override
	public Schedule selectByScheduleDate(Schedule schedule) {
		try (Connection conn = datasource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(SELECT);) {
			pstmt.setDate(1, schedule.getSchedule_date());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					System.out.println("存取成功");
					Schedule resultSchedule = new Schedule();
					resultSchedule.setSchedule_date(null);
					;

					return resultSchedule;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	final String UPDATE = "update schedule set schedule_date = ?, morning_shift = ?, night_shift = ? , day_off = ? where schedule = ?;";

	@Override
	public Integer update(Schedule schedule) {
		try (Connection conn = datasource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(UPDATE);) {
			pstmt.setDate(1, schedule.getSchedule_date());
			pstmt.setString(2, schedule.getMorning_shift());
			pstmt.setString(3, schedule.getNight_shift());
			pstmt.setString(4, schedule.getDay_off());
			int rowCount = pstmt.executeUpdate();
			System.out.println(rowCount + " row(s) updated!!");
			return rowCount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	final String SELECTBYSTAFFID = "SELECT staff_id, staff_name, annual_leave, personal_leave, official_leave FROM staff where staff_id = ?;";
	
	@Override
	public Staff selectByStaffId(String StaffId) {
		try (Connection conn = datasource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(SELECTBYSTAFFID);) {
			pstmt.setString(1, StaffId);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					System.out.println("存取成功");
					Staff resultStaff = new Staff();
					resultStaff.setStaff_id(rs.getString("staff_id"));
					resultStaff.setStaff_name(rs.getString("staff_name"));
					resultStaff.setAnnual_leave(rs.getString("annual_leave"));
					resultStaff.setPersonal_leave(rs.getString("personal_leave"));
					resultStaff.setOfficial_leave(rs.getString("official_leave"));
					return resultStaff;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
