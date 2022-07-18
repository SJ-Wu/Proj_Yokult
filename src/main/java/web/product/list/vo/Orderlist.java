package web.product.list.vo;

public class Orderlist {
//訂單
//@Data //get，set 方法
	private String oderListnumber;// 編號
	private String oderProductid;// 商品ID
	private Integer oderUnitprice;// 單價
	private Integer oderQuantity;// 數量
	private static String oderID;// 訂單編號

	public Orderlist() {

	}

	@Override
	public String toString() {
		return "Orderlist [oderListnumber=" + oderListnumber + ", oderProductid=" + oderProductid + ", oderID=" + oderID
				+ "]";
	}

	public String getOderListnumber() {
		return oderListnumber;
	}

	public void setOderListnumber(String oderListnumber) {
		this.oderListnumber = oderListnumber;
	}

	public String getOderProductid() {
		return oderProductid;
	}

	public void setOderProductid(String oderProductid) {
		this.oderProductid = oderProductid;
	}

	public Integer getOderUnitprice() {
		return oderUnitprice;
	}

	public void setOderUnitprice(int i) {
		this.oderUnitprice = i;
	}

	public Integer getOderQuantity() {
		return oderQuantity;
	}

	public void setOderQuantity(Integer oderQuantity) {
		this.oderQuantity = oderQuantity;
	}

	public static String getOderID() {
		return oderID;
	}

	public void setOderID(String oderID) {
		this.oderID = oderID;
	}
}
