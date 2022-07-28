package web.fundraising.dao;

import static web.fundraising.common.CommonJDBC.URL;
import static web.fundraising.common.CommonJDBC.USER;
import static web.fundraising.common.CommonJDBC.PASSWORD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.fundraising.vo.StatusBean;

public class StatusDAOjdbc implements StatusDAO {

	@Override
	public StatusBean insert(StatusBean statusBean) {
		int rowCount = 0;
		String sql = "insert into `Fund_STATUS`(" 
				+ "	`statusID`, `statusName`) "
				+ "values(?, ?);";
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, statusBean.getStatusID());
			ps.setString(2, statusBean.getStatusName());
			rowCount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(rowCount != 0) {
			return statusBean;
		}else {
			return null;
		}
	}

	@Override
	public Boolean delete(String id) {
		int rowCount = 0;
		String sql = "delete from `Fund_STATUS` where `statusID` = ?;";
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, id);
			rowCount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount != 0;
	}

	@Override
	public StatusBean update(String id, StatusBean statusBean) {
		int rowCount = 0;
		String sql = "update `Fund_STATUS`"
				+ " set `statusID` = ?, `statusName` = ?"
				+ " where `statusID` = ?";
		try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setString(1, statusBean.getStatusID());
			ps.setString(2, statusBean.getStatusName());
			ps.setString(3, id);
			rowCount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(rowCount != 0) {
			return statusBean;
		}else {
			return null;
		}
	}

	@Override
	public StatusBean select(String id) {
		StatusBean statusBean = null;
		String sql = "select * from `Fund_STATUS`"
				+ " where `statusID` = ?";
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String statusID = rs.getString(1);
				String statusName = rs.getString(2);
				statusBean = new StatusBean(statusID, statusName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statusBean;
	}

	@Override
	public List<StatusBean> selectAll() {
		List<StatusBean> list = new ArrayList<StatusBean>();
		String sql = "select * from `Fund_STATUS`;";
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			StatusBean statusBean= null;
			while(rs.next()) {
				String statusID = rs.getString(1);
				String statusName = rs.getString(2);
				statusBean = new StatusBean(statusID, statusName);
				list.add(statusBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
