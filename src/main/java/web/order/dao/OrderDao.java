package web.order.dao;

import java.util.List;

import web.order.vo.Order;
import web.orderlist.vo.Orderlist;

public interface OrderDao {
	Integer insert(Order order);

	List<Order> selectAll();

	Integer insert(Orderlist orderlist);
}
