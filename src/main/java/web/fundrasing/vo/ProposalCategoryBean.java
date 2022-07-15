package web.fundrasing.vo;

import java.io.Serializable;

public class ProposalCategoryBean implements Serializable {
	private Integer propoCategoryID;
	private String propoName;
	
	
	@Override
	public String toString() {
		return "ProposalCategoryBean [propoCategoryID=" + propoCategoryID + ", propoName=" + propoName + "]";
	}
	
	
	public Integer getPropoCategoryID() {
		return propoCategoryID;
	}
	public void setPropoCategoryID(Integer propoCategoryID) {
		this.propoCategoryID = propoCategoryID;
	}
	public String getPropoName() {
		return propoName;
	}
	public void setPropoName(String propoName) {
		this.propoName = propoName;
	}
}
