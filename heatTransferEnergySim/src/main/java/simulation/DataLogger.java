package simulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import materials.Material;

/**
 * Holds data for a simulation and provides methods for getting that data.
 * Holds subclasses for data
 * @author Josh Benton
 *
 */
public class DataLogger {
	
	ArrayList<DataMonth> dataMonths = new ArrayList<DataMonth>();
	DataMonth currentDataMonth;
	
	public void nextDataMonth() {
		DataMonth dm = new DataMonth();
		
		dataMonths.add(dm);
		currentDataMonth = dm;
	}
	
	
	public void logMaterialHeatTransfer(Material m,Double heatTransfer,Double heatTransferSun) {
		
	}
	
	
	
	//SUBCLASSES
	
	/**
	 * Holds data for a month
	 * @author Josh Benton
	 *
	 */
public class DataMonth {
	//Material Heat Transfer for this month
	Map<Material,Double> materialHeatTransfer = new HashMap<Material,Double>();
}

}


