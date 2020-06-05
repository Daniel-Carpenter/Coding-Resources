// James Dizikes
// CS 1324 Fall 2019
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class JavaArt extends JPanel
{
	// Change these constants to adjust the size and title of the window.
	private static final int WIDTH = 640;
	private static final int HEIGHT = 480;
	private static final String WINDOW_TITLE = "My Image Title!";
	
	// Do not change the main method.
	public static void main(String[] args)
	{
		JPanel panel = new JavaArt();
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		JFrame frame = new JFrame(WINDOW_TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		frame.pack();
	}
	
	// Add your drawing code to this method.
	public void paintComponent(Graphics g)
	{
		// Do not change these two lines.
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		// Replace the example below with your code.
		
		// Draw a horizontal, blue line in the middle of the screen.
		Line2D.Double line = new Line2D.Double(0, HEIGHT/2, WIDTH, HEIGHT/2);
		g2d.setColor(Color.BLUE);
		g2d.draw(line);
		
		// Draw a vertical, red line in the middle of the screen.
		line.setLine(WIDTH/2, 0, WIDTH/2, HEIGHT);
		g2d.setColor(Color.RED);
		g2d.draw(line);
	}
}