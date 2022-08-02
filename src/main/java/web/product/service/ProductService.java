package web.product.service;

import java.util.List;

import web.product.vo.Product;


public interface ProductService {

	List<Product>  getAll(String category, String productName);
	
	void save(Product product);
	
	Integer add(Product product);
}