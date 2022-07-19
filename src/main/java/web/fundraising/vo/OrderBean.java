package web.fundraising.vo;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Fund_ORDER")
public class OrderBean implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderID;
	private String orderInvoiceNumber;
	private Date orderTimeStampt;
	private Integer orderAmount;
	private Integer proposalID;
	private Integer planID;
	private String memID;
	private Integer postID;
	
	@Override
	public String toString() {
		return "OrderBean [orderID=" + orderID + ", orderInvoiceNumber=" + orderInvoiceNumber + ", orderTimeStampt="
				+ orderTimeStampt + ", orderAmount=" + orderAmount + ", proposalID=" + proposalID + ", planID=" + planID
				+ ", memID=" + memID + ", postID=" + postID + "]";
	}
	
	public Integer getOrderID() {
		return orderID;
	}
	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}
	public String getOrderInvoiceNumber() {
		return orderInvoiceNumber;
	}
	public void setOrderInvoiceNumber(String orderInvoiceNumber) {
		this.orderInvoiceNumber = orderInvoiceNumber;
	}
	public Date getOrderTimeStampt() {
		return orderTimeStampt;
	}
	public void setOrderTimeStampt(Date orderTimeStampt) {
		this.orderTimeStampt = orderTimeStampt;
	}
	public Integer getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(Integer orderAmount) {
		this.orderAmount = orderAmount;
	}
	public Integer getProposalID() {
		return proposalID;
	}
	public void setProposalID(Integer proposalID) {
		this.proposalID = proposalID;
	}
	public Integer getPlanID() {
		return planID;
	}
	public void setPlanID(Integer planID) {
		this.planID = planID;
	}
	public String getMemID() {
		return memID;
	}
	public void setMemID(String memID) {
		this.memID = memID;
	}
	public Integer getPostID() {
		return postID;
	}
	public void setPostID(Integer postID) {
		this.postID = postID;
	}
	
}
