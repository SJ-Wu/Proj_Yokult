package web.orderlist.service.impl;

import java.util.List;
import java.util.Objects;

import javax.naming.NamingException;

import web.orderlist.dao.OrderlistDao;
import web.orderlist.dao.impl.OrderlistDaoJDBC;
import web.orderlist.service.OrderlistService;
import web.orderlist.vo.Orderlist;

public class OrderlistServiceImpl implements OrderlistService {
	private OrderlistDao orderlistDao; // 把 dao 變成一個屬性

	public OrderlistServiceImpl() throws NamingException {
		orderlistDao = new OrderlistDaoJDBC();
	}

	@Override
	// 查詢
	public List<Orderlist> searchOrderlistByOrdid(String orderID) {
		if (checkValue(orderID)) {
			Orderlist orderlist = new Orderlist();
			orderlist.setOrdID(orderID);
			return orderlistDao.searchOrderlist(orderlist);
		}
		return null;
	}

	private boolean checkValue(String value) {
		if (value == null || Objects.equals(value, "")) {
			System.out.println("[Error] Input null value");
			return false;
		}
		return true;
	}

	@Override
	// 新增
	public Integer insertOrderlist(Orderlist orderlist) {
		// TODO: validation flow
		// 1. Check orderid is valid
		// 2. Check proid is valid
		return orderlistDao.insertOrderlist(orderlist);
	}

	@Override
	// 刪除
	public Integer deleteOrderlist(Orderlist orderlist) {
		if (orderlist != null) {
			String id = orderlist.getOrdID();
			if (checkValue(id)) {
				if (orderlistDao.searchOrderlist(orderlist) != null) {
					return orderlistDao.deleteOrderlist(orderlist);
				}
			}
		}
		return -1;
	}

	// 修改
	public Integer modifyOrderlist(Orderlist orderlist) {
		if (orderlist != null) {
			String id = orderlist.getProID();
			if (checkValue(id)) {
				return orderlistDao.modifyOrderlist(orderlist);

			}
		}
		return -1;

	}

}
