package web.fundrasing.vo;

import java.io.Serializable;


public class ProposalStatusBean implements Serializable {
	
	private Integer statusID;
	private String statusName;
	
	@Override
	public String toString() {
		return "ProposalStatus [statusID=" + statusID + ", statusName=" + statusName + "]";
	}
	
	public Integer getStatusID() {
		return statusID;
	}
	public void setStatusID(Integer statusID) {
		this.statusID = statusID;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
}
