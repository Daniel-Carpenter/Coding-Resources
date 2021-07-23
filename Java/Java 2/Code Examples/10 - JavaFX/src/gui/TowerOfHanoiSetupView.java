package gui;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Move;
import model.Peg;
import model.TowerOfHanoi;
import model.exceptions.IllegalMoveException;

/**
 * Launch point for lab 10. Starts with settings window, which
 * then may activate a TowerOfHanoi simulator.
 * 
 * @author Cameron Bost
 *
 */
public class TowerOfHanoiSetupView extends Application{
	
	/**Student Name*/
	private static final String NAME = "Daniel Carpenter";
	
	/**Student ID*/
	private static final String STUDENT_ID = "113009743";
	
	/**Title of the application window*/
	private static final String WINDOW_TITLE = NAME + " - " + STUDENT_ID;
	
	/**Title of the form*/
	private static final String HANOI_FORM_TITLE = "Towers of Hanoi";
	
	/**Peg Names*/
	
	private static final String PEG_NAME_LEFT = "Left";
	private static final String PEG_NAME_MIDDLE = "Middle";
	private static final String PEG_NAME_RIGHT = "Right";
	
	/**Form Parameters*/
	private static final int FORM_HEIGHT = 250;
	private static final int FORM_WIDTH = 325;
	private static final int HORIZONTAL_GAP = 10;
	private static final int VERTICAL_GAP = 10;
	private static final int PADDING_AMT = 20;
	private static final int HBOX_SPACING_STANDARD = 10;
	private static final int HBOX_SPACING_WIDE = 25;
	private static final int HBOX_SPACING_SLIM = 5;
	
	/**Canvas Parameters*/
	private static final int CANVAS_HEIGHT = 500;
	private static final int CANVAS_WIDTH = 750;
	
	/**
	 * Peg name lookup map
	 */
	private static final HashMap<String, Peg> PEG_NAME_MAP;
	static {
		PEG_NAME_MAP = new HashMap<>();
		PEG_NAME_MAP.put(PEG_NAME_LEFT, Peg.LEFT);
		PEG_NAME_MAP.put(PEG_NAME_MIDDLE, Peg.MIDDLE);
		PEG_NAME_MAP.put(PEG_NAME_RIGHT, Peg.RIGHT);
	}
	
	/**Scene for the settings window*/
	private Scene settingsScene;
	
	/**Simulator object, initially null*/
	private TOH_Simulator sim;
	
	/**Stage (frame) for the program*/
	private Stage stage;
	
	/**Format of the move number label's text*/
	private static final String FORMAT_MOVENUM_LABEL = "%d/%d";
	
	@Override
	public void start(Stage _stage) throws Exception {
		stage = _stage;
		stage.setTitle(WINDOW_TITLE);
		
		settingsScene = initSettingsScene();
		stage.setScene(settingsScene);
		
		stage.show();
	}

	private Scene initSettingsScene() {

		/**
		 * Set layout for form
		 */
		GridPane gridForm = new GridPane();
		gridForm.setAlignment(Pos.CENTER);
		gridForm.setHgap(HORIZONTAL_GAP);
		gridForm.setVgap(VERTICAL_GAP);
		gridForm.setPadding(new Insets(PADDING_AMT));
		
		Text scenetitle = new Text(HANOI_FORM_TITLE);
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		gridForm.add(scenetitle, 0, 0, 2, 1);

		Label userName = new Label("Number of disks:");
		gridForm.add(userName, 0, 1);
		
		/**
		 * Spinner to select # of disks
		 */
		Spinner<Integer> disksSlider = new Spinner<>(1, 8, 5);
		gridForm.add(disksSlider, 1, 1);

		
		/**
		 * Starting peg
		 */
		Label lblStart = new Label("Start:");
		gridForm.add(lblStart, 0, 2);
		
		ToggleGroup tgStartPeg = new ToggleGroup();
		HBox hbStartPeg = new HBox(HBOX_SPACING_STANDARD);
		RadioButton radA = new RadioButton(PEG_NAME_LEFT);
		radA.setToggleGroup(tgStartPeg);
		hbStartPeg.getChildren().add(radA);
		
		RadioButton radB = new RadioButton(PEG_NAME_MIDDLE);
		radB.setToggleGroup(tgStartPeg);
		hbStartPeg.getChildren().add(radB);
		
		RadioButton radC = new RadioButton(PEG_NAME_RIGHT);
		radC.setToggleGroup(tgStartPeg);
		hbStartPeg.getChildren().add(radC);
		
		gridForm.add(hbStartPeg, 1, 2);
		
		/**
		 * Destination peg
		 */
		Label lblEnd = new Label("End:");
		gridForm.add(lblEnd, 0, 3);
		
		ToggleGroup tgEndPeg = new ToggleGroup();
		HBox hbEndPeg = new HBox(HBOX_SPACING_STANDARD);
		RadioButton radAEnd = new RadioButton(PEG_NAME_LEFT);
		radAEnd.setToggleGroup(tgEndPeg);
		hbEndPeg.getChildren().add(radAEnd);
		
		RadioButton radBEnd = new RadioButton(PEG_NAME_MIDDLE);
		radBEnd.setToggleGroup(tgEndPeg);
		hbEndPeg.getChildren().add(radBEnd);
		
		RadioButton radCEnd = new RadioButton(PEG_NAME_RIGHT);
		radCEnd.setToggleGroup(tgEndPeg);
		hbEndPeg.getChildren().add(radCEnd);
		
		gridForm.add(hbEndPeg, 1, 3);
		
		// Go button
		Button btnStart = new Button("GO");
		btnStart.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW, null, null)));
		HBox hbBtnGo = new HBox(HBOX_SPACING_STANDARD);
		hbBtnGo.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtnGo.getChildren().add(btnStart);
		gridForm.add(hbBtnGo, 1, 4);
		
		// Go button action
		btnStart.setOnAction(new EventHandler<ActionEvent>() {
			private static final String ERROR1 = "Must select start peg!";
			private static final String ERROR2 = "Must select end peg!";
			private static final String ERROR3 = "Cannot have same start and end pegs!";
			private static final String ERROR4 = "Number of disks must be a positive value!";
			
			@Override
			public void handle(ActionEvent event) {
				
				int numdisks;
				Peg tStartPeg = null;
				Peg tEndPeg	  = null;
				
				numdisks  = disksSlider.getValue();
				RadioButton selectedStPeg = (RadioButton) tgStartPeg.getSelectedToggle();
				RadioButton selectedEndPeg = (RadioButton) tgEndPeg.getSelectedToggle();
				
				// Error 1: start peg not selected
				try {
						tStartPeg = Peg.valueOf(selectedStPeg.getText().toUpperCase());
						if (tStartPeg == null) {
							throw new NullPointerException();
						}
				}
				catch (NullPointerException excpt) {
						Alert alert = new Alert(AlertType.ERROR, ERROR1);
						alert.showAndWait();
				}
				
				// Error 2: end peg not selected
				try {
					tEndPeg = Peg.valueOf(selectedEndPeg.getText().toUpperCase());
					if (tEndPeg == null) {
						throw new NullPointerException();
					}
				}
				catch (NullPointerException excpt) {
					Alert alert = new Alert(AlertType.ERROR, ERROR2);
					alert.showAndWait();
				}
				
				// Error 3: start and end peg must not equal
				try {
					if (tStartPeg == tEndPeg) {
						throw new IllegalArgumentException();
					}
				}
				catch (IllegalArgumentException excpt) {
					Alert alert = new Alert(AlertType.ERROR, ERROR3);
					alert.showAndWait();
				}
				
				// Error 4: postive number of disks
				if (numdisks <= 0) {
					Alert alert = new Alert(AlertType.ERROR, ERROR4);
					alert.showAndWait();
				}
					
				else { // All input is valid
					// Create simulator
					sim = new TOH_Simulator(numdisks, tStartPeg, tEndPeg);
					
					// Change focused scene
					if (tStartPeg != tEndPeg) {
						stage.setScene(sim.canvasScene);
					}
				}
			}
		});

		return new Scene(gridForm, FORM_WIDTH, FORM_HEIGHT);
	}
	
	/**
	 * Class containing all simulator information. Not used until
	 * "GO" button is pressed on setup view. Take note of the poor
	 * encapsulation I've employed here.
	 * 
	 * @author Cameron
	 *
	 */
	class TOH_Simulator{
		TowerOfHanoi game;
		int numDisks;
		Peg startPeg;
		Peg endPeg;
		Scene canvasScene;
		Canvas gameCanvas;
		TowerOfHanoiView gameView;
		Label lblMoveNumber;
		List<Move> solution;
		Iterator<Move> solIter;
		int moveNum;
		
		/**
		 * Constructor. Requires all game parameters.
		 * 
		 * @param _numdisks initial number of disks on the starting peg 
		 * @param _startPeg which of the 3 pegs to initially put the disks on
		 * @param _endPeg the destination peg for our disks 
		 */
		TOH_Simulator(int _numdisks, Peg _startPeg, Peg _endPeg){
			// Set fields (constructor things)
			numDisks = _numdisks;
			startPeg = _startPeg;
			endPeg = _endPeg;
			
			// Compute solution
			solution = TowerOfHanoi.solveTower(numDisks, startPeg, endPeg);
			resetSolution();
			
			// Init game model
			game = new TowerOfHanoi(numDisks, startPeg);
			
			// Build graphics components
			initSimulatorScene();
			gameView = new TowerOfHanoiView(game, gameCanvas);
			
			// Draw initial state of game
			updateView();
		}
		
		/**
		 * Progresses the solution iterator to the next move.
		 * 
		 * @throws IllegalMoveException if the move in the solution is invalid
		 */
		void incrementMoveNumber() throws IllegalMoveException {
			if(!solIter.hasNext()) {
				new Alert(AlertType.INFORMATION, "Solution is already complete.").showAndWait();
				return;
			}
			else {
				Move doThisMove = solIter.next();
				moveNum++;
				game.moveDisk(doThisMove);
			}
		}
		
		private void resetSolution() {
			solIter = solution.iterator();
			moveNum = 0;
		}
		
		/**
		 * Sets up all graphical components
		 */
		private void initSimulatorScene() {
			BorderPane brdrPane = new BorderPane();
			gameCanvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
			brdrPane.setCenter(gameCanvas);
			brdrPane.setBottom(initGameBar(game));
			canvasScene = new Scene(brdrPane);
		}
		
		private HBox initGameBar(TowerOfHanoi _hanoi) {
			HBox hboxGameBar = new HBox(HBOX_SPACING_WIDE);
			HBox boxMoveTracker = new HBox(HBOX_SPACING_SLIM);
			
			// Group 1, Remaining moves tracker
			Label lblMoveCounter = new Label("Move:");
			lblMoveNumber = new Label("N/A");
			boxMoveTracker.getChildren().add(lblMoveCounter);
			boxMoveTracker.getChildren().add(lblMoveNumber);
			
			// Group 2, Simulator Controls
			HBox hboxBtns = new HBox(HBOX_SPACING_SLIM);
			Button btnForward = new Button(">>");
			hboxBtns.getChildren().add(btnForward);
			btnForward.setOnAction(new EventHandler<ActionEvent>(){

				private static final String ERROR = "Illegal move attempted. Simulation cannot continue";
				@Override
				public void handle(ActionEvent arg0) {
					// move the simulator forward by one move	
					try {
						Move move = sim.solution.get(moveNum);
						_hanoi.moveDisk(move);	
					}
					// if the next move is illegal, create an error alert with the above error message
					catch (IllegalMoveException excpt) {
						Alert alert = new Alert(AlertType.ERROR, ERROR);
						alert.showAndWait();
					}
				}
				
			});

			Button btnReset = new Button("Reset");
			hboxBtns.getChildren().add(btnReset);
			btnReset.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					resetSolution();
					// Reset game state by reinitializing game objects
					game = new TowerOfHanoi(numDisks, startPeg);
					gameView = new TowerOfHanoiView(game, gameCanvas);
					updateView();
				}
				
			});
			
			hboxGameBar.getChildren().add(boxMoveTracker);
			hboxGameBar.getChildren().add(hboxBtns);
			hboxGameBar.setAlignment(Pos.CENTER);
			
			return hboxGameBar;
		}
		
		/**
		 * Re-draws everything in the simulator. Required 
		 * anytime the game model changes.
		 */
		void updateView() {
			// TODO Clear canvas by drawing a filled white rectangle over the entire canvas
			
			// Update move number
			lblMoveNumber.setText(String.format(FORMAT_MOVENUM_LABEL, moveNum, solution.size()));
			
			// TODO Draw game components
		}
	}
	
	
	
	/**
	 * Note: this is also the driver class
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
