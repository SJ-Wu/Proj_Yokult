package web.orderlist.service.impl;

import java.util.Objects;

import javax.naming.NamingException;

import web.orderlist.dao.OrderlistDao;
import web.orderlist.dao.impl.OrderlistDaoJDBC;
import web.orderlist.service.OrderlistService;
import web.orderlist.vo.Orderlist;

public class OrderlistServiceImpl implements OrderlistService {
	private OrderlistDao dao; // 把 dao 變成一個屬性

	public OrderlistServiceImpl() throws NamingException {
		dao = new OrderlistDaoJDBC();
	}

	@Override
	// 查詢
	public Orderlist searchOrderlist(Orderlist orderlist) {
		if (orderlist != null) {
			String id = orderlist.getOderID();
			System.out.println("service id: " + id);
			if (checkValue(id)) {
				return dao.searchOrderlist(orderlist);
			}
		}
		return null;
	}

	private boolean checkValue(String value) {
		if (value == null || Objects.equals(value, "")) {
			System.out.println(value);
			return false;
		}
		return true;
	}

	@Override
	// 新增
	public Integer insertOrderlist(Orderlist orderlist) {
		if (orderlist != null) {
			String id = orderlist.getOderID();
			if (checkValue(id)) {
				if (dao.searchOrderlist(orderlist) == null) {
					return dao.insertOrderlist(orderlist);
				}
			}
		}
		return -1;
	}

	@Override
	// 刪除
	public Integer deleteOrderlist(Orderlist orderlist) {
		if (orderlist != null) {
			String id = orderlist.getOderID();
			if (checkValue(id)) {
				if (dao.searchOrderlist(orderlist) != null) {
					return dao.deleteOrderlist(orderlist);
				}
			}
		}
		return -1;
	}

	// 修改
	public Integer modifyOrderlist(Orderlist orderlist) {
		if (orderlist != null) {
			String id = orderlist.getOderID();
			if (checkValue(id)) {
				return dao.modifyOrderlist(orderlist);

			}
		}
		return -1;

	}

}
