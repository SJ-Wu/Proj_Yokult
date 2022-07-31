package web.order.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.naming.NamingException;

import web.order.dao.OrderDao;
import web.order.dao.OrderDaoJDBC;
import web.order.vo.Order;

public class OrderServiceImpl implements OrderService {
	private OrderDao orderDao;

	public OrderServiceImpl() throws NamingException {
		orderDao = new OrderDaoJDBC();

	}

	@Override
	public List<Order> searchOrders() {
		return orderDao.selectAll();
	}

	@Override
	public String addOrder(Order order) {
		order.setOrdid(genOrderid(order.getMemid()));
		order.setOrderstatus("processing");
		order.setShoptime(new java.sql.Timestamp(new Date().getTime()));
		if (orderDao.insert(order) > 0) {
			return "Success";
		}
		return "Fail";
	}

	private String genOrderid(String memid) {
		StringBuilder orderid = new StringBuilder();
		SimpleDateFormat sDateFormat = new SimpleDateFormat("yyMMddHHmmss");
		orderid.append(memid);
		orderid.append("_");
		orderid.append(sDateFormat.format(new Date()));
		return orderid.toString();
	}
}
