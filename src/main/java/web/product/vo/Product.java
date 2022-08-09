package web.product.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "proid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer proID;
	
	@Column(name="proname")
	private String proName;
	
	@Column(name = "prostock")
	private Integer proStock;
	
	@Column(name = "proprice")
	private Integer proPrice;
	
	@Column(name = "prospecs")
	private String proSpecs;
	
	@Column(name = "probrand")
	private String proBrand;
	
	@Column(name = "propicture")
	private String proPicture;
	
	@Column(name = "procategory")
	private String proCategory;
	
	@Override
	public String toString() {
		return "Product [proID=" + proID + ", proName=" + proName + ", proStock=" + proStock + ", proPrice=" + proPrice
				+ ", proSpecs=" + proSpecs + ", proBrand=" + proBrand + ", proPicture=" + proPicture
				+ ", proCategory=" + proCategory + "]";
	}

	public Integer getProID() {
		return proID;
	}

	public void setProID(Integer proID) {
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

	public String getProPicture() {
		return proPicture;
	}

	public void setProPicture(String proPicture) {
		this.proPicture = proPicture;
	}

	public String getProCategory() {
		return proCategory;
	}

	public void setProCategory(String proCategory) {
		this.proCategory = proCategory;
	}

	
		
	

	
	
		
	
		
	}



