package business.simulationstrategy.impl;

import org.apache.commons.math.MathException;

import business.SimulationDataImpl;
import business.simulationstrategy.SimulationStrategy;

public class AggressiveSimulation extends SimulationStrategy{
	
	public AggressiveSimulation(SimulationDataImpl simulationData) {
		super(simulationData);
	}

	public final double MEAN = 0.094324; // Return
	public final double STANDARD_DEVIATION = 0.15675; // Risk
	
	@Override
	public double getPossibleReturnValues() throws MathException {
		return super.getPossibleReturnValuesWithParams(MEAN, STANDARD_DEVIATION);
	}

}
