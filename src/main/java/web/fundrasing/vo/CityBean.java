package web.fundrasing.vo;

public class CityBean {
	private Integer cityID;
	private String sityName;
	
	
	@Override
	public String toString() {
		return "CityBean [cityID=" + cityID + ", sityName=" + sityName + "]";
	}
	
	
	public Integer getCityID() {
		return cityID;
	}
	public void setCityID(Integer cityID) {
		this.cityID = cityID;
	}
	public String getSityName() {
		return sityName;
	}
	public void setSityName(String sityName) {
		this.sityName = sityName;
	}
	
	
}
