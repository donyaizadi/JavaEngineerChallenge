package business;

import org.apache.commons.math.MathException;

import business.simulationstrategy.SimulationStrategy;

public class Simulator {
	
	private SimulationStrategy strategy;
	
	public void setStrategy(SimulationStrategy strategy){
		this.strategy = strategy;
	}
	
	public void doSimulation() throws MathException{
		strategy.runSimulation();
	}

}
