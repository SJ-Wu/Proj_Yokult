package web.fundraising.vo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Fund_DISTRICT")
public class DistrictBean implements Serializable {
	@Id
	private String districtID;
	private String districtName;
	@Override
	public String toString() {
		return "DistrictBean [districtID=" + districtID + ", districtName=" + districtName + "]";
	}
	public String getDistrictID() {
		return districtID;
	}
	public void setDistrictID(String districtID) {
		this.districtID = districtID;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	
	
}
