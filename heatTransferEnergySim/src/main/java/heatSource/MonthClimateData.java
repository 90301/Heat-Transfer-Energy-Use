package heatSource;

import java.util.ArrayList;

/**
 * Contains Climate data for a month
 * Used to generate HeatSource class each day
 * assuming each month is 30 days
 * 
 * This should be passed to multiple simulations so they work with the same data
 * @author Josh Benton
 *
 */
public class MonthClimateData {
	public static final int DAYS_IN_MONTH = 30;
	
	Double startHighTemp = 90.0;
	Double endHighTemp = 95.0;
	Double startLowTemp = 70.0;
	Double endLowTemp = 75.0;
	//linear change
	Double percentFullSun = .3;
	Double percentPartialSun = .3;
	Double percentOvercast = .1;
	Double percentRain = .3;
	//smallest allowed step is .1
	Integer dayDivider = 10;
	Integer percentMultiplier = dayDivider;
	
	ArrayList<HeatSource> heatSourceDays = new ArrayList<>();
	public void genHeatSources() {
		int fullSun = (int) (percentFullSun*percentMultiplier);
		int partialSun = (int) (percentPartialSun*percentMultiplier)+ fullSun;
		int overcast= (int) (percentOvercast*percentMultiplier) + partialSun;
		int rain = (int) (percentRain*percentMultiplier) + overcast;
		
		for (int i=0;i<DAYS_IN_MONTH;i++) {
			int dayDivided = i%dayDivider;
			if (dayDivided<fullSun) {
				//full sun day
				//much warmer then average, 1.0 sun
			} else if (dayDivided < partialSun) {
				//partial sun day
				//slightly warmer the average .8 sun
			}  else if (dayDivided < overcast) {
				//overcast
				//about average, but only .2 sun
			}  else if (dayDivided <= rain) {
				//rainy day
				//colder then average
			} else {
				//How did this happen.
			}
		}
	}
	
	

}
