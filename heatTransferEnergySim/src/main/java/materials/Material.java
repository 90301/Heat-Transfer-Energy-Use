package materials;

/**
 * A material with an R value
 * @author Joshua Benton
 *
 */
public class Material {
	Double rValue =1.0;
	Double sqFt = 1.0;
	
	//Infrared / radiative heat
	Double reflection = 0.0;
	Double absorbstion = 0.0;
	Double passthrough = 1.0;
	//must add up to ~1
	
	
	
	
	//generated getters / setters
	public Double getrValue() {
		return rValue;
	}
	public void setrValue(Double rValue) {
		this.rValue = rValue;
	}
	public Double getSqFt() {
		return sqFt;
	}
	public void setSqFt(Double sqFt) {
		this.sqFt = sqFt;
	}
	public Double getReflection() {
		return reflection;
	}
	public void setReflection(Double reflection) {
		this.reflection = reflection;
	}
	public Double getAbsorbstion() {
		return absorbstion;
	}
	public void setAbsorbstion(Double absorbstion) {
		this.absorbstion = absorbstion;
	}
	public Double getPassthrough() {
		return passthrough;
	}
	public void setPassthrough(Double passthrough) {
		this.passthrough = passthrough;
	}
	
	
	

}
