package web.product.list.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.product.list.dao.OrderlistDao;
import web.product.list.vo.Orderlist;

public class OrderlistDaoImpl implements OrderlistDao {
	private DataSource dataSource;

	public OrderlistDaoImpl() throws NamingException {
		dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/Yokult");
	}

	// 查询
	final String SELECT = "Select OrderListNumber, Ord_ProductID, Ord_Unitprice, Ord_Quantity, Ord_ID from OrderList where Ord_ID = ?";

	@Override
	public Orderlist searchOrderlist(Orderlist orderlist) {
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(SELECT);) {
			pstmt.setString(1, orderlist.getOderID());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					System.out.println("存取成功");
					Orderlist resultOrderlist = new Orderlist();
					resultOrderlist.setOderListnumber(rs.getString("OrderListNumber"));
					resultOrderlist.setOderProductid(rs.getString("Ord_ProductID"));
					resultOrderlist.setOderUnitprice(rs.getInt("Ord_Unitprice"));
					resultOrderlist.setOderQuantity(rs.getInt("Ord_Quantity"));
					resultOrderlist.setOderID(rs.getString("Ord_ID"));
					return resultOrderlist;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 新增
	final String INSERT = "insert into OrderList (OrderListNumber, Ord_ProductID, Ord_Unitprice, Ord_Quantity, Ord_ID) values (?, ?, ?, ?, ?);";

	public Integer insertOrderlist(Orderlist orderlist) {
		try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(INSERT);) {
			ps.setString(1, orderlist.getOderListnumber());
			ps.setString(2, orderlist.getOderProductid());
			ps.setInt(3, orderlist.getOderUnitprice());
			ps.setInt(4, orderlist.getOderQuantity());
			ps.setString(5, orderlist.getOderID());
			int rowCount = ps.executeUpdate();
			System.out.println("insert " + rowCount + "product.list.");
			return rowCount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	// 删除
	final String DELETE = "delete from OrderList where Ord_ID = ?;";

	public Integer deleteOrderlist(Orderlist orderlist) {
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(DELETE);) {
			pstmt.setString(1, orderlist.getOderID());
			int rowCount = pstmt.executeUpdate();
			System.out.println(rowCount + " row(s) deleted!!");
			return rowCount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 修改
	final String UPDATE = "update OrderList set OrderListNumber = ?, Ord_ProductID = ?, Ord_Unitprice = ?, Ord_Quantity = ? where Ord_ID = ?;";

	@Override
	public Integer modifyOrderlist(Orderlist orderlist) {
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(UPDATE);) {
			pstmt.setString(1, orderlist.getOderListnumber());
			pstmt.setString(2, orderlist.getOderProductid());
			pstmt.setInt(3, orderlist.getOderUnitprice());
			pstmt.setInt(4, orderlist.getOderQuantity());
			pstmt.setString(5, orderlist.getOderID());
			int rowCount = pstmt.executeUpdate();
			System.out.println(rowCount + " row(s) updated!!");
			return rowCount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}


}
