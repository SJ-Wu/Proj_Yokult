package web.product.service;

import java.util.Set;

import web.product.vo.Product;


public interface ProductService {

	Set<Product> getAll(String category);
}
