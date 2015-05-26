package business.externalinterfaces;

import business.Portfolio;

public interface SimulationData {
	
    public double getCurrentInvestment();
    public int getTimetoRetire();
    public double getInflationAdjustedRate();
    public int getNumberOfSimulations();
    public double getMedian();
    public double getTenPercentile();
    public double getNinetyPercentile();
    public Portfolio getPortfolioType();
    public void setCurrentInvestment(double currentInvestment);
    public void setTimetoRetire(int timetoRetire);
    public void setInflationAdjustedRate(double inflationAdjustedRate);
    public void setNumberOfSimulations(int numberOfSimulations);
    public void setPortfolioType(Portfolio portfolioType);
    public void setMedian(double median);
    public void setTenPercentile(double tenPercentile);
    public void setNinetyPercentile(double ninetyPercentile);
   
}
