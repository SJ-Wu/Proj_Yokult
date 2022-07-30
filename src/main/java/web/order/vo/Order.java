package web.order.vo;

import java.sql.Timestamp;

public class Order {

	private String ordID;
	private String memID;
	private String payMethod;
	private String orderStatus;
	private String addr;
	private String receipter;
	private Timestamp shoptime;
	private String cellphone;
	private String phone;

	
	
	@Override
	public String toString() {
		return "Order [ordID=" + ordID + ", memID=" + memID + ", payMethod=" + payMethod + ", orderStatus="
				+ orderStatus + ", addr=" + addr + ", receipter=" + receipter + ", shoptime=" + shoptime
				+ ", cellphone=" + cellphone + ", phone=" + phone + "]";
	}

	public String getOrdID() {
		return ordID;
	}

	public void setOrdID(String ordID) {
		this.ordID = ordID;
	}

	public String getMemID() {
		return memID;
	}

	public void setMemID(String memID) {
		this.memID = memID;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getReceipter() {
		return receipter;
	}

	public void setReceipter(String receipter) {
		this.receipter = receipter;
	}

	public Timestamp getShoptime() {
		return shoptime;
	}

	public void setShoptime(Timestamp shoptime) {
		this.shoptime = shoptime;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
