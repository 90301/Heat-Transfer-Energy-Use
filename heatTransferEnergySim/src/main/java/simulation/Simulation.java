package simulation;

import java.util.ArrayList;

import heatSource.HeatSource;
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
	
	public void simYear() {
		//simulate 12 months
	}
	
	public void simMonth() {
		//simulate 30 days
	}
	
	public void simDay() {
		//simulate 24 hours
	}

}
