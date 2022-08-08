package web.order.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    // 回傳全部
	@Override
	public List<Order> searchOrders() {
		return orderDao.selectAll();
	}
	
	//回傳指定編號的訂單
	@Override
	public Order selectOrderid(String orderid) {
		List<Order> listall = orderDao.selectAll();
		for(Order order : listall) {
			if( orderid.equals(order.getOrdid())){
				return order;
			}
		}
		return null;
	}
	//回傳下拉選單類別查詢
	@Override
	public List<Order> selectOrderStatus(String orderStatus) {
		List<Order> listall = orderDao.selectAll();
		List<Order> listStatus = new ArrayList<Order>();
		for(Order order : listall) {
			if( orderStatus.equals(order.getOrderstatus())){
				listStatus.add(order);
			}
		}
		if(listStatus.size() > 0) {
			return listStatus;
		}
		return null;
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
