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
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer planID;
	private String planName;
	private Integer planAmount;
	private String planContent;
	private String planPostNote;
	private Date planStartedDate;
	private String planEndedDate;
	private Integer statusID;
	private Integer	propoID;
//	private String planAttendeeCount;
	@Override
	public String toString() {
		return "PlanBean [planID=" + planID + ", planName=" + planName + ", planAmount=" + planAmount + ", planContent="
				+ planContent + ", planPostNote=" + planPostNote + ", planStartedDate=" + planStartedDate
				+ ", planEndedDate=" + planEndedDate + ", statusID=" + statusID + ", propoID=" + propoID + "]";
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
		return planStartedDate;
	}
	public void setPlanStartedDate(Date planStartedDate) {
		this.planStartedDate = planStartedDate;
	}
	public String getPlanEndedDate() {
		return planEndedDate;
	}
	public void setPlanEndedDate(String planEndedDate) {
		this.planEndedDate = planEndedDate;
	}
	public Integer getStatusID() {
		return statusID;
	}
	public void setStatusID(Integer statusID) {
		this.statusID = statusID;
	}
	public Integer getPropoID() {
		return propoID;
	}
	public void setPropoID(Integer propoID) {
		this.propoID = propoID;
	}
	
}
