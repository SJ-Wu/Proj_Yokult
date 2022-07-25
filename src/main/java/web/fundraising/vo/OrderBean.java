package web.fundraising.vo;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

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
	private Date orderTimeStamp;
	private Integer orderAmount;
	private Integer proposalID;
	private Integer planID;
	private String memID;
	private Integer postID;
	//new java.sql.Date(System.currentTimeMillis());    <-----取得當前時間毫秒數
//	long long1 = System.currentTimeMillis();
//	java.sql.Timestamp ts = new java.sql.Timestamp(long1);
//	System.out.println(ts);
//	java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-mm-dd hh:mm:ss:SSS");
//	String str = df.format(ts);
//	System.out.println(str);
	

	public OrderBean() {}

	public OrderBean(String orderInvoiceNumber, Date orderTimeStamp, Integer orderAmount,
			Integer proposalID, Integer planID, String memID, Integer postID) {
		super();
		this.orderInvoiceNumber = orderInvoiceNumber;
		this.orderTimeStamp = orderTimeStamp;
		this.orderAmount = orderAmount;
		this.proposalID = proposalID;
		this.planID = planID;
		this.memID = memID;
		this.postID = postID;
	}
	
	public OrderBean(Integer orderID, String orderInvoiceNumber, Date orderTimeStamp, Integer orderAmount,
			Integer proposalID, Integer planID, String memID, Integer postID) {
		super();
		this.orderID = orderID;
		this.orderInvoiceNumber = orderInvoiceNumber;
		this.orderTimeStamp = orderTimeStamp;
		this.orderAmount = orderAmount;
		this.proposalID = proposalID;
		this.planID = planID;
		this.memID = memID;
		this.postID = postID;
	}

	@Override
	public String toString() {
		return "OrderBean [orderID=" + orderID + ", orderInvoiceNumber=" + orderInvoiceNumber + ", orderTimeStamp="
				+ orderTimeStamp + ", orderAmount=" + orderAmount + ", proposalID=" + proposalID + ", planID=" + planID
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
	public Date getOrderTimeStamp() {
		return orderTimeStamp;
	}
	public void setOrderTimeStamp(Date orderTimeStamp) {
		this.orderTimeStamp = orderTimeStamp;
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
