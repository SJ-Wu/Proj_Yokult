package web.orderlist.vo;

public class OrderlistView {
	private String ordid;
	private Integer orderlistid; // 訂單商品編號
	private String proName;// 商品ID
	private Integer quantity;// 訂購數量
	
	@Override
	public String toString() {
		return "OrderlistView [ordid=" + ordid + ", orderlistid=" + orderlistid + ", proName=" + proName + ", quantity="
				+ quantity + "]";
	}

	public String getOrdid() {
		return ordid;
	}

	public void setOrdid(String ordid) {
		this.ordid = ordid;
	}

	public Integer getOrderlistid() {
		return orderlistid;
	}

	public void setOrderlistid(Integer orderlistid) {
		this.orderlistid = orderlistid;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}

