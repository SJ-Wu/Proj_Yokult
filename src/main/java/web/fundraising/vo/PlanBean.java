package web.fundraising.vo;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Fund_PLAN")
public class PlanBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer planID;
	private String planName;
	private Integer planAmount;
	private String planContent;
	private String planPostNote;
	private Date planStartedDateTime;
	private Date planEndedDateTime;
	private String statusID;
	private Integer	proposalID;
//	private String planAttendeeCount;

	public PlanBean() {}

	public PlanBean(Integer planID, String planName, Integer planAmount, String planContent, String planPostNote,
			Date planStartedDateTime, Date planEndedDateTime, String statusID, Integer proposalID) {
		super();
		this.planID = planID;
		this.planName = planName;
		this.planAmount = planAmount;
		this.planContent = planContent;
		this.planPostNote = planPostNote;
		this.planStartedDateTime = planStartedDateTime;
		this.planEndedDateTime = planEndedDateTime;
		this.statusID = statusID;
		this.proposalID = proposalID;
	}
	
	public PlanBean(String planName, Integer planAmount, String planContent, String planPostNote,
			Date planStartedDateTime, Date planEndedDateTime, String statusID, Integer proposalID) {
		super();
		this.planName = planName;
		this.planAmount = planAmount;
		this.planContent = planContent;
		this.planPostNote = planPostNote;
		this.planStartedDateTime = planStartedDateTime;
		this.planEndedDateTime = planEndedDateTime;
		this.statusID = statusID;
		this.proposalID = proposalID;
	}
	
	public String toString() {
		return "PlanBean [planID=" + planID + ", planName=" + planName + ", planAmount=" + planAmount + ", planContent="
				+ planContent + ", planPostNote=" + planPostNote + ", planStartedDateTime=" + planStartedDateTime
				+ ", planEndedDateTime=" + planEndedDateTime + ", statusID=" + statusID + ", proposalID=" + proposalID + "]";
	}
	
	public Integer getPlanID() {
		return planID;
	}
	public void setPlanID(Integer planID) {
		this.planID = planID;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public Integer getPlanAmount() {
		return planAmount;
	}
	public void setPlanAmount(Integer planAmount) {
		this.planAmount = planAmount;
	}
	public String getPlanContent() {
		return planContent;
	}
	public void setPlanContent(String planContent) {
		this.planContent = planContent;
	}
	public String getPlanPostNote() {
		return planPostNote;
	}
	public void setPlanPostNote(String planPostNote) {
		this.planPostNote = planPostNote;
	}
	public Date getPlanStartedDate() {
		return planStartedDateTime;
	}
	public void setPlanStartedDate(Date planStartedDateTime) {
		this.planStartedDateTime = planStartedDateTime;
	}
	public Date getPlanEndedDate() {
		return planEndedDateTime;
	}
	public void setPlanEndedDate(Date planEndedDateTime) {
		this.planEndedDateTime = planEndedDateTime;
	}
	public String getStatusID() {
		return statusID;
	}
	public void setStatusID(String statusID) {
		this.statusID = statusID;
	}
	public Integer getProposalID() {
		return proposalID;
	}
	public void setProposalID(Integer proposalID) {
		this.proposalID = proposalID;
	}
	
}
