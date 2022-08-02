package web.product.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import web.product.vo.Product;

public class test {
	private Connection connection;
	 
	public static void main(String[] args) {
		  try {
			  Class.forName("com.mysql.cj.jdbc.Driver");
		  } catch (Exception e) {
		   System.out.println("driver fail");
		  }
		  
		  try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/YOKULT?serverTimezone=Asia/Taipei", "root", "password");
		    ){
			  //測試寫在這裡
			  final String SELECTALL = "Select PROID,PRONAME,PROSTOCK,PROPRICE,PROSPECS,PROBRAND,PROPICTURE,PROCATEGORY from PRODUCT";
				PreparedStatement ps = conn.prepareStatement(SELECTALL);
				
				try (ResultSet rs = ps.executeQuery()) {
					Set<Product> products = new HashSet<Product>();
					System.out.println("Show product list:");
					while(rs.next()) {
						Product p = new Product();
						p.setProID(rs.getInt("PROID"));
						p.setProName(rs.getString("PRONAME"));
						p.setProStock(rs.getInt("PROSTOCK"));
						p.setProPrice(rs.getInt("PROPRICE"));
						p.setProSpecs(rs.getString("PROSPECS"));
						p.setProBrand(rs.getString("PROBRAND"));
						p.setProPicture(rs.getString("PROPICTURE"));
						p.setProCategory(rs.getString("PROCATEGORY"));
						products.add(p);
						System.out.println(p);
			  
					}
			  
				} catch (SQLException e) {
					e.printStackTrace();
				}
		  } catch (SQLException e1) {
			e1.printStackTrace();
		}
	  }//main
		

}//
