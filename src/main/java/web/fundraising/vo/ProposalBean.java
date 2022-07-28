package web.fundraising.vo;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Fund_PROPOSAL")
public class ProposalBean implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer	proposalID;
	private String proposalName;
	private String proposalHostName;
	private Integer proposalGoal;
	private Integer proposalCategoryID;
	private Date proposalStartedDateTime;
	private Date proposalEndedDateTime;
	private Integer statusID;
	private String proposalEmail;
	private String proposalCellphone;
	private String proposalSummary;
	private String proposalPageContent;
	private Integer memID;
	
	public ProposalBean() {}
	
	public ProposalBean(Integer proposalID, String proposalName, String proposalHostName, Integer proposalGoal,
			Integer proposalCategoryID, Date proposalStartedDateTime, Date proposalEndedDateTime, Integer statusID,
			String proposalEmail, String proposalCellphone, String proposalSummary, String proposalPageContent,
			Integer memID) {
		super();
		this.proposalID = proposalID;
		this.proposalName = proposalName;
		this.proposalHostName = proposalHostName;
		this.proposalGoal = proposalGoal;
		this.proposalCategoryID = proposalCategoryID;
		this.proposalStartedDateTime = proposalStartedDateTime;
		this.proposalEndedDateTime = proposalEndedDateTime;
		this.statusID = statusID;
		this.proposalEmail = proposalEmail;
		this.proposalCellphone = proposalCellphone;
		this.proposalSummary = proposalSummary;
		this.proposalPageContent = proposalPageContent;
		this.memID = memID;
	}

	@Override
	public String toString() {
		return "ProposalBean [proposalID=" + proposalID + ", proposalName=" + proposalName + ", proposalHostName="
				+ proposalHostName + ", proposalGoal=" + proposalGoal + ", proposalCategoryID=" + proposalCategoryID
				+ ", proposalStartedDateTime=" + proposalStartedDateTime + ", proposalEndedDateTime="
				+ proposalEndedDateTime + ", statusID=" + statusID + ", proposalEmail=" + proposalEmail
				+ ", proposalCellphone=" + proposalCellphone + ", proposalSummary=" + proposalSummary
				+ ", proposalPageContent=" + proposalPageContent + ", memID=" + memID + "]";
	}
	
	public Integer getProposalID() {
		return proposalID;
	}
	public void setProposalID(Integer proposalID) {
		this.proposalID = proposalID;
	}
	public String getProposalName() {
		return proposalName;
	}
	public void setProposalName(String proposalName) {
		this.proposalName = proposalName;
	}
	public String getProposalHostName() {
		return proposalHostName;
	}
	public void setProposalHostName(String proposalHostName) {
		this.proposalHostName = proposalHostName;
	}
	public Integer getProposalGoal() {
		return proposalGoal;
	}
	public void setProposalGoal(Integer proposalGoal) {
		this.proposalGoal = proposalGoal;
	}
	public Integer getProposalCategoryID() {
		return proposalCategoryID;
	}
	public void setProposalCategoryID(Integer proposalCategoryID) {
		this.proposalCategoryID = proposalCategoryID;
	}
	public Date getProposalStartedDateTime() {
		return proposalStartedDateTime;
	}
	public void setProposalStartedDateTime(Date proposalStartedDateTime) {
		this.proposalStartedDateTime = proposalStartedDateTime;
	}
	public Date getProposalEndedDateTime() {
		return proposalEndedDateTime;
	}
	public void setProposalEndedDateTime(Date proposalEndedDateTime) {
		this.proposalEndedDateTime = proposalEndedDateTime;
	}
	public Integer getStatusID() {
		return statusID;
	}
	public void setStatusID(Integer statusID) {
		this.statusID = statusID;
	}
	public String getProposalEmail() {
		return proposalEmail;
	}
	public void setProposalEmail(String proposalEmail) {
		this.proposalEmail = proposalEmail;
	}
	public String getProposalCellphone() {
		return proposalCellphone;
	}
	public void setProposalCellphone(String proposalCellphone) {
		this.proposalCellphone = proposalCellphone;
	}
	public String getProposalSummary() {
		return proposalSummary;
	}
	public void setProposalSummary(String proposalSummary) {
		this.proposalSummary = proposalSummary;
	}
	public String getProposalPageContent() {
		return proposalPageContent;
	}
	public void setProposalPageContent(String proposalPageContent) {
		this.proposalPageContent = proposalPageContent;
	}
	public Integer getMemID() {
		return memID;
	}
	public void setMemID(Integer memID) {
		this.memID = memID;
	}
	
	
	
	
}
