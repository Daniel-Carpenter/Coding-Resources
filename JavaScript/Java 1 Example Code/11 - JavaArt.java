// Daniel Carpenter
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.lang.Object;

public class Project_11 extends JPanel
{
	// STATIC CONSTANTS ----------------------------------------------------------------------------------------------------
		private static final int WIDTH = 640;
		private static final int HEIGHT = 360;
		private static final String WINDOW_TITLE = "Project 11: Image Output for Java Art";
		
		// LIST OF COLORS
			Color backgroundCol = new Color(0, 0, 0);
			Color pacManCol		= new Color(255,238,0);
			Color ghostCol 		= new Color(253, 0, 0);
			Color ghostEye		= new Color(0, 105, 183);
			Color dotCol		= new Color(255, 184, 151);
			Color lineCol		= new Color(25, 25, 166);
	
		
	// MAIN METHOD  --------------------------------------------------------------------------------------------------------
		public static void main(String[] args)
		{
			JPanel panel = new Project_11();
			panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
			
			JFrame frame = new JFrame(WINDOW_TITLE);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			frame.add(panel);
			frame.pack();
		}

	
	// CREATE PICTURE  -----------------------------------------------------------------------------------------------------	
		public void paintComponent(Graphics g)
		{	
			// Do not change these two lines.
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				
			// CREATE 2-LINES ----------------------------------------------------------------------------------------------
				// HORIZONTAL LINE
					Line2D.Double line = new Line2D.Double(0, HEIGHT/2, WIDTH, HEIGHT/2);
					g2d.setColor(Color.BLUE);
					g2d.draw(line);
				
				// VERTICAL LINE
					line.setLine(WIDTH/2, 0, WIDTH/2, HEIGHT);
					g2d.setColor(Color.RED);
					g2d.draw(line);
				
			// CREATE BACKGROUND ------------------------------------------------------------------------------------------
				// DEFINE INPUTS
					double b_x 		= 0; 
					double b_y 		= 0;
	                double b_w 		= WIDTH;
					double b_h		= HEIGHT;
	                double b_arcw	= 0;
	                double b_arch	= 0;
		                
	            // DRAW BACKGROUND
	                RoundRectangle2D.Double background = new RoundRectangle2D.Double(b_x, b_y, b_w, b_h, b_arcw, b_arch);
	                g2d.setPaint(backgroundCol);
	                g2d.draw(background);
	                g2d.fill(background);
					
			// CREATE PAC MAN ----------------------------------------------------------------------------------------------
				// DEFINE INPUTS
					double x 		= WIDTH / 20;
					double y 		= HEIGHT / 4.5;
					double h		= 200;
					double w 		= 200;
					double angSt 	= 35;
					double angExt	= 305;
					int  closure	= Arc2D.PIE;
					
				// DRAW PAC MAN
					Arc2D.Double pacMan = new Arc2D.Double(x, y, w, h, angSt, angExt, closure);
					g2d.setPaint(pacManCol);
					g2d.draw(pacMan);
					g2d.fill(pacMan);
					
			// CREATE GHOST -------------------------------------------------------------------------------------------------
				// DEFINE INPUTS
					double g_x 		= WIDTH / 2 + WIDTH / 5 - 20;
					double g_y		= HEIGHT / 4.5;
	                double g_w 		= 175;
	                double g_h		= 400;
	                double g_arcw	= 150;
	                double g_arch	= 100;
	                double g_angSt 	= 0; 
	                double g_angExt = 180;
	                int g_closure = Arc2D.OPEN;
	                
				// DRAW GHOST
	                Arc2D.Double ghost = new Arc2D.Double(g_x, g_y, g_w, g_h, g_angSt, g_angExt, g_closure);
					g2d.setPaint(ghostCol);
					g2d.draw(ghost);
					g2d.fill(ghost);
					
					RoundRectangle2D.Double ghost2 = new RoundRectangle2D.Double(g_x + 0 / 2, g_y, g_w, g_h - 100, 200, 200);
					g2d.setPaint(ghostCol);
					g2d.draw(ghost2);
					g2d.fill(ghost2);
					
	                RoundRectangle2D.Double backgroundGhost = new RoundRectangle2D.Double(b_x, HEIGHT * .79, b_w, b_h, b_arcw, b_arch);
	                g2d.setPaint(backgroundCol);
	                g2d.draw(backgroundGhost);
	                g2d.fill(backgroundGhost);
					
			// CREATE GHOST WHITE EYES --------------------------------------------------------------------------------------
				// DRAW LEFT WHITE EYE
	                RoundRectangle2D.Double leftWhite = new RoundRectangle2D.Double(g_x + 5, y * 1.5, 150 / 2.5, h / 2.7, g_arcw + 50, g_arch + 50);
					g2d.setPaint(Color.WHITE);
					g2d.draw(leftWhite);
					g2d.fill(leftWhite);
	                
				// DRAW RIGHT WHITE EYE
					RoundRectangle2D.Double rightWhite = new RoundRectangle2D.Double(g_x + 78 , y * 1.5, 150 / 2.5, h / 2.7, g_arcw + 50, g_arch + 50);
					g2d.setPaint(Color.WHITE);
					g2d.draw(rightWhite);
					g2d.fill(rightWhite);
					
				// DRAW LEFT BLUE EYE
	                RoundRectangle2D.Double leftBlue = new RoundRectangle2D.Double(g_x + 7, y * 1.84, 150 / 4.5, 150 / 4.5, g_arcw + 300, g_arch + 300);
					g2d.setPaint(ghostEye);
					g2d.draw(leftBlue);
					g2d.fill(leftBlue);
					
				// DRAW RIGHT BLUE EYE
	                RoundRectangle2D.Double rightBlue = new RoundRectangle2D.Double(g_x + 80, y * 1.84, 150 / 4.5, 150 / 4.5, g_arcw + 300, g_arch + 300);
					g2d.setPaint(ghostEye);
					g2d.draw(rightBlue);
					g2d.fill(rightBlue);
					
			// CREATE DOT -------------------------------------------------------------------------------------------------
				// DEFINE INPUTS
					double d_x 		= WIDTH / 2 - 15;
					double d_y		= HEIGHT / 2 - 35;
		            double d_w 		= 40;
		            double d_h		= 40;
		                
		    // DRAW DOT
		            Rectangle2D.Double dot1 = new Rectangle2D.Double(d_x - 50, d_y, d_w, d_h);
					g2d.setPaint(dotCol);
					g2d.draw(dot1);
					g2d.fill(dot1);
					
		            Rectangle2D.Double dot2 = new Rectangle2D.Double(d_x + 50, d_y, d_w, d_h);
					g2d.setPaint(dotCol);
					g2d.draw(dot2);
					g2d.fill(dot2);
					
			// PURPLE BOUNDARY LINES --------------------------------------------------------------------------------------
				// DEFINE INPUTS
					double l_x 		= 25; 
					double l_y 		= 0;
	                double l_w 		= WIDTH - l_x * 2;
					double l_h		= 50;
	                double l_arcw	= 60;
	                double l_arch	= 60;
				// LINE 1
	                RoundRectangle2D.Double line1 = new RoundRectangle2D.Double(l_x, l_y + 15, l_w, l_h, l_arcw, l_arch);
					g2d.setPaint(lineCol);
					g2d.draw(line1);
					g2d.fill(line1);
				// INNER LINE 1
					RoundRectangle2D.Double innerLine1 = new RoundRectangle2D.Double(l_x + 7.5, l_y + 20, l_w - 15, l_h - 10, l_arcw, l_arch);
					g2d.setPaint(Color.BLACK);
					g2d.draw(innerLine1);
					g2d.fill(innerLine1);
					
				// LINE 2
	                RoundRectangle2D.Double line2 = new RoundRectangle2D.Double(l_x, HEIGHT - (l_y + 15 + l_h), l_w, l_h, l_arcw, l_arch);
					g2d.setPaint(lineCol);
					g2d.draw(line2);
					g2d.fill(line2);
				// INNER LINE 2
					RoundRectangle2D.Double innerLine2 = new RoundRectangle2D.Double(l_x + 7.5, HEIGHT - (l_y + 20 + l_h ) +10, l_w - 15, l_h - 10, l_arcw, l_arch);
					g2d.setPaint(Color.BLACK);
					g2d.draw(innerLine2);
					g2d.fill(innerLine2);
	                
		}
}
