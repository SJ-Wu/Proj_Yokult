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

import web.fundraising.vo.CategoryBean;

public class CategoryDAOjdbc implements CategoryDAO {

	@Override
	public CategoryBean insert(CategoryBean categoryBean) {
		int rowCount = 0;
		String sql = "insert into `Fund_CATEGORY`(" 
				+ "	`categoryID`, `categoryName`) "
				+ "values(?, ?);";
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, categoryBean.getCategoryID());
			ps.setString(2, categoryBean.getCategoryName());
			rowCount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(rowCount != 0) {
			return categoryBean;
		}else {
			return null;
		}
	}

	@Override
	public Boolean delete(String id) {
		int rowCount = 0;
		String sql = "delete from `Fund_CATEGORY` where `categoryID` = ?;";
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
	public CategoryBean update(String id, CategoryBean categoryBean) {
		int rowCount = 0;
		String sql = "update `Fund_CATEGORY`"
				+ " set `categoryID` = ?, `categoryName` = ?"
				+ " where `categoryID` = ?";
		try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setString(1, categoryBean.getCategoryID());
			ps.setString(2, categoryBean.getCategoryName());
			ps.setString(3, id);
			rowCount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(rowCount != 0) {
			return categoryBean;
		}else {
			return null;
		}
	}

	@Override
	public CategoryBean select(String id) {
		CategoryBean categoryBean = null;
		String sql = "select * from `Fund_CATEGORY`"
				+ " where `categoryID` = ?";
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String categoryID = rs.getString(1);
				String categoryName = rs.getString(2);
				categoryBean = new CategoryBean(categoryID, categoryName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoryBean;
	}

	@Override
	public List<CategoryBean> selectAll() {
		List<CategoryBean> list = new ArrayList<CategoryBean>();
		String sql = "select * from `Fund_CATEGORY`";
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			CategoryBean categoryBean= null;
			while(rs.next()) {
				String categoryID = rs.getString(1);
				String categoryName = rs.getString(2);
				categoryBean = new CategoryBean(categoryID, categoryName);
				list.add(categoryBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
