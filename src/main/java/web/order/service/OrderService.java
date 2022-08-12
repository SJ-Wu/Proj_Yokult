package web.order.service;

import java.util.List;

import web.order.vo.Order;

public interface OrderService {
	List<Order> searchOrders();
	String addOrder(Order order);
	public Order selectOrderid(String orderid);
	List<Order> selectOrderStatus(String orderStatus);
//	public String ecpayValidation(List<String> proname, Integer orderid, Order order, String totalCount);
//	String ecpayValidation(List<String> list, String count, Order order, String totalCount);
	String ecpayValidation(List<String> list, Order order, String string);
}

