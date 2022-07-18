package web.product.list.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.product.list.vo.Orderlist;

public class OrderlistDaoImpl {
	private DataSource dataSource;
	
	//新增
	public OrderlistDaoImpl() throws NamingException {
		dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/YOKULT");
	}

	public Integer insert(Orderlist list) {
		try (Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(
						"insert into product.list (OrderListNumber, Ord_ProductID, Ord_Unitprice, Ord_Quantity, Ord_ID)"
								+ "values (?, ?, ?, ?, ?);");) {
			ps.setString(1, list.getOderListnumber());
			ps.setString(2, Orderlist.getOderID());
			ps.setInt(3, list.getOderUnitprice());
			ps.setInt(4, list.getOderQuantity());
			ps.setString(5, Orderlist.getOderID());
			int rowCount = ps.executeUpdate();
			System.out.println("insert " + rowCount + "product.list.");
			return rowCount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	// 查询
	final String SELECT = "Select OrderListNumber, Ord_ProductID, Ord_Unitprice, Ord_Quantity, Ord_ID ADDR from OrderList where OderID = ?";

	public Orderlist insert1(Orderlist list) {
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(SELECT);) {
			pstmt.setString(1, Orderlist.getOderID());
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
	
    //删除
	final String DELETE = "delete OrderList where OderID = ?";
	
	 public Integer delete(Orderlist list) {
	  try (Connection conn = dataSource.getConnection();
	    PreparedStatement pstmt = conn.prepareStatement(DELETE);) {
	   pstmt.setString(1, Orderlist.getOderID());
	   int rowCount = pstmt.executeUpdate();
	   System.out.println(rowCount + " row(s) deleted!!");
	   return rowCount;
	  }catch (Exception e) {
	   e.printStackTrace();
	  }
	  return 0;
	 }
	 
	//修改
	 final String UPDATE = "update OrderList set OrderListNumber = ?, Ord_ProductID = ?, Ord_Unitprice = ?, Ord_Quantity = ?;";
		
		public Integer update(Orderlist list) {
			try (Connection conn = dataSource.getConnection();
					PreparedStatement pstmt = conn
							.prepareStatement(UPDATE);){
				pstmt.setString(1, list.getOderListnumber());
				pstmt.setString(2, Orderlist.getOderID());
				pstmt.setInt(3, list.getOderUnitprice());
				pstmt.setInt(4, list.getOderQuantity());
				pstmt.setString(5, Orderlist.getOderID());
				int rowCount = pstmt.executeUpdate();
				System.out.println(rowCount + " row(s) updated!!");
				return rowCount;
			}catch (Exception e) {
				e.printStackTrace();
			}
			return -1;
		}
}
