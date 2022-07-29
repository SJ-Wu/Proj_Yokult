package web.product.service.impl;

import java.util.Set;

import javax.naming.NamingException;

import web.product.dao.ProductDao;
import web.product.dao.impl.ProductDaoImpl;
import web.product.service.ProductService;
import web.product.vo.Product;

public class ProductServiceImpl implements ProductService{
	private ProductDao dao;
	
	public ProductServiceImpl() throws NamingException {
		dao = new ProductDaoImpl();
	}
	
	@Override
	public Set<Product> getAll(String category) {
		return dao.selectAll(category);
	}

}
