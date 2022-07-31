package web.checkout.service;

import javax.naming.NamingException;

import web.checkout.vo.Checkout;
import web.order.service.OrderService;
import web.order.service.OrderServiceImpl;
import web.orderlist.service.OrderlistService;
import web.orderlist.service.impl.OrderlistServiceImpl;

public class CheckoutServiceImpl implements CheckoutService {
	private OrderService orderService;
	private OrderlistService orderlistService;

	public CheckoutServiceImpl() throws NamingException {
		orderService = new OrderServiceImpl();
		orderlistService = new OrderlistServiceImpl();
	}

	@Override
	public String processCheckout(Checkout checkout) {
		if ("Success".equals(orderService.addOrder(checkout.getOrder()))) {
			if ("Success".equals(orderlistService.addOrderlist(checkout.getOrderlist(), checkout.getOrder().getOrdid()))) {
				return "Success";
			}
		}
		return "False";
	}
	
	
}
