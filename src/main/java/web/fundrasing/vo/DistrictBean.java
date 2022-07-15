package web.fundrasing.vo;

import java.io.Serializable;

public class DistrictBean implements Serializable {
	private Integer distID;
	private String distName;
	
	
	@Override
	public String toString() {
		return "DistrictBean [distID=" + distID + ", distName=" + distName + "]";
	}
	
	
	public Integer getDistID() {
		return distID;
	}
	public void setDistID(Integer distID) {
		this.distID = distID;
	}
	public String getDistName() {
		return distName;
	}
	public void setDistName(String distName) {
		this.distName = distName;
	}
	
}
