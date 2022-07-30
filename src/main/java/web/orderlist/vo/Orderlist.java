package web.orderlist.vo;

public class Orderlist {
	private Integer orderlistID; // 訂單商品編號
	private String proID;// 商品ID
	private Integer proPrice;// 商品價格
	private Integer quantity;// 訂購數量
	private String ordID;//訂單ID
	
	public Integer getOrderlistID() {
		return orderlistID;
	}
	public void setOrderlistID(Integer orderlistID) {
		this.orderlistID = orderlistID;
	}
	public String getProID() {
		return proID;
	}
	public void setProID(String proID) {
		this.proID = proID;
	}
	public Integer getProPrice() {
		return proPrice;
	}
	public void setProPrice(Integer proPrice) {
		this.proPrice = proPrice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getOrdID() {
		return ordID;
	}
	public void setOrdID(String ordID) {
		this.ordID = ordID;
	}

	
}
