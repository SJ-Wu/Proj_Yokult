package web.product.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.member.vo.Member;
import web.product.dao.ProductDao;
import web.product.vo.Product;

public abstract class ProductDaoImpl implements ProductDao {
	
	private DataSource datasource;

	public ProductDaoImpl() throws NamingException {
		datasource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/Yokult");
	}
	
	final String SELECTALL = "Select PROID,PRONAME,PROSTOCK,PROPRICE,PROSPECS,PROBRAND,PROPICTURE,PROCATEGORY from PRODUCT";
	@Override
	public Set<Product> selectAll() {
		try(Connection conn = datasource.getConnection();
				PreparedStatement ps = conn.prepareStatement(SELECTALL);) {
			try (ResultSet rs = ps.executeQuery()) {
				Set<Product> products = new HashSet<Product>();
				System.out.println("Show product list:");
				while(rs.next()) {
					Product p = new Product();
					p.setProID(rs.getString("PROID"));
					p.setProName(rs.getString("PRONAME"));
					p.setProStock(rs.getInt("PROSTOCK"));
					p.setProPrice(rs.getInt("PROPRICE"));
					p.setProSpecs(rs.getString("PROSPECS"));
					p.setProBrand(rs.getString("PROBRAND"));
					p.setProPicture(rs.getBytes("PROPICTURE"));
					p.setProCategory(rs.getString("PROCATEGORY"));
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

}	
