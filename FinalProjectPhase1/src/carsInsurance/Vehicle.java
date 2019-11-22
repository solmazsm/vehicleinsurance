package carsInsurance;

public abstract class Vehicle {

/* instance fields with
 * appropriate data types
 */
	
	private String carmake;
	/**
	 * @return the carmake
	 */
	public String getCarmake() {
		return carmake;
	}
	/**
	 * @param carmake the carmake to set
	 */
	public void setCarmake(String carmake) {
		this.carmake = carmake;
	}
	/**
	 * @return the carmodel
	 */
	public String getCarmodel() {
		return carmodel;
	}
	/**
	 * @param carmodel the carmodel to set
	 */
	public void setCarmodel(String carmodel) {
		this.carmodel = carmodel;
	}
	/**
	 * @return the caryear
	 */
	public String getCaryear() {
		return caryear;
	}
	/**
	 * @param caryear the caryear to set
	 */
	public void setCaryear(String caryear) {
		this.caryear = caryear;
	}
	/**
	 * @return the cartype
	 */
	public String getCartype() {
		return cartype;
	}
	/**
	 * @param cartype the cartype to set
	 */
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	/**
	 * @return the carplate
	 */
	public String getCarplate() {
		return carplate;
	}
	/**
	 * @param carplate the carplate to set
	 */
	public void setCarplate(String carplate) {
		this.carplate = carplate;
	}
	private String carmodel;
	private String caryear;
	private String cartype;
	private String carplate;
}
