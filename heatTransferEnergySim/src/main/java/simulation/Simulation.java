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
	
	

}
