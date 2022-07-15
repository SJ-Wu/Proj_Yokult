package web.fundrasing.vo;

import java.io.Serializable;
import java.sql.Date;

public class OrderBean implements Serializable {
	private Integer orderID;
	private Integer	propoID;
	private Integer fundID;
	private Integer memID;
	private String orderPayment;
	private Date orderDate;
	private Integer PostID;
	
	
	@Override
	public String toString() {
		return "OrderBean [orderID=" + orderID + ", propoID=" + propoID + ", fundID=" + fundID + ", memID=" + memID
				+ ", orderPayment=" + orderPayment + ", orderDate=" + orderDate + ", PostID=" + PostID + "]";
	}
	
	
	public Integer getOrderID() {
		return orderID;
	}
	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}
	public Integer getPropoID() {
		return propoID;
	}
	public void setPropoID(Integer propoID) {
		this.propoID = propoID;
	}
	public Integer getFundID() {
		return fundID;
	}
	public void setFundID(Integer fundID) {
		this.fundID = fundID;
	}
	public Integer getMemID() {
		return memID;
	}
	public void setMemID(Integer memID) {
		this.memID = memID;
	}
	public String getOrderPayment() {
		return orderPayment;
	}
	public void setOrderPayment(String orderPayment) {
		this.orderPayment = orderPayment;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Integer getPostID() {
		return PostID;
	}
	public void setPostID(Integer postID) {
		PostID = postID;
	}
	
}
