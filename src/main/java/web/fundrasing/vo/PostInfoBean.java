package web.fundrasing.vo;

import java.io.Serializable;

public class PostInfoBean implements Serializable {
	private Integer postID;
	private String postFisrtName;
	private String postLastName;
	private String postCellphone;
	private Integer cityID;
	private Integer districtID;
	private String postAddress;
	private Integer memID;
	
	
	@Override
	public String toString() {
		return "PostInfo [postID=" + postID + ", postFisrtName=" + postFisrtName + ", postLastName=" + postLastName
				+ ", postCellphone=" + postCellphone + ", cityID=" + cityID + ", districtID=" + districtID
				+ ", postAddress=" + postAddress + ", memID=" + memID + "]";
	}


	public Integer getPostID() {
		return postID;
	}


	public void setPostID(Integer postID) {
		this.postID = postID;
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


	public Integer getCityID() {
		return cityID;
	}


	public void setCityID(Integer cityID) {
		this.cityID = cityID;
	}


	public Integer getDistrictID() {
		return districtID;
	}


	public void setDistrictID(Integer districtID) {
		this.districtID = districtID;
	}


	public String getPostAddress() {
		return postAddress;
	}


	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}


	public Integer getMemID() {
		return memID;
	}


	public void setMemID(Integer memID) {
		this.memID = memID;
	}
	
	
}
