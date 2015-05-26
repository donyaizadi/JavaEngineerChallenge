package business;

import org.apache.commons.math.MathException;

import presentation.SimulationDataPres;
import business.simulationstrategy.impl.AggressiveSimulation;
import business.simulationstrategy.impl.VeryConservativeSimulation;

public class PredictOutcomesUseCaseControl {
	
	private Simulator simulator = new Simulator();
	private SimulationDataImpl simulationData = new SimulationDataImpl();

	public void runSimulator(SimulationDataPres simulationDataPres){
		this.simulationData = (SimulationDataImpl) simulationDataPres.getSimulationData();
		
		if(simulationData.getPortfolioType().equals(Portfolio.AGGRESSIVE)){
			simulator.setStrategy(new AggressiveSimulation(simulationData));
		}
		else if (simulationData.getPortfolioType().equals(Portfolio.VERYCONSERVATIVE)){
			simulator.setStrategy(new VeryConservativeSimulation(simulationData));
		}
		try {
			simulator.doSimulation();
			simulationDataPres.setSimulationData(simulationData); // transfer business data to presentation data
		} catch (MathException e) {
			// must convert to presentation layer exception
			System.out.println("Last Business Layer Ecxeption...");
		}
	}
	
}
