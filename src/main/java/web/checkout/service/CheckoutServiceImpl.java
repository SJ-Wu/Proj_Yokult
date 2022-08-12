package web.checkout.service;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import web.checkout.vo.Checkout;
import web.order.dao.OrderDaoJDBC;
import web.order.service.OrderService;
import web.order.service.OrderServiceImpl;
import web.order.vo.Order;
import web.orderlist.service.OrderlistService;
import web.orderlist.service.impl.OrderlistServiceImpl;
import web.orderlist.vo.OrderlistView;

public class CheckoutServiceImpl implements CheckoutService {
	private OrderService orderService;
	private OrderlistService orderlistService;
	private OrderDaoJDBC dao = new OrderDaoJDBC();
	
//	
//	Order order = new Order();
//	List<String> list = new ArrayList<>();
	public CheckoutServiceImpl() throws NamingException {
		orderService = new OrderServiceImpl();
		orderlistService = new OrderlistServiceImpl();
	}

	@Override
	public String processCheckout(Checkout checkout) { 
		List<String> list = new ArrayList<>();
		if ("Success".equals(orderService.addOrder(checkout.getOrder()))) {
			if ("Success".equals(orderlistService.addOrderlist(checkout.getOrderlist(), checkout.getOrder().getOrdid()))) {
				List<OrderlistView>orderlistView = orderlistService.searchOrderlistViewByOrdid(checkout.getOrder().getOrdid());
				for (OrderlistView item: orderlistView) {
					list.add(item.getProName());
				}
				return orderService.ecpayValidation(list,checkout.getOrder(),checkout.getTotalCount()); // get到ordertotal，從orderdaojdbc 撰寫 checkout.getTotalCount()
			}
		}
		return "False";
	}
	
	
}
