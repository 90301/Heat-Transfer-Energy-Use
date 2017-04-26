package simulation;

import java.util.ArrayList;

import heatSource.HeatSource;
import heatSource.MonthClimateData;
import internal.InternalConditions;
import materials.Material;

/**
 * A single simulation (can create multiple of these)
 * @author Josh Benton
 *
 */
public class Simulation {
	ArrayList<Material> materials = new ArrayList<Material>();
	InternalConditions internalConditions = new InternalConditions();
	HeatSource heatSource = new HeatSource();//TODO generate these each day
	
	MonthClimateData monthClimateData = new MonthClimateData();
	
	public Double totalEnergyCost = 0.0;
	
	public void testCode() {
		Material windows = new Material();
		
		materials.add(windows);
		
	}
	
	public void simYear() {
		//simulate 12 months
	}
	
	public void simMonth() {
		for (int i=0;i<30;i++) {
			simDay(i);
		}
	}
	
	public void simDay(int day) {
		heatSource = monthClimateData.getHeatSource(day);
		System.out.println("Heat source: " + heatSource + " High: " + heatSource.getHighTemp() + " Low: " + heatSource.getLowTemp());
		//simulate 24 hours
		for (int i=0;i<24;i++) {
			simHour(i);
		}
	}
	
	public void simHour(int hour) {
		double totalHeatTransferedIn = 0.0;
		//material calculations
		for (Material m : materials) {
			//standard heat transfer
			Double deltaT = internalConditions.getDesiredInternalTemp() - heatSource.getOutsideTempForHour(hour);
			Double heatTransfer = deltaT*m.getSqFt() / m.getrValue();
			
			Double sunPower = heatSource.getSunPower(hour);
			
			Double heatTransferSun = m.getSunHeat(sunPower);
			
			totalHeatTransferedIn += heatTransfer + heatTransferSun;
		}
		
		
		double energyCost = internalConditions.getEnergyCost(totalHeatTransferedIn);
		//counteract heat
		
		
		totalEnergyCost += energyCost;
		
	}

}
