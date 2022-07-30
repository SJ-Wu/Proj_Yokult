package web.order.service;

import java.util.List;

import web.order.vo.Order;

public interface OrderService {
	List<Order> searchOrders();
	String addOrder(Order order);
}
