package web.product.vo;

import java.io.Serializable;
import java.util.Arrays;


public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String proID;
	private String proName;
	private Integer proStock;
	private Integer proPrice;
	private String proSpecs;
	private String proBrand;
	private byte[] proPicture;
	private String proCategory;
	
	@Override
	public String toString() {
		return "Product [proID=" + proID + ", proName=" + proName + ", proStock=" + proStock + ", proPrice=" + proPrice
				+ ", proSpecs=" + proSpecs + ", proBrand=" + proBrand + ", proPicture=" + Arrays.toString(proPicture)
				+ ", proCategory=" + proCategory + "]";
	}

	public String getProID() {
		return proID;
	}

	public void setProID(String proID) {
		this.proID = proID;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public Integer getProStock() {
		return proStock;
	}

	public void setProStock(Integer proStock) {
		this.proStock = proStock;
	}

	public Integer getProPrice() {
		return proPrice;
	}

	public void setProPrice(Integer proPrice) {
		this.proPrice = proPrice;
	}

	public String getProSpecs() {
		return proSpecs;
	}

	public void setProSpecs(String proSpecs) {
		this.proSpecs = proSpecs;
	}

	public String getProBrand() {
		return proBrand;
	}

	public void setProBrand(String proBrand) {
		this.proBrand = proBrand;
	}

	public byte[] getProPicture() {
		return proPicture;
	}

	public void setProPicture(byte[] proPicture) {
		this.proPicture = proPicture;
	}

	public String getProCategory() {
		return proCategory;
	}

	public void setProCategory(String proCategory) {
		this.proCategory = proCategory;
	}

	
		
	

	
	
		
	
		
	}



