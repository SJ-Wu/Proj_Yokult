package web.checkout.service;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import web.checkout.vo.Checkout;
import web.order.service.OrderService;
import web.order.service.OrderServiceImpl;
import web.order.vo.Order;
import web.orderlist.service.OrderlistService;
import web.orderlist.service.impl.OrderlistServiceImpl;

public class CheckoutServiceImpl implements CheckoutService {
	private OrderService orderService;
	private OrderlistService orderlistService;
	Order order = new Order();
	List<String> list = new ArrayList<>();
	public CheckoutServiceImpl() throws NamingException {
		orderService = new OrderServiceImpl();
		orderlistService = new OrderlistServiceImpl();
	}

	@Override
	public String processCheckout(Checkout checkout) {
		Integer count = 123;
		if ("Success".equals(orderService.addOrder(checkout.getOrder()))) {
			if ("Success".equals(orderlistService.addOrderlist(checkout.getOrderlist(), checkout.getOrder().getOrdid()))) {
				list.add("HI");
				orderService.ecpayValidation(list,count,order,"123456");
				return "Success";
			}
		}
		return "False";
	}
	
	
}
