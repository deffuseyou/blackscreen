import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class app {
    public static void main(String[] args) {
        JFrame blackScreen = new JFrame();

        // Configure window appearance and behavior
        blackScreen.setUndecorated(true); // Remove window borders and title bar
        blackScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit on close
        blackScreen.getContentPane().setBackground(Color.BLACK); // Set background to black
        blackScreen.setCursor(getInvisibleCursor()); // Hide the mouse cursor
        // blackScreen.setAlwaysOnTop(true); // (Optional) Keep window always on top
        blackScreen.setResizable(false); // Disable resizing

        // Add ESC key listener to exit the app
        blackScreen.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                }
            }
        });

        // Determine the screen where the mouse is located at launch
        Point mouse = MouseInfo.getPointerInfo().getLocation();
        GraphicsDevice screen = findScreen(mouse);
        if (screen == null)
            screen = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

        // Set window bounds to match the screen dimensions
        Rectangle bounds = screen.getDefaultConfiguration().getBounds();
        blackScreen.setBounds(bounds);
        blackScreen.setVisible(true); // Show the window
    }

    // Returns the GraphicsDevice (monitor) that contains the given point
    private static GraphicsDevice findScreen(Point p) {
        for (GraphicsDevice gd : GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()) {
            if (gd.getDefaultConfiguration().getBounds().contains(p)) {
                return gd;
            }
        }
        return null;
    }

    // Creates and returns a fully transparent custom cursor
    private static Cursor getInvisibleCursor() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getBestCursorSize(1, 1);
        BufferedImage cursorImg = new BufferedImage(dim.width, dim.height, BufferedImage.TYPE_INT_ARGB);
        return toolkit.createCustomCursor(cursorImg, new Point(0, 0), "hiddenCursor");
    }
}
