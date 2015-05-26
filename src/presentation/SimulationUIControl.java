package presentation;

import java.text.NumberFormat;
import java.util.Locale;

import business.PredictOutcomesUseCaseControl;
import launch.FXSimulationForm;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;

public class SimulationUIControl {
	
	FXSimulationForm gui;
	SimulationDataPres simulationDataPres;
	PredictOutcomesUseCaseControl predictOutcomeUCC;
	
	public SimulationUIControl(FXSimulationForm gui) {
		this.gui = gui;
		simulationDataPres = new SimulationDataPres(); 
		predictOutcomeUCC = new PredictOutcomesUseCaseControl();
	}

	public void handleButtonAction() {
		convertAndExtractFormData();
		// call the logic from the business layer
		predictOutcomeUCC.runSimulator(simulationDataPres);
		convertAndSetFormData();
	 }
	
	private void convertAndExtractFormData(){
		// get data from the UI and convert them from String to the appropriate types and set simulationDataPres
		simulationDataPres.setCurrentInvestment(Double.parseDouble(gui.getCurrentInvestment()));
		simulationDataPres.setInflationAdjustedRate(Double.parseDouble(gui.getInflationAdjustedRate())/100);
		simulationDataPres.setTimetoRetire(Integer.parseInt(gui.getTimetoRetire()));
		simulationDataPres.setNumberOfSimulations(Integer.parseInt(gui.getNumberOfSimulations()));
		simulationDataPres.setPortfolioType(gui.getPortfolioType());
	}
	
	private void convertAndSetFormData(){
		// get data from 
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US); 
		gui.setMedian(currencyFormat.format(simulationDataPres.getMedian()));
		gui.setTenBestCase(currencyFormat.format(simulationDataPres.getNinetyPercentile()));
		gui.setTenWorstCase(currencyFormat.format(simulationDataPres.getTenPercentile()));
	}
	
//	public ButtonHandler getButtonHandler() {
//	return new ButtonHandler();
//}

//	private class ButtonHandler implements EventHandler<ActionEvent> {
//		
//		@Override
//		public void handle(ActionEvent e) {
//			convertAndExtractFormData();
//			predictOutcomeUCC.runSimulator(simulationDataPres);
//			convertAndSetFormData();
//		}
//	}
	
	
}
