package business;

import business.externalinterfaces.SimulationData;
/*
 * This object contains the information from the view and output from the business layer  
 */
public class SimulationDataImpl implements SimulationData{

	private double currentInvestment;
	private int timetoRetire;
	private double inflationAdjustedRate;
	private int numberOfSimulations;
	private Portfolio portfolioType;
	
	private double median;
	private double tenPercentile;
	private double ninetyPercentile;
	
	public double getCurrentInvestment() {
		return currentInvestment;
	}
	public void setCurrentInvestment(double currentInvestment) {
		this.currentInvestment = currentInvestment;
	}
	public int getTimetoRetire() {
		return timetoRetire;
	}
	public void setTimetoRetire(int timetoRetire) {
		this.timetoRetire = timetoRetire;
	}
	public double getInflationAdjustedRate() {
		return inflationAdjustedRate;
	}
	public void setInflationAdjustedRate(double inflationAdjustedRate) {
		this.inflationAdjustedRate = inflationAdjustedRate;
	}
	public int getNumberOfSimulations() {
		return numberOfSimulations;
	}
	public void setNumberOfSimulations(int numberOfSimulations) {
		this.numberOfSimulations = numberOfSimulations;
	}
	public Portfolio getPortfolioType() {
		return portfolioType;
	}
	public void setPortfolioType(Portfolio portfolioType) {
		this.portfolioType = portfolioType;
	}
	public double getMedian() {
		return median;
	}
	public void setMedian(double median) {
		this.median = median;
	}
	public double getTenPercentile() {
		return tenPercentile;
	}
	public void setTenPercentile(double tenPercentile) {
		this.tenPercentile = tenPercentile;
	}
	public double getNinetyPercentile() {
		return ninetyPercentile;
	}
	public void setNinetyPercentile(double ninetyPercentile) {
		this.ninetyPercentile = ninetyPercentile;
	}
}
