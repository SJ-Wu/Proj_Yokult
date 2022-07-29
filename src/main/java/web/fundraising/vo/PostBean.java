package web.fundraising.vo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Fund_POST")
public class PostBean implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postID;
	private String postFisrtName;
	private String postLastName;
	private String postCellphone;
	private String cityName;
	private String districtName;
	private String postAddress;
	private String memID;
	
	
	
	@Override
	public String toString() {
		return "PostBean [postID=" + postID + ", postFisrtName=" + postFisrtName + ", postLastName=" + postLastName
				+ ", postCellphone=" + postCellphone + ", cityName=" + cityName + ", districtName=" + districtName
				+ ", postAddress=" + postAddress + ", memID=" + memID + "]";
	}

	public PostBean() {}
	
	public PostBean(String postFisrtName, String postLastName, String postCellphone,
			String cityName, String districtName, String postAddress, String memID) {
		super();
		this.postFisrtName = postFisrtName;
		this.postLastName = postLastName;
		this.postCellphone = postCellphone;
		this.cityName = cityName;
		this.districtName = districtName;
		this.postAddress = postAddress;
		this.memID = memID;
	}
	
	public Integer getPostID() {
		return postID;
	}
	public String getPostFisrtName() {
		return postFisrtName;
	}
	public void setPostFisrtName(String postFisrtName) {
		this.postFisrtName = postFisrtName;
	}
	public String getPostLastName() {
		return postLastName;
	}
	public void setPostLastName(String postLastName) {
		this.postLastName = postLastName;
	}
	public String getPostCellphone() {
		return postCellphone;
	}
	public void setPostCellphone(String postCellphone) {
		this.postCellphone = postCellphone;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getPostAddress() {
		return postAddress;
	}
	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}
	public String getMemID() {
		return memID;
	}
	public void setMemID(String memID) {
		this.memID = memID;
	}

}
