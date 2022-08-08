package web.order.service;

import java.util.List;

import web.order.vo.Order;

public interface OrderService {
	List<Order> searchOrders();
	String addOrder(Order order);
	public Order selectOrderid(String orderid);
	List<Order> selectOrderStatus(String orderStatus);
}

