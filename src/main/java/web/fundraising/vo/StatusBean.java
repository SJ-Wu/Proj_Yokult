package web.fundraising.vo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Fund_STATUS")
public class StatusBean implements Serializable {
	@Id
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
