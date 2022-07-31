package web.checkout.vo;
import java.util.List;

import web.order.vo.Order;
import web.orderlist.vo.Orderlist;

public class Checkout {
	private Order order;
	private List<Orderlist> orderlist;
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Orderlist> getOrderlist() {
		return orderlist;
	}

	public void setOrderlist(List<Orderlist> orderlist) {
		this.orderlist = orderlist;
	}

	@Override
	public String toString() {
		return "Checkout [order=" + order + ", orderlist=" + orderlist + "]";
	}
}
