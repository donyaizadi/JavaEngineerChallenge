package business.simulationstrategy.impl;

import org.apache.commons.math.MathException;

import business.SimulationDataImpl;
import business.simulationstrategy.SimulationStrategy;

public class VeryConservativeSimulation extends SimulationStrategy{
	
	public VeryConservativeSimulation(SimulationDataImpl simulationData) {
		super(simulationData);
	}

	public final double MEAN = 0.06189; // Return
	public final double STANDARD_DEVIATION = 0.063438; // Risk

	@Override
	public double getPossibleReturnValues() throws MathException {
		return super.getPossibleReturnValuesWithParams(MEAN, STANDARD_DEVIATION);
	}

}
