package launch;

import business.Portfolio;
import presentation.SimulationUIControl;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FXSimulationForm  extends Application{
	
	private TextField currentInvestmentTextfield;
	private TextField timetoRetireTextfield;
	private TextField inflationAdjustedRateTextfield;
	private TextField numberOfSimulationsTextfield;
	private ComboBox<Portfolio> portfolioComboBox;
	private Label median;
	private Label tenBestCase;
	private Label tenWorstCase;
    
    private SimulationUIControl simulationUIControl;
    
	
    
	public static void main(String args[]){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		simulationUIControl = new SimulationUIControl(this);
	    primaryStage.setTitle("Simulation Form");
	    primaryStage.setMaximized(false);
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label dollar = new Label("$");
        Label percentage = new Label("%");
        
        Label currentInvestment = new Label("Current Investment");
        grid.add(currentInvestment, 0, 1);
        currentInvestmentTextfield = new TextField();
        grid.add(currentInvestmentTextfield, 1, 1);
        currentInvestmentTextfield.setText("100000");
//        currentInvestmentTextfield.setDisable(true);
        grid.add(dollar, 2, 1);
        
        Label timetoRetire = new Label("Time to Retire");
        grid.add(timetoRetire, 0, 2);
        timetoRetireTextfield = new TextField();
        grid.add(timetoRetireTextfield, 1, 2);
        timetoRetireTextfield.setText("20");
        
        Label inflationAdjustedRate = new Label("Inflation Adjusted Rate");
        grid.add(inflationAdjustedRate, 0, 3);
        inflationAdjustedRateTextfield = new TextField();
        grid.add(inflationAdjustedRateTextfield, 1, 3);
        inflationAdjustedRateTextfield.setText("3.5");
        grid.add(percentage, 2, 3);

        Label numberOfSimulations = new Label("Number Of Simulations");
        grid.add(numberOfSimulations, 0, 4);
        numberOfSimulationsTextfield = new TextField();
        grid.add(numberOfSimulationsTextfield, 1, 4);
        numberOfSimulationsTextfield.setText("10000");
        Label portfolioType = new Label("Portfolio Type");
        grid.add(portfolioType, 0, 5);
        
        portfolioComboBox = new ComboBox<>();
        portfolioComboBox.getItems().addAll(Portfolio.values());
        portfolioComboBox.setValue(Portfolio.AGGRESSIVE);
        grid.add(portfolioComboBox, 1, 5);
      
        Button btn = new Button("Calculate");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.CENTER);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 0, 6,3,1);

        
        Label medianLabel = new Label("Median 20th Year: ");
        Label tenBestCaseLabel = new Label("10 % Best Case: ");
        Label tenWorstCaseLabel = new Label("10 % Worst Case: ");
        grid.add(medianLabel, 0, 8);
        grid.add(tenBestCaseLabel, 0, 9);
        grid.add(tenWorstCaseLabel, 0, 10);
        
    	median = new Label();
    	tenBestCase = new Label();
    	tenWorstCase = new Label();
        grid.add(median, 1, 8);
        grid.add(tenBestCase, 1, 9);
        grid.add(tenWorstCase, 1, 10);
        
//        btn.setOnAction(simulationUIControl.getButtonHandler());
        btn.setOnAction((event)->{simulationUIControl.handleButtonAction();});

        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.show();
	}

	public String getCurrentInvestment() {
		return currentInvestmentTextfield.getText();
	}
	public String getTimetoRetire() {
		return timetoRetireTextfield.getText();
	}
	public String getInflationAdjustedRate() {
		return inflationAdjustedRateTextfield.getText();
	}
	public String getNumberOfSimulations() {
		return numberOfSimulationsTextfield.getText();
	}
	public Portfolio getPortfolioType() {
		return portfolioComboBox.getValue();
	}
	public void setMedian(String medianText) {
		median.setText(medianText);
	}
	public void setTenBestCase(String tenBestCaseText) {
		tenBestCase.setText(tenBestCaseText);
	}
	public void setTenWorstCase(String tenWorstCaseText) {
		tenWorstCase.setText(tenWorstCaseText);
	}
	
}
