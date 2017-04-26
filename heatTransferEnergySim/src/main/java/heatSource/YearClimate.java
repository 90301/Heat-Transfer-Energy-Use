package heatSource;

import java.util.ArrayList;

import utils.InhalerMath;
/**
 * Controls the climate data for an entire year. used to generate
 * months 
 * @author Josh Benton
 *
 */
public class YearClimate {
	ArrayList<MonthClimateData> months = new ArrayList<>();
	Double summerHigh = 95.0;
	Double summerLow = 75.0;
	
	Double winterHigh = 50.0;
	Double winterLow = 30.0;
	//defaults modeled after averages
	
	
//Ideal editing would be a series of sliders for temperatures
	/* Ex:
	 *  ____________________
	 * | . | . |
	 * | . | . |
	 * | . | . |
	 * | . | . 0
	 * | . 0 . |
	 * |___________________|
	 */
	
	public void genMonths() {
		months.clear();
		Double lastLow = InhalerMath.getBellCurveValue(0, winterLow, summerLow, 6);
		Double lastHigh = InhalerMath.getBellCurveValue(0, winterHigh, summerHigh, 6);
		
		for (int i=0;i<12;i++) {
			Double low = InhalerMath.getBellCurveValue(i, winterLow, summerLow, 6);
			Double high = InhalerMath.getBellCurveValue(i, winterHigh, summerHigh, 6);
			MonthClimateData month = new MonthClimateData();
			month.startHighTemp = lastHigh;
			month.endHighTemp = high;
			month.startLowTemp = lastLow;
			month.endLowTemp = low;
			
			month.genHeatSources();
			months.add(month);
			
			lastLow = low;
			lastHigh = high;
		}
	}


	public MonthClimateData getMonth(int i) {
		if (months.size()<12) {
			genMonths();
		}
		return months.get(i);
	}
}
