package web.orderlist.vo;

public class Orderlist {
	private Integer orderlistid; // 訂單商品編號
	private String proid;// 商品ID
	private Integer proprice;// 商品價格
	private Integer quantity;// 訂購數量
	private String ordid;// 訂單

	@Override
	public String toString() {
		return "Orderlist [orderlistid=" + orderlistid + ", proid=" + proid + ", proprice=" + proprice + ", quantity="
				+ quantity + ", ordid=" + ordid + "]";
	}

	public Integer getOrderlistid() {
		return orderlistid;
	}

	public void setOrderlistid(Integer orderlistid) {
		this.orderlistid = orderlistid;
	}

	public String getProid() {
		return proid;
	}

	public void setProid(String proid) {
		this.proid = proid;
	}

	public Integer getProprice() {
		return proprice;
	}

	public void setProprice(Integer proprice) {
		this.proprice = proprice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getOrdid() {
		return ordid;
	}

	public void setOrdid(String ordid) {
		this.ordid = ordid;
	}

}
