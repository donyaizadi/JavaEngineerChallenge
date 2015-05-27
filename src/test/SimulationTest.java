package test;


import java.util.Arrays;
import org.apache.commons.math.MathException;
import business.Portfolio;
import business.SimulationDataImpl;
import business.simulationstrategy.SimulationStrategy;
import business.simulationstrategy.impl.AggressiveSimulation;
import junit.framework.TestCase;

public class SimulationTest extends TestCase{
	
	private SimulationDataImpl simulationData;
	private SimulationStrategy simulationStrategy;
	
	
	// Initialize the simulationData object for the test 
	{
		simulationData = new SimulationDataImpl();
		simulationData.setCurrentInvestment(100000.0); // $100,000 
		simulationData.setInflationAdjustedRate(0.035); // 3.5%
		simulationData.setNumberOfSimulations(10000);
		simulationData.setTimetoRetire(20);
		simulationData.setPortfolioType(Portfolio.AGGRESSIVE);
		simulationStrategy = new AggressiveSimulation(simulationData);
	}

	
	public void testGetPercentile(){
		System.out.println("Test if getPercentile method works correctly");
		double[] data = new double[] {0.0, 1.0, 2.0, 3.0, 4.0};
		
		assertEquals(0.4, simulationStrategy.getPercentile(data, 0.1));
		assertEquals(2.0, simulationStrategy.getPercentile(data, 0.5));
		assertEquals(3.6, simulationStrategy.getPercentile(data, 0.9));
	}
	
	public void testrunSimulation(){
		System.out.print("Test if simulation method works correctly for 10,000 simulations");
		double expectedMinAvg = 300000.00;
		double expectedMaxAvg = 320000.00;

		try {
			// do the simulation 10 times and calculate the average for each round
			// the average for all simulations should be in the same range
			double[] simulationResultArray = new double[10]; 
			for (int i=0; i<10; i++){
				System.out.print(".");
				simulationStrategy.runSimulation();
				simulationResultArray[i] = (Arrays.stream(simulationStrategy.getSimulationlist()).average()).getAsDouble();
			}
			for(double result:simulationResultArray){
				assertTrue(result >= expectedMinAvg && result <= expectedMaxAvg);
			}
		} catch (MathException e) {
			fail("Results are not in average range!");
		}
		System.out.println();
	}

}
