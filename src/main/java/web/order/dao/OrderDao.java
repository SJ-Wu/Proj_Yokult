package web.order.dao;

import java.util.List;

import web.order.vo.Order;

public interface OrderDao {
	Integer insert(Order order);

	List<Order> selectAll();
}
