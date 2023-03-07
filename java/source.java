import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class app {

	public static void main(String[] args) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		// Assigned JFrame A Name
		JFrame BlackScreen = new JFrame("BlackScreen");
		
		// Assigned App No Title Bar
		BlackScreen.setUndecorated(true);

		// Assigned App To FullScreen
	    GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(BlackScreen);

		// Assigned App Visibility
		BlackScreen.setVisible(true);
		
		// Assigned App Close Operator
		BlackScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Assigned App Background Color
		BlackScreen.getContentPane().setBackground(Color.black);
		
	    // get the smallest valid cursor size
	    Dimension dim = toolkit.getBestCursorSize(1, 1);

	    // create a new image of that size with an alpha channel
	    BufferedImage cursorImg = new BufferedImage(dim.width, dim.height, BufferedImage.TYPE_INT_ARGB);

	    // get a Graphics2D object to draw to the image
	    Graphics2D g2d = cursorImg.createGraphics();

	    // now create your cursor using that transparent image
	    Cursor hiddenCursor = toolkit.createCustomCursor(cursorImg, new Point(0,0), "hiddenCursor");

	    // use the hidden Cursor
	    BlackScreen.setCursor( hiddenCursor );
	}
	
}