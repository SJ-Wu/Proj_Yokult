package web.product.list.vo;

public class Product {
	//商品
	private static String PROID;//商品ID
	private static String PRONAME;//商品名稱
	private Integer PROSTOCK;//商品庫存
	private Integer PROPRICE;//商品定價
	private String PROSPECS;//商品規格
	private String PROBRAND;//商品品牌
	private String PROPICTURE;//商品圖片
	private String PROCATEGORY;//商品類別
	
	public Product() {
		
	}
	@Override
	public String toString() {
		return "Product [PROID=" + PROID + ", PRONAME=" + PRONAME +", PROSPECS=" + PROSPECS +", PROBRAND=" + PROBRAND +", PROPICTURE=" + PROPICTURE +", PROCATEGORY=" + PROCATEGORY +"]"; 
	}
	public static String getPROID() {
		return PROID;
	}
	public void setPROID(String pROID) {
		PROID = pROID;
	}
	public static String getPRONAME() {
		return PRONAME;
	}
	public void setPRONAME(String pRONAME) {
		PRONAME = pRONAME;
	}
	public Integer getPROSTOCK() {
		return PROSTOCK;
	}
	public void setPROSTOCK(Integer pROSTOCK) {
		PROSTOCK = pROSTOCK;
	}
	public String getPROSPECS() {
		return PROSPECS;
	}
	public void setPROSPECS(String pROSPECS) {
		PROSPECS = pROSPECS;
	}
	public Integer getPROPRICE() {
		return PROPRICE;
	}
	public void setPROPRICE(Integer pROPRICE) {
		PROPRICE = pROPRICE;
	}
	public String getPROPICTURE() {
		return PROPICTURE;
	}
	public void setPROPICTURE(String pROPICTURE) {
		PROPICTURE = pROPICTURE;
	}
	public String getPROBRAND() {
		return PROBRAND;
	}
	public void setPROBRAND(String pROBRAND) {
		PROBRAND = pROBRAND;
	}
	public String getPROCATEGORY() {
		return PROCATEGORY;
	}
	public void setPROCATEGORY(String pROCATEGORY) {
		PROCATEGORY = pROCATEGORY;
	}

}
