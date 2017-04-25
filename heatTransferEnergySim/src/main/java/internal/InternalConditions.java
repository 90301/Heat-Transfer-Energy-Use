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

	public Double getEnergyCost(Double heatTransferedIn) {
		Double cost;
		
		if (heatTransferedIn>0) {
			//run AC
			cost = heatTransferedIn/SEER*costPerKWH;
		} else {
			//run heat
			if (gasHeated) {
				cost = heatTransferedIn/BTU_PER_THERM*costPerTherm;
			} else {
			cost = heatTransferedIn/HSPF*costPerKWH;
			}
		}
		
		return cost;
	}
	
	public Double getSEER() {
		return SEER;
	}

	public void setSEER(Double sEER) {
		SEER = sEER;
	}

	public Double getHSPF() {
		return HSPF;
	}

	public void setHSPF(Double hSPF) {
		HSPF = hSPF;
	}

	public Boolean getGasHeated() {
		return gasHeated;
	}

	public void setGasHeated(Boolean gasHeated) {
		this.gasHeated = gasHeated;
	}

	public Double getDesiredInternalTemp() {
		return desiredInternalTemp;
	}

	public void setDesiredInternalTemp(Double desiredInternalTemp) {
		this.desiredInternalTemp = desiredInternalTemp;
	}

	public Double getCostPerKWH() {
		return costPerKWH;
	}

	public void setCostPerKWH(Double costPerKWH) {
		this.costPerKWH = costPerKWH;
	}

	public Double getCostPerTherm() {
		return costPerTherm;
	}

	public void setCostPerTherm(Double costPerTherm) {
		this.costPerTherm = costPerTherm;
	}
	
	
	
}
