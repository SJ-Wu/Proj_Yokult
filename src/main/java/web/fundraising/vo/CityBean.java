package web.fundraising.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Fund_CITY")
public class CityBean {
	
	@Id
	private String cityID;
	private String cityName;
	@Override
	public String toString() {
		return "CityBean [cityID=" + cityID + ", cityName=" + cityName + "]";
	}
	public String getCityID() {
		return cityID;
	}
	public void setCityID(String cityID) {
		this.cityID = cityID;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	
	
}
