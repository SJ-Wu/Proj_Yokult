package web.product.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.product.dao.ProductDao;
import web.product.vo.Product;

public class ProductDaoImpl implements ProductDao {
	
	private DataSource datasource;

	public ProductDaoImpl() throws NamingException {
		datasource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/Yokult");
	}
	
//	final String SELECTALL = "Select PROID,PRONAME,PROSTOCK,PROPRICE,PROSPECS,PROBRAND,PROPICTURE,PROCATEGORY from PRODUCT";
	final String SELECTALL = "Select * from product";
	@Override
	public Set<Product> selectAll(String category) {
		
		try{
			Connection conn = datasource.getConnection();
		
				String query = SELECTALL;
				if(category != null ) {
					query +=  " Where procategory = '"+category+"'";
				}
				
				System.out.println(query);
				PreparedStatement ps = conn.prepareStatement(query);
			try (ResultSet rs = ps.executeQuery()) {
				Set<Product> products = new HashSet<Product>();
				System.out.println("Show product list:");
				while(rs.next()) {
					Product p = new Product();
					p.setProID(rs.getString("proid"));
					p.setProName(rs.getString("proname"));
					p.setProStock(rs.getInt("prostock"));
					p.setProPrice(rs.getInt("proprice"));
					p.setProSpecs(rs.getString("prospecs"));
					p.setProBrand(rs.getString("probrand"));
					p.setProPicture(rs.getString("propicture"));
					p.setProCategory(rs.getString("procategory"));
					products.add(p);
					System.out.println(p);
				}
				return products;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Integer insert(Product product) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Product selectByProductIdAndProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer update(Product product) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer delete(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

}	
