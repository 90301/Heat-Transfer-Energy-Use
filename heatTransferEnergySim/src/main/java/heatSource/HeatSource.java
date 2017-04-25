package heatSource;
/**
 * Holder for all the heat transfer sources
 * (Basically the sun and temp outside)
 * @author Josh Benton
 *
 */
public class HeatSource {
	Double highTemp = 90.0;
	Double lowTemp = 70.0;//In F
	//follows bell curve
	
	
	Double percentSun = 1.0;
	Double sunRise = 7.0;
	Double sunSet = 12+8.0;
	//follows a bell curve
	
	
	
	
	
	
	
	
	
	
	//getters /setters
	public Double getHighTemp() {
		return highTemp;
	}
	public void setHighTemp(Double highTemp) {
		this.highTemp = highTemp;
	}
	public Double getLowTemp() {
		return lowTemp;
	}
	public void setLowTemp(Double lowTemp) {
		this.lowTemp = lowTemp;
	}
	public Double getPercentSun() {
		return percentSun;
	}
	public void setPercentSun(Double percentSun) {
		this.percentSun = percentSun;
	}
	public Double getSunRise() {
		return sunRise;
	}
	public void setSunRise(Double sunRise) {
		this.sunRise = sunRise;
	}
	public Double getSunSet() {
		return sunSet;
	}
	public void setSunSet(Double sunSet) {
		this.sunSet = sunSet;
	}
	
	

}