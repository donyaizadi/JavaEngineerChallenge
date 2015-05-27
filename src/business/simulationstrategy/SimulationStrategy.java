package business.simulationstrategy;

import java.util.Arrays;

import org.apache.commons.math.MathException;
import org.apache.commons.math.distribution.NormalDistribution;
import org.apache.commons.math.distribution.NormalDistributionImpl;

import business.SimulationDataImpl;

public abstract class SimulationStrategy {
	
	private SimulationDataImpl simulationData; 
	private double[] simulationlist; // the list for all 10000 simulation possible values
	
	public SimulationStrategy(SimulationDataImpl simulationData) {
		this.simulationData = simulationData;
		simulationlist = new double[simulationData.getNumberOfSimulations()];
	}

	abstract public double getPossibleReturnValues() throws MathException;
	
	public void runSimulation() throws MathException{
		// run 10000 simulations of projecting 20 year value
    	for (int i=0; i<simulationData.getNumberOfSimulations(); i++){
   			simulationlist[i] = getPossibleReturnValues();
    	}
    	// calculate the outcome values after simulation
    	//50th Percentile value among the 10,000 simulations
    	simulationData.setMedian(Math.round(getPercentile(simulationlist, 0.5)));
    	// 90th Percentile value among the 10,000 simulations
    	simulationData.setNinetyPercentile(Math.round(getPercentile(simulationlist, 0.9)));
    	//10th Percentile value among the 10,000 simulations
    	simulationData.setTenPercentile(Math.round(getPercentile(simulationlist, 0.1)));
	}
	
	protected double getPossibleReturnValuesWithParams(double mean, double sd) throws MathException{
		
		NormalDistribution d;
    	Double[][] result = new Double[simulationData.getTimetoRetire()][2];
    	Double endingBalance = simulationData.getCurrentInvestment();
    	
    	// Generate random rate of returns for (for example) 20 years form now
    	// using normal distribution probability 
    	for (int i=0; i<simulationData.getTimetoRetire(); i++){ 
    		//calculate normal distribution probability of random variables
    		d = new NormalDistributionImpl(mean, sd);
    		//computes the values for a random probability
    		// this is a possible return value for each year 
    		Double ret = d.inverseCumulativeProbability(Math.random());
    		// calculate the ending balance for each year from the previous year's balance based on the return value
    		// starts from current investment for first year for example $100,000 
    		// each year adjust the balance based on the inflation rate which is 3.5% according to the problem statement
        	Double value =(endingBalance*(1+ret))/(1+simulationData.getInflationAdjustedRate());
        	endingBalance = value;
        	result[i][0] = ret;
        	result[i][1] = value;
    	}
    	
    	// return the last balance (20th year's balance)
    	return result[simulationData.getTimetoRetire()-1][1];		
	}
	
    
	public double getPercentile(double [] data, double percentile) { 
        Arrays.sort(data);
        double index = percentile*(data.length-1);
        int lower = (int)Math.floor(index);
        if(lower < 0) { // should never happen, but be defensive
           return data[0];
        }
        if(lower >= data.length-1) { // only in 100 percentile case, but be defensive
           return data[data.length-1];
        }
        // try to be as precise as possible
        double fraction = index-lower;
        double result = data[lower] + fraction * (data[lower+1] - data[lower]);
        
        return result;
     }

	public double[] getSimulationlist() {
		return simulationlist;
	}

}
