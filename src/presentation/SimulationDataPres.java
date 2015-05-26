package presentation;

import business.Portfolio;
import business.SimulationDataImpl;
import business.externalinterfaces.SimulationData;
/*
 the data object for the presentation layer
 */
public class SimulationDataPres {
	
	private SimulationData simulationData;

	public SimulationData getSimulationData() {
		return simulationData;
	}
	public void setSimulationData(SimulationData simulationData) {
		this.simulationData = simulationData;
	}

	public SimulationDataPres() {
		simulationData = new SimulationDataImpl();
	}
	public void setCurrentInvestment(double currentInvestment) {
		simulationData.setCurrentInvestment(currentInvestment);
	}
	public void setTimetoRetire(int timetoRetire) {
		simulationData.setTimetoRetire(timetoRetire);
	}
	public void setInflationAdjustedRate(double inflationAdjustedRate) {
		simulationData.setInflationAdjustedRate(inflationAdjustedRate);
	}
	public void setNumberOfSimulations(int numberOfSimulations) {
		simulationData.setNumberOfSimulations(numberOfSimulations);
	}
	public void setPortfolioType(Portfolio portfolioType) {
		simulationData.setPortfolioType(portfolioType);
	}
	public double getMedian() {
		return simulationData.getMedian();
	}
	public double getNinetyPercentile() {
		return simulationData.getNinetyPercentile();
	}
	public double getTenPercentile() {
		return simulationData.getTenPercentile();
	}
	
}
