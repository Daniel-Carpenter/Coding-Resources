package examples;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

// Any JavaFX application must extend the Application class, which is abstract.
public class JavaFXExample extends Application {

	public static void main(String[] args) {
		// Launch the JavaFX application. This method creates a JavaFXExample
		// object and calls its start method.
		launch(args);
	}

	// The start method is the entry point for any JavaFX application. It is 
	// the only abstract method of the Application class and must be overridden.
	//
	// The launch method passes the start method a reference to the primary 
	// Stage of the application. This Stage is the window that displays the 
	// application content.
	@Override
	public void start(Stage stage) throws Exception {
		
		// The graphical components of a JavaFX application are stored in 
		// Scenes. One such component is a Pane. The next two lines create a 
		// Scene with an empty Pane and set its dimensions (width and height) 
		// in pixels.
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 400, 200);

		// The next three lines add the Scene to the application Stage, set the 
		// text in the title bar, and display the window. Note that only one 
		// Scene can be displayed in a Stage at a time.
		stage.setScene(scene);
		stage.setTitle("Daniel - 113009743#");
		stage.show();
	}
}
