package web.fundrasing.vo;

import java.io.Serializable;

public class FundrasingMappingBean implements Serializable {
	private Integer fundID;
	private Integer propoID;
	
	
	@Override
	public String toString() {
		return "FundrasingMappingBean [fundID=" + fundID + ", propoID=" + propoID + "]";
	}
	
	
	public Integer getFundID() {
		return fundID;
	}
	public void setFundID(Integer fundID) {
		this.fundID = fundID;
	}
	public Integer getPropoID() {
		return propoID;
	}
	public void setPropoID(Integer propoID) {
		this.propoID = propoID;
	}
	
	


}
