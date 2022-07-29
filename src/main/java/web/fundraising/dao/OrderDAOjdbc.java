package web.fundraising.dao;

import static web.fundraising.common.CommonJDBC.URL;
import static web.fundraising.common.CommonJDBC.USER;
import static web.fundraising.common.CommonJDBC.PASSWORD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import web.fundraising.vo.OrderBean;

public class OrderDAOjdbc implements OrderDAO {

	@Override
	public OrderBean insert(OrderBean orderBean) {
		int rowCount = 0;
		if(orderBean != null) {
			String sql = "insert into `Fund_Order`(" 
					+ " `orderInvoiceNumber`,"
					+ " `orderTimeStamp`,"
					+ "	`orderAmount`,"
					+ "	`proposalID`,"
					+ " `planID`,"
					+ " `memID`,"
					+ " `postID`"
					+ ")values(?, ?, ?, ?, ?, ?, ?);";
			
			try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
					PreparedStatement ps = connection.prepareStatement(sql);
					Statement stm = connection.createStatement()) {
				ps.setString(1, orderBean.getOrderInvoiceNumber());
				ps.setDate(2, orderBean.getOrderTimeStamp());
				ps.setInt(3, orderBean.getOrderAmount());
				ps.setInt(4, orderBean.getProposalID());
				ps.setInt(5, orderBean.getPlanID());
				ps.setString(6, orderBean.getMemID());
				ps.setInt(7, orderBean.getPostID());
				
				sql = ps.toString().split(": ")[1];
				rowCount = stm.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);	
				ResultSet rs = stm.getGeneratedKeys();
			    rs.next();
			    int key = rs.getInt(1);
			    orderBean.setOrderID(key);
			    
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rowCount != 0) {
			return orderBean;
		}else {
			return null;
		}
	}

	@Override
	public Boolean delete(Integer id) {
		int rowCount = 0;
		if(id != null && id>0) {
			String sql = "delete from `Fund_Order` where `OrderID` = ?;";
			try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
					PreparedStatement ps = connection.prepareStatement(sql)) {
				ps.setInt(1, id);
				rowCount = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowCount != 0;		
	}

	@Override
	public OrderBean update(Integer id, OrderBean orderBean) {
		int rowCount = 0;
		if(id != null && id > 0 && orderBean != null) {
			String sql = "update `Fund_Order`"
					+ " set"
					+ " `orderInvoiceNumber` = ?,"
					+ " `orderTimeStamp` = ?,"
					+ "	`orderAmount` = ?,"
					+ "	`proposalID` = ?,"
					+ " `planID` = ?,"
					+ " `memID` = ?,"
					+ " `postID` = ?"
					+ " where `OrderID` = ?";
			try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
					PreparedStatement ps = connection.prepareStatement(sql)){
				ps.setString(1, orderBean.getOrderInvoiceNumber());
				ps.setDate(2, orderBean.getOrderTimeStamp());
				ps.setInt(3, orderBean.getOrderAmount());
				ps.setInt(4, orderBean.getProposalID());
				ps.setInt(5, orderBean.getPlanID());
				ps.setString(6, orderBean.getMemID());
				ps.setInt(7, orderBean.getPostID());
				ps.setInt(8, id);
				
				rowCount = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rowCount != 0) {
			return orderBean;
		}else {
			return null;
		}
	}

	@Override
	public OrderBean select(Integer id) {
		OrderBean orderBean = null;
		if(id != null && id > 0) {
			String sql = "select * from `Fund_Order`"
					+ " where `orderID` = ?";
			try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
					PreparedStatement ps = connection.prepareStatement(sql)){
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					String orderInvoiceNumber = rs.getString(2);
					Date orderTimeStampt = rs.getDate(3);
					Integer orderAmount = rs.getInt(4);
					Integer proposalID = rs.getInt(5);
					Integer planID = rs.getInt(6);
					String memID = rs.getString(7);
					Integer postID = rs.getInt(8);
					
					orderBean = new OrderBean(
							orderInvoiceNumber, orderTimeStampt, 
							orderAmount, proposalID, planID, memID, postID);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return orderBean;
	}

	@Override
	public List<OrderBean> selectAll() {
		List<OrderBean> list = new ArrayList<OrderBean>();
		String sql = "select * from `Fund_Order`";
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			OrderBean orderBean= null;
			while(rs.next()) {
				Integer orderID = rs.getInt(1);
				String orderInvoiceNumber = rs.getString(2);
				Date orderTimeStampt = rs.getDate(3);
				Integer orderAmount = rs.getInt(4);
				Integer proposalID = rs.getInt(5);
				Integer planID = rs.getInt(6);
				String memID = rs.getString(7);
				Integer postID = rs.getInt(8);

				orderBean = new OrderBean(
						orderID, orderInvoiceNumber, orderTimeStampt, 
						orderAmount, proposalID, planID, memID, postID);
				list.add(orderBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
