package web.fundrasing.vo;

import java.io.Serializable;
import java.sql.Date;

public class ProposalBean implements Serializable{
	private Integer	propoID;
	private String propoName;
	private String propoPerson;
	private Integer propoGoal;
	private Integer propoCategoryID;
	private Date propoStartedDateTime;
	private Date propoEndedDateTime;
	private Integer statusID;
	private String propoEmail;
	private String propoCellphone;
	private String propoSummary;
	private String propoPageContent;
	private Integer memID;
	
	
	@Override
	public String toString() {
		return "ProposalBean [propoID=" + propoID + ", propoName=" + propoName + ", propoPerson=" + propoPerson
				+ ", propoGoal=" + propoGoal + ", propoCategoryID=" + propoCategoryID + ", propoStartedDateTime="
				+ propoStartedDateTime + ", propoEndedDateTime=" + propoEndedDateTime + ", statusID=" + statusID
				+ ", propoEmail=" + propoEmail + ", propoCellphone=" + propoCellphone + ", propoSummary="
				+ propoSummary + ", propoPageContent=" + propoPageContent + ", memID=" + memID + "]";
	}
	
	
	public Integer getPropoID() {
		return propoID;
	}
	public void setPropoID(Integer propoID) {
		this.propoID = propoID;
	}
	public String getPropoName() {
		return propoName;
	}
	public void setPropoName(String propoName) {
		this.propoName = propoName;
	}
	public String getPropoPerson() {
		return propoPerson;
	}
	public void setPropoPerson(String propoPerson) {
		this.propoPerson = propoPerson;
	}
	public Integer getPropoGoal() {
		return propoGoal;
	}
	public void setPropoGoal(Integer propoGoal) {
		this.propoGoal = propoGoal;
	}
	public Integer getPropoCategoryID() {
		return propoCategoryID;
	}
	public void setPropoCategoryID(Integer propoCategoryID) {
		this.propoCategoryID = propoCategoryID;
	}
	public Date getPropoStartedDateTime() {
		return propoStartedDateTime;
	}
	public void setPropoStartedDateTime(Date propoStartedDateTime) {
		this.propoStartedDateTime = propoStartedDateTime;
	}
	public Date getPropoEndedDateTime() {
		return propoEndedDateTime;
	}
	public void setPropoEndedDateTime(Date propoEndedDateTime) {
		this.propoEndedDateTime = propoEndedDateTime;
	}
	public Integer getStatusID() {
		return statusID;
	}
	public void setStatusID(Integer statusID) {
		this.statusID = statusID;
	}
	public String getPropoEmail() {
		return propoEmail;
	}
	public void setPropoEmail(String propoEmail) {
		this.propoEmail = propoEmail;
	}
	public String getpropoCellphone() {
		return propoCellphone;
	}
	public void setpropoCellphone(String propoCellphone) {
		this.propoCellphone = propoCellphone;
	}
	public String getPropoSummary() {
		return propoSummary;
	}
	public void setPropoSummary(String propoSummary) {
		this.propoSummary = propoSummary;
	}
	public String getPropoPageContent() {
		return propoPageContent;
	}
	public void setPropoPageContent(String propoPageContent) {
		this.propoPageContent = propoPageContent;
	}
	public Integer getMemID() {
		return memID;
	}
	public void setMemID(Integer memID) {
		this.memID = memID;
	}

	
	
	
}
