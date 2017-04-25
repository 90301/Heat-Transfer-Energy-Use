package internal;

public class InternalConditions {
	//Efficiencies
	Double SEER = 8.0;//SEER = watts / btu for AC
	Double HSPF = 6.0;//only applies to heat pumps
	
	//don't use HSPF
	Boolean gasHeated = true;
	
	//Home owner preferences
	Double desiredInternalTemp = 76.0;//In F
	
	//costs
	Double costPerKWH = .20;
	Double costPerTherm = 1.20;
	
	//constants
	public static final Double BTU_PER_THERM = 99976.1;
	
}
