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
}