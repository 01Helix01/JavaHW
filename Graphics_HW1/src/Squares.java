import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public class Squares extends Frame {
	   public static void main(String[] args) {new Squares();}

	   Squares() {
	      super("Squares");
	      addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent e) {System.exit(0);}
	      });
	      setSize(600, 600);
	      add("Center", new CvSquare());
	      setVisible(true);
	   }
	}

	class CvSquare extends Canvas {
	   public void paint(Graphics g) {
		  Graphics2D g2 = (Graphics2D) g;
	      Dimension d = getSize();
	      int maxX = d.width - 1, maxY = d.height - 1;
	      
	      // rotate by 45 degrees
	      double squareRotate = Math.toRadians(45);
	      double squareFactor = 1/(Math.sin(squareRotate) + Math.cos(squareRotate));
	      double squareSize = 300;
	      
	      g2.translate(squareSize, squareSize);
	      
	      // Draw squares
	      for(int i = 0; i < 15; i++) {
	    	  int rectangleSize = (int) Math.round(squareSize);
	    	  g2.drawRect(-rectangleSize/2, -rectangleSize/2, rectangleSize, rectangleSize);
	    	  
	    	  // Update size
	    	  squareSize = squareSize * squareFactor;
	    	  
	    	  // Rotate
	    	  g2.rotate(squareRotate);
	      }
	   }
	}
