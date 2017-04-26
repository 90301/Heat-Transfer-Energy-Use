package heatSource;

import utils.InhalerMath;

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
	
	
	//SUN info.
	Double percentSun = 1.0;
	
	//probably won't change for now, later on it will
	int sunRise = 7;
	int sunSet = 12+8;
	//follows a Sharp bell curve
	// 0 ---> sun rise (.5) --> 1.0 --> .5 (sunset) --> 0
	
	
	public static final Double SOLAR_CONSTANT = 429.7;
	
	
	
	public Double getOutsideTempForHour(int hour) {
		return InhalerMath.get24HourBellCurveValue(hour, lowTemp, highTemp);
	}
	
	/**
	 * 
	 * @param hour
	 * @return the BTUs per ft^2 of the sun
	 */
	public Double getSunPower(int hour) {
		Double sunPower = 0.0;
		if (hour < sunRise || hour > sunSet) {
			//no sun
		} else {
			double mult = 0.0;
			if (hour==sunRise || hour==sunSet) {
				mult = .5;
			} else {
				mult = 1;
			}
			
			sunPower = mult * percentSun * SOLAR_CONSTANT;
		}
		
		
		return sunPower;
	}
	
	
	//generated getters /setters
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
	public int getSunRise() {
		return sunRise;
	}
	public void setSunRise(int sunRise) {
		this.sunRise = sunRise;
	}
	public int getSunSet() {
		return sunSet;
	}
	public void setSunSet(int sunSet) {
		this.sunSet = sunSet;
	}

	
	

}
