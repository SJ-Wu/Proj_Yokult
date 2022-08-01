package web.product.service;

import java.util.List;
import java.util.Set;

import web.product.vo.Product;


public interface ProductService {

	List<Product>  getAll(String category, String productName);
	
	void save(Product product);
}
