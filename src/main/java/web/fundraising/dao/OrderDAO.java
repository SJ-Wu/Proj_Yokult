package web.fundraising.dao;

import java.util.List;

import web.fundraising.vo.OrderBean;

public interface OrderDAO {
	public abstract OrderBean insert(OrderBean orderBean);
	public abstract Boolean delete(int id);
	public abstract OrderBean update(int id, OrderBean orderBean);
	public abstract OrderBean select(int id);
	public abstract List<OrderBean> selectAll();
}
