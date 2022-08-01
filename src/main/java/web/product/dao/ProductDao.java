package web.product.dao;

import java.util.List;
import java.util.Set;

import web.product.vo.Product;

public interface ProductDao {
	Integer insert(Product product);

	Product selectByProductIdAndProduct(Product product);

	Integer update(Product product);

	Integer delete(Product product);

	List<Product> selectAll(String category, String productName);

}
