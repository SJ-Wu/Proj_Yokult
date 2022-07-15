package web.fundrasing.vo;

import java.io.Serializable;
import java.sql.Date;

public class FundrasingPlanBean implements Serializable {
	private Integer fundID;
	private String fundName;
	private Integer fundAmount;
	private String fundContent;
	private Date fundStartedDate;
	private String fundEndedDate;
	private Integer statusID;
	private String fundPostNote;
	private String fundAttendeeCount;
	private Integer	propoID;
	
	
	@Override
	public String toString() {
		return "FundrasingPlanBean [fundID=" + fundID + ", fundName=" + fundName + ", fundAmount=" + fundAmount
				+ ", fundContent=" + fundContent + ", fundStartedDate=" + fundStartedDate + ", fundEndedDate="
				+ fundEndedDate + ", statusID=" + statusID + ", fundPostNote=" + fundPostNote + ", fundAttendeeCount="
				+ fundAttendeeCount + ", propoID=" + propoID + "]";
	}
	
	
	public Integer getFundID() {
		return fundID;
	}
	public void setFundID(Integer fundID) {
		this.fundID = fundID;
	}
	public String getFundName() {
		return fundName;
	}
	public void setFundName(String fundName) {
		this.fundName = fundName;
	}
	public Integer getFundAmount() {
		return fundAmount;
	}
	public void setFundAmount(Integer fundAmount) {
		this.fundAmount = fundAmount;
	}
	public String getFundContent() {
		return fundContent;
	}
	public void setFundContent(String fundContent) {
		this.fundContent = fundContent;
	}
	public Date getFundStartedDate() {
		return fundStartedDate;
	}
	public void setFundStartedDate(Date fundStartedDate) {
		this.fundStartedDate = fundStartedDate;
	}
	public String getFundEndedDate() {
		return fundEndedDate;
	}
	public void setFundEndedDate(String fundEndedDate) {
		this.fundEndedDate = fundEndedDate;
	}
	public Integer getStatusID() {
		return statusID;
	}
	public void setStatusID(Integer statusID) {
		this.statusID = statusID;
	}
	public String getFundPostNote() {
		return fundPostNote;
	}
	public void setFundPostNote(String fundPostNote) {
		this.fundPostNote = fundPostNote;
	}
	public String getFundAttendeeCount() {
		return fundAttendeeCount;
	}
	public void setFundAttendeeCount(String fundAttendeeCount) {
		this.fundAttendeeCount = fundAttendeeCount;
	}
	public Integer getPropoID() {
		return propoID;
	}
	public void setPropoID(Integer propoID) {
		this.propoID = propoID;
	}
	
	
}
