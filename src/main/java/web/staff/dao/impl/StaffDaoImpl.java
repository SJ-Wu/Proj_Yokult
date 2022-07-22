package web.staff.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.member.vo.Member;
import web.staff.dao.StaffDao;
import web.staff.vo.Staff;

public class StaffDaoImpl implements StaffDao {
	private DataSource datasource;

	public StaffDaoImpl() throws NamingException {
		datasource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/Yokult");
	}

	final String SELECTALL = "Select STAFF_NAME, STAFF_EMAIL, STAFF_IDNUMBER, STAFF_BIRTHDAY, STAFF_PHONE, STAFF_PICTURE  from STAFF;";

	@Override
	public Set<Staff> selectAll() {
		try (Connection conn = datasource.getConnection(); PreparedStatement ps = conn.prepareStatement(SELECTALL);) {
			try (ResultSet rs = ps.executeQuery()) {
				Set<Staff> staffs = new HashSet<Staff>();
				System.out.println("Show staff list:");
				while (rs.next()) {

					Staff s = new Staff();
					s.setStaffName(rs.getString("STAFF_NAME"));
					s.setStaffEmail(rs.getString("STAFF_EMAIL"));
					s.setStaffIdNumber(rs.getString("STAFF_IDNUMBER"));
					s.setStaffBirthday(rs.getDate("STAFF_BIRTHDAY"));
					s.setStaffPhone(rs.getString("STAFF_PHONE"));
					s.setStaffPicture(rs.getBytes("STAFF_PICTURE"));

					staffs.add(s);
					System.out.println(s);
				}
				return staffs;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer insert(Staff staff) {
		try (Connection conn = datasource.getConnection();
				PreparedStatement ps = conn.prepareStatement(
						"insert into STAFF (STAFF_NAME, STAFF_EMAIL, STAFF_IDNUMBER, STAFF_BIRTHDAY, STAFF_PHONE, STAFF_PICTURE)"
								+ "values (?, ?, ?, ?, ?, ?);");) {
			ps.setString(1, staff.getStaffName());
			ps.setString(2, staff.getStaffEmail());
			ps.setString(3, staff.getStaffIdNumber());
			ps.setDate(4, staff.getStaffBirthday());
			ps.setString(5, staff.getStaffPhone());
			ps.setBytes(6, staff.getStaffPicture());
			int rowCount = ps.executeUpdate();
			System.out.println("insert " + rowCount + "staff.");
			return rowCount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	final String SELECT = "Select STAFF_NAME, STAFF_EMAIL, STAFF_IDNUMBER, STAFF_BIRTHDAY, STAFF_PHONE from STAFF where STAFF_NAME = ? and STAFF_EMAIL = ? and STAFF_IDNUMBER = ?";

	@Override
	public Staff selectByStaffEmailAndIdNumber(Staff staff) {
		try (Connection conn = datasource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(SELECT);) {
			pstmt.setString(1, staff.getStaffName());
			pstmt.setString(2, staff.getStaffEmail());
			pstmt.setString(3, staff.getStaffIdNumber());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					System.out.println("存取成功");
					Staff resultStaff = new Staff();
					resultStaff.setStaffName(rs.getString("STAFF_NAME"));
					resultStaff.setStaffEmail(rs.getString("STAFF_EMAIL"));
					resultStaff.setStaffIdNumber(rs.getString("STAFF_IDNUMBER"));
					resultStaff.setStaffBirthday(rs.getDate("STAFF_BIRTHDAY"));
					resultStaff.setStaffPhone(rs.getString("STAFF_PHONE"));
					resultStaff.setStaffPicture(rs.getBytes("STAFF_PICTURE"));

					return resultStaff;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	final String UPDATE = "update STAFF set STAFF_NAME = ?, STAFF_EMAIL = ?, STAFF_BIRTHDAY = ?, STAFF_PHONE = ? where STAFF = ?;";

	@Override
	public Integer update(Staff staff) {
		try (Connection conn = datasource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(UPDATE);) {
			pstmt.setString(1, staff.getStaffName());
			pstmt.setString(2, staff.getStaffEmail());
			pstmt.setString(3, staff.getStaffIdNumber());
			pstmt.setDate(4, staff.getStaffBirthday());
			pstmt.setString(5, staff.getStaffPhone());
			pstmt.setBytes(6, staff.getStaffPicture());

			int rowCount = pstmt.executeUpdate();
			System.out.println(rowCount + " row(s) updated!!");
			return rowCount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	final String DELETE = "delete from STAFF where STAFF_NAME = ?;";

	@Override
	public Integer delete(Staff staff) {
		try (Connection conn = datasource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(DELETE);) {
			pstmt.setString(1, staff.getStaffName());
			int rowCount = pstmt.executeUpdate();
			System.out.println(rowCount + " row(s) deleted!!");
			return rowCount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
