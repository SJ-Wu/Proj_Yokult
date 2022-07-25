package web.staff.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.staff.dao.StaffDao;
import web.staff.vo.Staff;

public class StaffDaoImpl implements StaffDao {
	private DataSource datasource;

	public StaffDaoImpl() throws NamingException{
		datasource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/Yokult");
	}

	final String SELECTALL = "select staff_id ,staff_name, staff_email, staff_idnumber, staff_birthday, staff_phone, staff_picture  from staff;";

	@Override
	public Set<Staff> selectAll() {
		try (Connection conn = datasource.getConnection(); PreparedStatement ps = conn.prepareStatement(SELECTALL);) {
			try (ResultSet rs = ps.executeQuery()) {
				Set<Staff> staffs = new HashSet<Staff>();
				System.out.println("Show staff list:");
				while (rs.next()) {

					Staff s = new Staff();
					s.setStaff_id(rs.getString("staff_id"));
					s.setStaff_name(rs.getString("staff_name"));
					s.setStaff_email(rs.getString("staff_email"));
					s.setStaff_idnumber(rs.getString("staff_idnumber"));
					s.setStaff_birthday(rs.getDate("staff_birthday"));
					s.setStaff_phone(rs.getString("staff_phone"));
					s.setStaff_picture(rs.getBytes("staff_picture"));

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
						"insert into staff (staff_id, staff_name, staff_email, staff_idnumber, staff_birthday, staff_phone, staff_picture)"
								+ "values (?, ?, ?, ?, ?, ?, ?);");) {
			ps.setString(1, staff.getStaff_id());
			ps.setString(2, staff.getStaff_name());
			ps.setString(3, staff.getStaff_email());
			ps.setString(4, staff.getStaff_idnumber());
			ps.setDate(5, staff.getStaff_birthday());
			ps.setString(6, staff.getStaff_phone());
			ps.setBytes(7, staff.getStaff_picture());
			int rowCount = ps.executeUpdate();
			System.out.println("insert " + rowCount + "staff.");
			return rowCount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	final String SELECT = "Select staff_id, staff_name, staff_email, staff_idnumber, staff_birthday, staff_phone from staff where staff_id = ?  and staff_idnumber = ? ;";

	@Override
	public Staff selectByStaff_idAndstaff_idnumber(Staff staff) {
		try (Connection conn = datasource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(SELECT);) {
			pstmt.setString(1, staff.getStaff_id());
			pstmt.setString(2, staff.getStaff_idnumber());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					System.out.println("存取成功");
					Staff resultStaff = new Staff();
					resultStaff.setStaff_id(rs.getString("staff_id"));
					resultStaff.setStaff_name(rs.getString("staff_name"));
					resultStaff.setStaff_email(rs.getString("staff_email"));
					resultStaff.setStaff_idnumber(rs.getString("staff_idnumber"));
					resultStaff.setStaff_birthday(rs.getDate("staff_birthday"));
					resultStaff.setStaff_phone(rs.getString("staff_phone"));
//					resultStaff.setStaff_picture(rs.getBytes("staff_picture"));

					return resultStaff;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	final String SELECTMAXID = "SELECT staff_id FROM yokult.staff order by staff_id desc LIMIT 1;";

	public String getMaxId() {
		try (Connection conn = datasource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(SELECTMAXID);) {
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					System.out.println("成功");
					return rs.getString("staff_id");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";

	}
	
	
	
	final String UPDATE = "update staff set staff_name = ?, staff_email = ?,staff_idnumber = ?,  staff_birthday = ?, staff_phone = ? where staff_id = ?;";

	@Override
	public Integer update(Staff staff) {
		try (Connection conn = datasource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(UPDATE);) {
			pstmt.setString(1, staff.getStaff_name());
			pstmt.setString(2, staff.getStaff_email());
			pstmt.setString(3, staff.getStaff_idnumber());
			pstmt.setDate(4, staff.getStaff_birthday());
			pstmt.setString(5, staff.getStaff_phone());
//			pstmt.setBytes(6, staff.getStaff_picture());
			pstmt.setString(6, staff.getStaff_id());

			int rowCount = pstmt.executeUpdate();
			System.out.println(rowCount + " row(s) updated!!");
			return rowCount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	final String DELETE = "delete from staff where staff_id = ?;";

	@Override
	public Integer delete(String staffId) {
		try (Connection conn = datasource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(DELETE);) {
			pstmt.setString(1, staffId);
			int rowCount = pstmt.executeUpdate();
			System.out.println(rowCount + " row(s) deleted!!");
			return rowCount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
