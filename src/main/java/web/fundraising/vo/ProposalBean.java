package web.fundraising.vo;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Fund_PROPOSAL")
public class ProposalBean implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer	proposalID;
	private String proposalName;
	private String proposalHostName;
	private Integer proposalGoal;
	private String proposalCategoryID;
	private Timestamp proposalStartedDateTime;
	private Timestamp proposalEndedDateTime;
	private String statusID;
	private String proposalEmail;
	private String proposalCellphone;
	private String proposalSummary;
	private String proposalPageContent;
	private String memID;
	
	public ProposalBean() {}
	
	public ProposalBean(String proposalName, String proposalHostName, Integer proposalGoal,
			String proposalCategoryID, Timestamp proposalStartedDateTime, Timestamp proposalEndedDateTime, String statusID,
			String proposalEmail, String proposalCellphone, String proposalSummary, String proposalPageContent,
			String memID) {
		super();
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
	public String getProposalCategoryID() {
		return proposalCategoryID;
	}
	public void setProposalCategoryID(String proposalCategoryID) {
		this.proposalCategoryID = proposalCategoryID;
	}
	public Timestamp getProposalStartedDateTime() {
		return proposalStartedDateTime;
	}
	public void setProposalStartedDateTime(Timestamp proposalStartedDateTime) {
		this.proposalStartedDateTime = proposalStartedDateTime;
	}
	public Timestamp getProposalEndedDateTime() {
		return proposalEndedDateTime;
	}
	public void setProposalEndedDateTime(Timestamp proposalEndedDateTime) {
		this.proposalEndedDateTime = proposalEndedDateTime;
	}
	public String getStatusID() {
		return statusID;
	}
	public void setStatusID(String string) {
		this.statusID = string;
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
	public String getMemID() {
		return memID;
	}
	public void setMemID(String string) {
		this.memID = string;
	}
	
	
	
	
}
