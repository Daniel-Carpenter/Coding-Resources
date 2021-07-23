import javafx.scene.canvas.Canvas;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Random;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * Drive class for visualizing code through JavaFX
 * 
 * @author Daniel Carpenter
 * @version 4.19
 */
public class Main extends Application {

	/**
	 * Width of the grid window
	 */
	private final static int gridWidth = 1200;

	/**
	 * Height of the grid window
	 */
	private final static int gridHeight = 800;

	/**
	 * Width of canvas to display Fibanacci graphs
	 */
	private double canvasWidth = (double) gridWidth * 0.75;

	/**
	 * Height of canvas to display Fibanacci graphs
	 */
	private double canvasHeight = 200;

	/**
	 * Local canvas to update Fibanacci graphs on
	 */
	private Canvas canvas = new Canvas(canvasWidth, canvasHeight);

	/**
	 * Min value of slider for Hamming Distance
	 */
	private final static int minVal = 1;

	/**
	 * Set value for Hamming Distance slider
	 */
	private final static int defaultVal = 2;

	/**
	 * Max value on Hamming Distance slider
	 */
	private final static int maxVal = 4;

	/**
	 * Major tick marks for Hamming Distance slider
	 */
	private final static int majTickMark = 1; // 1 unit

	/**
	 * Minor tick marks for Hamming Distance slider
	 */
	private final static int minTickMark = 0; // none

	/**
	 * Validation measure to ensure stID input contains 4 characters
	 */
	private final static int defaultStIDLength = 4;

	/**
	 * Default whitespace when needed for display purposes
	 */
	private final static String WHITESPACE = "         ";
	
	// CUSTOM METHODS ----------------------------------------------------------------------
	
	/**
	 * Creates a light blue triangle that has full transparency
	 * 
	 * @param base is the base of the rectangle 
	 * @param height is the height of the rectangle
	 * @return returns a light-blue rectangle with no fill
	 */
	public Rectangle formattedRectangle(int base, int height)
    {			    	
    	double opacity = 0.25; // from 0 to 1, 0 = full
    	
    	Rectangle rectBox = new Rectangle(base, height);
    	rectBox.setStroke(Color.BLUE);
    	rectBox.setOpacity(opacity);
    	rectBox.setFill(null);
    	
		return rectBox;
    }
	
	/**
	 * Creates a canvas with a bargraph of Fibanacci numbers
	 * 
	 * @param fibNums number to display up to the nth term in the Fibonacci sequence
	 * @param canvasHeight The height of the canvas
	 * @return returns a bar graph (canvas) of Fibanacci numbers
	 */
	public Canvas fibonacciBargraph(int fibNums, int canvasHeight) 
	{		
		int rbgMaxNum = 256; // exclusive
		int barHeight = canvasHeight / fibNums;
		int whiteSpace = 0;
		
		Canvas canvas = new Canvas((int) canvasWidth, canvasHeight);  
		GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
	
		for (int i = 0; i < fibNums; ++i)
		{
			Random randStream = new Random();
			int rand1  = randStream.nextInt(rbgMaxNum);
			int rand2  = randStream.nextInt(rbgMaxNum);
			int rand3  = randStream.nextInt(rbgMaxNum);
			
			double recursive = (double) Recursion.fibonacci(i);
			double maxRecusrive = (double) Recursion.fibonacci(fibNums);
			double dbCanvasWidth = (double) canvasWidth;
			
			int barWidth = (int) ((recursive / maxRecusrive) * dbCanvasWidth); // RECURSIVE POINT
			
			// Draw bin 
			Color randCol = Color.rgb(rand1, rand2, rand3);
			graphicsContext.setFill(randCol);
			graphicsContext.fillRect(whiteSpace, barHeight * i, barWidth , barHeight);
		}
		
		return canvas;
	}
	
	
	// STAGE ----------------------------------------------------------------------------
	
	/**
	 * Displays a window with options to view Hamming Distances or Fibanacci numbers
	 */
	public void start(Stage primaryStage) {
		try 
		{
			// Setup Grid ----------------------------------------------------------------
			
				GridPane grid = new GridPane();
	
				grid.setAlignment(Pos.TOP_LEFT);
				grid.setHgap(10);
				grid.setVgap(10);
				grid.setPadding(new Insets(25, 25, 25, 25));
	
				Scene scene = new Scene(grid, gridWidth, gridHeight);
	
				primaryStage.setTitle("Hamming Distance");
				primaryStage.setScene(scene);
				primaryStage.show();


			// SLIDER --------------------------------------------------------------------
				
				Slider slider = new Slider();
	
				// Set Default values of slider
				slider.setMin(minVal);
				slider.setValue(defaultVal);
				slider.setMax(maxVal);
	
				// Set tickmarks 
				slider.setShowTickLabels(true);
				slider.setShowTickMarks(true);
				slider.setMajorTickUnit(majTickMark);
				slider.setMinorTickCount(minTickMark);
				slider.setBlockIncrement(1);
	
				// Force to int value
				slider.valueProperty().addListener((obs, oldval, newVal) -> slider.setValue(newVal.intValue()));
				
				
			// CREATE VALUE AREA ------------------------------------------------------------
				
				// Descriptive text of area
				Text descText = new Text("Enter Hamming Dist:");
				Text hammText = new Text(WHITESPACE + Integer.toString(defaultVal));
				
				// Put rectangle around the text
				int height = 20;
				int base   = 120;
			    
			    Rectangle rect  = formattedRectangle(base, height);
			   
			    
			// DROPDOWN LIST OF STATION IDS --------------------------------------------------
			    
			    ComboBox<String> stIDDropdown = new ComboBox<String>(
			    									FXCollections.observableArrayList(
			    									MesonetData.getStationIDList()));
			    
			    
			// SHOW STATION BUTTON -----------------------------------------------------------
			    
			    ListView<String> listView = new ListView<String>();
			    
				
		    // STATIONS W/SAME HAMMING DIST --------------------------------------------------
			    
			    Button showStation = new Button("Show Station");
			    Text compareWithText = new Text("Compare with:");
			   
			    
		    // CALCULATE HD BUTTON -----------------------------------------------------------
			    
			    Button calculateHD = new Button("Calculate HD");
			    
			    // Distances
			    Text distance0 = new Text("");
			    Text distance1 = new Text("");
			    Text distance2 = new Text("");
			    Text distance3 = new Text("");
			    Text distance4 = new Text("");
			    
			    // Rectangles for viewing
			    Rectangle rect0 = formattedRectangle(base, height);
			    Rectangle rect1 = formattedRectangle(base, height);
			    Rectangle rect2 = formattedRectangle(base, height);
			    Rectangle rect3 = formattedRectangle(base, height);
			    Rectangle rect4 = formattedRectangle(base, height);
			    
			    
			// ADD STATION BUTTON ------------------------------------------------------------
			    
			    Button addStationButton   = new Button("Add Station");
			    TextField newStationInput = new TextField();
			    
		    
		    // FIBONACCI BARGRAPH ----------------------------------------------------------------
		    
			    // Get the canvas' graphics context to draw
			    grid.add(new Text("Fibonacci Sequence Visualizer - Choose the max Fibonacci number to visualize" ), 2, 0);
			    
			    
			    Slider fibSlider = new Slider();
			    
			    int fibMinVal		= 1;
			    int fibDefaultVal	= 10;
			    int fibMaxVal 		= 20;
			    
			    // Set range
			    fibSlider.setMin(fibMinVal);
			    fibSlider.setValue(fibDefaultVal);
			    fibSlider.setMax(fibMaxVal);
			    
			    // Set tickmarks 
			    fibSlider.setShowTickLabels(true);
			    fibSlider.setShowTickMarks(true);
			    fibSlider.setMajorTickUnit(majTickMark);
			    fibSlider.setMinorTickCount(minTickMark);
			    fibSlider.setBlockIncrement(1);
			    
			    // force to int value only
			    fibSlider.valueProperty().addListener((obs, oldval, newVal) -> fibSlider.setValue(newVal.intValue()));
				    
			// ADD OBJECTS TO GRID -----------------------------------------------------------
			
			    // HD Text 
			    grid.add(descText, 			0, 0); 
				grid.add(hammText, 			0, 0); 
				grid.add(rect, 				0, 0);
					
				// Slider 
				grid.add(slider, 			0, 2); 
				
				// Show Station Button
				grid.add(showStation, 		0, 3);
				
				// List of same HD
				grid.add(listView, 			0, 4);
				
				// Full dropdown list
				grid.add(stIDDropdown, 		0, 5);
				
				// Calculate distribution of HD's
				grid.add(compareWithText, 	0, 5);
				grid.add(calculateHD, 		0, 6);
				
				
				// Distance 0-4
				grid.add(new Text("Distance 0"), 0, 7);
				grid.add(new Text("Distance 1"), 0, 8);
				grid.add(new Text("Distance 2"), 0, 9);
				grid.add(new Text("Distance 3"), 0, 10);
				grid.add(new Text("Distance 4"), 0, 11);
				
				grid.add(distance0, 0, 7);
				grid.add(distance1, 0, 8);
				grid.add(distance2, 0, 9);
				grid.add(distance3, 0, 10);
				grid.add(distance4, 0, 11);
				
				grid.add(rect0,	0, 7);
				grid.add(rect1,	0, 8);
				grid.add(rect2,	0, 9);
				grid.add(rect3,	0, 10);
				grid.add(rect4,	0, 11);

				// Add Station
				grid.add(addStationButton,	0, 12);
				grid.add(newStationInput,	0, 13);
					
				// add Fibanacci slider 
				grid.add(fibSlider, 2, 1);

				// Alignment
				GridPane.setHalignment(hammText, 	 	HPos.CENTER);
				GridPane.setHalignment(compareWithText, HPos.LEFT);
				GridPane.setHalignment(rect, 	 		HPos.RIGHT);
				GridPane.setHalignment(stIDDropdown, 	HPos.RIGHT);
				GridPane.setHalignment(distance0, 		HPos.CENTER);
				GridPane.setHalignment(distance1, 		HPos.CENTER);
				GridPane.setHalignment(distance2, 		HPos.CENTER);
				GridPane.setHalignment(distance3, 		HPos.CENTER);
				GridPane.setHalignment(distance4, 		HPos.CENTER);
				GridPane.setHalignment(rect0, 			HPos.RIGHT);
				GridPane.setHalignment(rect1, 			HPos.RIGHT);
				GridPane.setHalignment(rect2, 			HPos.RIGHT);
				GridPane.setHalignment(rect3, 			HPos.RIGHT);
				GridPane.setHalignment(rect4, 			HPos.RIGHT);
				GridPane.setHalignment(newStationInput, HPos.RIGHT);
				
				
			// HANDLE EVENTS ----------------------------------------------------------------
				
				// Update Slider Listner
					slider.valueProperty().addListener(new ChangeListener<Number>() {
			            public void changed(ObservableValue<? extends Number> ov,
			                Number oldVal, Number newVal) {
			            	hammText.setText(WHITESPACE + Integer.toString(newVal.intValue()));
			            }
			        });
					
				
				// Update List View Listener
					showStation.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							try 
							{
								// Selected HD and stID
								int selectedHammDist = Integer.parseInt(hammText.getText().trim());
								String selectedStID  = stIDDropdown.getValue();
								
								// Get the list of same stIDs from Selection (on button click)
								listView.setItems(FXCollections.observableArrayList(
												  HammingDistance.getListOfSameHammDists(selectedStID, 
														  								 selectedHammDist,
														  								 stIDDropdown.getItems())));
							} 
							catch (IOException e) 
							{
								e.getMessage();
							}
							catch (NullPointerException n) {
								Alert alert = new Alert(AlertType.ERROR, 
										"Please select a station ID from the dropdown list.");
								alert.showAndWait();								
							}
						}
					});
					
					// Calculate HD Listener 
						calculateHD.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								try 
								{
									String selectedStID  = stIDDropdown.getValue();
									
									HashMap<Integer, Integer> distList = HammingDistance.getHDFrequency(selectedStID, 
																										stIDDropdown.getItems());
									
									// Values = key, so did not use vars
									distance0.setText(WHITESPACE + distList.get(0));
									distance1.setText(WHITESPACE + distList.get(1));
									distance2.setText(WHITESPACE + distList.get(2));
									distance3.setText(WHITESPACE + distList.get(3));
									distance4.setText(WHITESPACE + distList.get(4));
									
								} 
								catch (IOException e) 
								{
									e.getMessage();
								}
								catch (NullPointerException n) {
									Alert alert = new Alert(AlertType.ERROR, 
											"Please select a station ID from the dropdown list.");
									alert.showAndWait();								
								}
							}
						});
					
					// Add Station Listener
						addStationButton.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								try 
								{
									// Selected HD and stID
									String newStID  = newStationInput.getText().toUpperCase();
									
									// Must be four letters
									if (newStID.length() != defaultStIDLength)
									{
										throw new InputMismatchException();
									}
									
									// Account for duplication
									for (String exStID : stIDDropdown.getItems())
									{
										if (exStID.equals(newStID))
										{
											throw new IllegalArgumentException();
										}
									}
									
									// Get the list of same stIDs from Selection (on button click)
									stIDDropdown.getItems().add(newStID);
									
									// sort list
									Collections.sort(stIDDropdown.getItems());
									
									
									// clear text input
									newStationInput.clear();
								} 	
								catch (InputMismatchException mis)
								{
									Alert alert = new Alert(AlertType.ERROR,
											"Please add a four-letter station ID to the list.");
									alert.showAndWait();
								}
								
								catch (IllegalArgumentException ill)
								{
									Alert alert = new Alert(AlertType.ERROR,
											"Station ID already exists. Please enter one that "
											+ "does not already exist.");
									alert.showAndWait();
								}
								
								catch (NullPointerException n) {
									Alert alert = new Alert(AlertType.ERROR, 
											"Please input a new Station ID.");
									alert.showAndWait();								
								}
							}
						});
						
						// Update Fibanacci Slider Listener
						fibSlider.valueProperty().addListener(new ChangeListener<Number>() {
				            public void changed(ObservableValue<? extends Number> ov,
				                Number oldVal, Number newVal) {
				        		
				            	GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
				        		
				        		// clear canvas
				            	// Need to reference graphics context instead so we dont clear canvas
				        		graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
				        		
				        		// Redraw canvas 
				        		canvas = fibonacciBargraph((int) fibSlider.getValue(), 200);
				        		
				        		// add canvas back
				        		grid.add(canvas, 2, 4);
				            }
				        });
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Launch application
	/**
	 * Launches start method with window 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
