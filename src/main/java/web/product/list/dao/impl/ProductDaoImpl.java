package web.product.list.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.product.list.vo.Product;

public class ProductDaoImpl {
private DataSource dataSource;
	
	//新增
	public ProductDaoImpl() throws NamingException {
		dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/YOKULT");
	}

	public Integer insert(Product product) {
		try (Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(
						"insert into product.list (PROID, PRONAME, PROSTOCK, PROPRICE, PROSPECS, PROBRAND, PROPICTURE, PROCATEGORY)"
								+ "values (?, ?, ?, ?, ?, ?, ?, ?);");) {
			ps.setString(1, Product.getPROID());
			ps.setString(2, Product.getPRONAME());
			ps.setInt(3, product.getPROSTOCK());
			ps.setInt(4, product.getPROPRICE());
			ps.setString(5, product.getPROSPECS());
			ps.setString(6, product.getPROBRAND());
			ps.setString(7, product.getPROPICTURE());
			ps.setString(8, product.getPROCATEGORY());
			int rowCount = ps.executeUpdate();
			System.out.println("insert " + rowCount + "product.list.");
			return rowCount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	// 查询
	final String SELECT = "Select PROID, PRONAME, PROSTOCK, PROPRICE, PROSPECS, PROBRAND, PROPICTURE, PROCATEGORY ADDR from OrderList where PROID = ?";

	public Product insert1(Product product) {
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(SELECT);) {
			pstmt.setString(1, Product.getPROID());
			pstmt.setString(2, Product.getPRONAME());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					System.out.println("存取成功");
					Product resultProduct  = new Product();
					resultProduct.setPROID(rs.getString("PROID"));
					resultProduct.setPRONAME(rs.getString("PRONAME"));
					resultProduct.setPROSTOCK(rs.getInt("PROSTOCK"));
					resultProduct.setPROPRICE(rs.getInt("PROPRICE"));
					resultProduct.setPROSPECS(rs.getString("PROSPECS"));
					resultProduct.setPROBRAND(rs.getString("PROBRAND"));
					resultProduct.setPROPICTURE(rs.getString("PROPICTURE"));
					resultProduct.setPROCATEGORY(rs.getString("PROCATEGORY"));
					

					return resultProduct;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
    //删除
	final String DELETE = "delete Product where PROID = ?";
	
	 public Integer delete(Product product) {
	  try (Connection conn = dataSource.getConnection();
	    PreparedStatement pstmt = conn.prepareStatement(DELETE);) {
	   pstmt.setString(1, Product.getPROID());
	   pstmt.setString(2, Product.getPRONAME());
	   int rowCount = pstmt.executeUpdate();
	   System.out.println(rowCount + " row(s) deleted!!");
	   return rowCount;
	  }catch (Exception e) {
	   e.printStackTrace();
	  }
	  return 0;
	 }
	 
	//修改
	 final String UPDATE = "update Product set PROID = ?, PRONAME = ?, PROSTOCK = ?, PROPRICE = ?, PROSPECS = ?, PROBRAND = ?, PROPICTURE = ?, PROCATEGORY = ?;";
		
		public Integer update(Product product) {
			try (Connection conn = dataSource.getConnection();
					PreparedStatement pstmt = conn
							.prepareStatement(UPDATE);){
				pstmt.setString(1, Product.getPROID());
				pstmt.setString(2, Product.getPRONAME());
				pstmt.setInt(3, product.getPROSTOCK());
				pstmt.setInt(4, product.getPROPRICE());
				pstmt.setString(5, product.getPROSPECS());
				pstmt.setString(6, product.getPROBRAND());
				pstmt.setString(7, product.getPROPICTURE());
				pstmt.setString(8, product.getPROCATEGORY());
				int rowCount = pstmt.executeUpdate();
				System.out.println(rowCount + " row(s) updated!!");
				return rowCount;
			}catch (Exception e) {
				e.printStackTrace();
			}
			return -1;
		}
		
		
				
}


