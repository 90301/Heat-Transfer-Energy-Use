package heatSource;

import java.util.ArrayList;

import utils.InhalerMath;

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
			HeatSource hs = new HeatSource();
			
			Double baseHighTemp = InhalerMath.getLinearScale(i, 30, startHighTemp, endHighTemp);
			Double baseLowTemp = InhalerMath.getLinearScale(i, 30, startLowTemp, endLowTemp);
			
			Double tempModify = 0.0;
			
			int dayDivided = i%dayDivider;
			if (dayDivided<fullSun) {
				hs.setPercentSun(1.0);
				tempModify = 8.0;
				//full sun day
				//much warmer then average, 1.0 sun
			} else if (dayDivided < partialSun) {
				hs.setPercentSun(0.8);
				tempModify = 0.0;
				//partial sun day
				//slightly warmer the average .8 sun
			}  else if (dayDivided < overcast) {
				hs.setPercentSun(0.2);
				tempModify = 0.0;
				//overcast
				//about average, but only .2 sun
			}  else if (dayDivided <= rain) {
				hs.setPercentSun(0.0);
				tempModify = -8.0;
				//rainy day
				//colder then average
			} else {
				//How did this happen.
			}
			
			hs.setHighTemp(baseHighTemp + tempModify);
			hs.setLowTemp(baseLowTemp + tempModify);
			
			heatSourceDays.add(hs);
			
		}
	}
	public HeatSource getHeatSource(int day) {
		if (heatSourceDays.size()<30) {
			genHeatSources();
		}
		return heatSourceDays.get(day);
	}
	
	

}
