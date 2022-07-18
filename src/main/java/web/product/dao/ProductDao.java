package web.product.dao;

import java.util.Set;

import web.product.vo.Product;

public interface ProductDao {
	Integer insert (Product product);
	Product selectByProductIdAndProduct(Product product);
	Set<Product> selectAll();
	Integer update (Product product);
	Integer delete (Product product);

}
