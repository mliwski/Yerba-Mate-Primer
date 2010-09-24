package com.yerbamateprimer.model;

/**
 * This class models a yerba mate,
 * as the cup, the yerba and the 
 * bombilla, ready to drink it.
 * 
 * @author Matias Liwski
 * @version 1.0
 */
public class Mate {
	private Integer buildTime;
	private Integer restTime;
	private Integer cebadaTime;
	private Integer drinkTime;
	private String yerba;
	private Sweetness sweetner;

	/**
	 * @param buildTime The time needed to build physically this mate.
	 * @param restTime The time between the last cebada and the next one.
	 * @param cebadaTime The time that need to fill the mate with hot water.
	 * @param drinkTime The time that need a person to drink the mate.
	 * @param yerba The brand and type of yerba used in this mate
	 * @param sweetner The sweetner of this mate.
	 */
	public Mate(Integer buildTime, Integer restTime, Integer cebadaTime, Integer drinkTime,
			String yerba, Sweetness sweetner) {
		super();
		this.buildTime = buildTime;
		this.restTime = restTime;
		this.cebadaTime = cebadaTime;
		this.drinkTime = drinkTime;
		this.yerba = yerba;
		this.sweetner = sweetner;
	}

	/**
	 * @return The build time of the mate.
	 */
	public Integer getBuildTime() {
		return buildTime;
	}

	/**
	 * @param buildTime The build time to set.
	 */
	public void setBuildTime(Integer buildTime) {
		this.buildTime = buildTime;
	}
	/**
	 * @return The rest time of the mate.
	 */
	public Integer getRestTime() {
		return restTime;
	}
	
	/**
	 * @param restTime The rest time to set.
	 */
	public void setRestTime(Integer restTime) {
		this.restTime = restTime;
	}

	/**
	 * @return The cebada time of the mate.
	 */
	public Integer getCebadaTime() {
		return cebadaTime;
	}

	/**
	 * @param cebadaTime The cebada time to set.
	 */
	public void setCebadaTime(Integer cebadaTime) {
		this.cebadaTime = cebadaTime;
	}

	/**
	 * @return The drink time of the mate.
	 */
	public Integer getDrinkTime() {
		return drinkTime;
	}

	/**
	 * @param drinkTime The drink time to set.
	 */
	public void setDrinkTime(Integer drinkTime) {
		this.drinkTime = drinkTime;
	}

	/**
	 * @return The brand and type of yerba used in this mate.
	 */
	public String getYerbaType() {
		return yerba;
	}

	/**
	 * @param yerba The yerba brand and type to set.
	 */
	public void setYerba(String yerba) {
		this.yerba = yerba;
	}

	/**
	 * @return The sweetner of this mate.
	 */
	public Sweetness getSweetner() {
		return sweetner;
	}

	/**
	 * @param sweetner The sweetner to set.
	 */
	public void setSweetner(Sweetness sweetner) {
		this.sweetner = sweetner;
	}
}
