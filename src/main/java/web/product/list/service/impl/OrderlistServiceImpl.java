package web.product.list.service.impl;

import java.util.Objects;

import javax.naming.NamingException;

import web.product.list.dao.OrderlistDao;
import web.product.list.dao.impl.OrderlistDaoImpl;
import web.product.list.service.OrderlistService;
import web.product.list.vo.Orderlist;

public class OrderlistServiceImpl implements OrderlistService {
	private OrderlistDao dao; // 把 dao 變成一個屬性

	public OrderlistServiceImpl() throws NamingException {
		dao = new OrderlistDaoImpl();
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
