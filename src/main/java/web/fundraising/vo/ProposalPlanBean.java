package web.fundraising.vo;

import java.io.Serializable;

public class ProposalPlanBean implements Serializable {
	private Integer fundID;
	private Integer propoID;
	
	
	public ProposalPlanBean() {}
	
	public ProposalPlanBean(Integer fundID, Integer propoID) {
		super();
		this.fundID = fundID;
		this.propoID = propoID;
	}


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
