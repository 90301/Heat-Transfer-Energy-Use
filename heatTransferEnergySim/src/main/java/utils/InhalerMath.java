package utils;

public class InhalerMath {
	public static Double get24HourBellCurveValue(int hour, Double min, Double max) {
		//assumes max occurs at hour 12
		double difference = max - min;
		int distanceFrom12 = Math.abs(hour-12);
		//100% max value at 12, 0% difference at 0
		double ratioToAdd = difference * distanceFrom12*1000/12000;
		
		return min + ratioToAdd;
		
	}
	
	public static Double getBellCurveValue(int hour, Double min, Double max,int midPoint ) {
		//assumes max occurs at mid point
		double difference = max - min;
		int distanceFromMid = Math.abs(hour-midPoint);
		//100% max value at 12, 0% difference at 0
		double ratioToAdd = difference * distanceFromMid*1000/12000;
		
		return min + ratioToAdd;
		
	}
	
	public static Double getLinearScale(int scaleVal,int scaleMax, Double min, Double max) {
		
		double difference = max - min;
		
		Double distanceFromMax = (double) ((double)(scaleVal*1000)/((double)scaleMax*1000));
		
		double ratioToAdd = difference * distanceFromMax;
		
		
		return min + ratioToAdd;
	}
}
