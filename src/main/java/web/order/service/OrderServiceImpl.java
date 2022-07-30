package web.order.service;

import java.util.List;

import javax.naming.NamingException;

import web.order.dao.OrderDao;
import web.order.dao.OrderDaoJDBC;
import web.order.vo.Order;

public class OrderServiceImpl implements OrderService{
	private OrderDao dao;
	
	public OrderServiceImpl() throws NamingException {
		dao = new OrderDaoJDBC();
	}
	
	@Override
	public List<Order> searchOrders() {
		return dao.selectAll();
	}

	@Override
	public String addOrder(Order order) {
		if (dao.insert(order) > 0) {
			return "Success";
		}
		return "Fail";
	}

}
