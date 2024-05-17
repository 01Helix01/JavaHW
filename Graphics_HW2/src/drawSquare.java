import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public class drawSquare extends Frame {
	   public static void main(String[] args) {new drawSquare();}

	   drawSquare() {
	      super("drawSquare");
	      addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent e) {System.exit(0);}
	      });
	      setSize(600, 600);
	      add("Center", new CvSquare());
	      setCursor(Cursor.getPredefinedCursor(CROSSHAIR_CURSOR));
	      show();
	   }
	}

	class CvSquare extends Canvas {
		int Ax, Ay, Bx, By;
		boolean pointA;
		Point from, to;
		
		CvSquare() {
			pointA = true;
			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent click) {
					if(pointA) {
						from = click.getPoint();
						pointA = false;
					} else {
						to = click.getPoint();
						pointA = true;
						repaint();
					}
				}
			});
		}
		
	   public void paint(Graphics g) {
		   // Get point A
		   Ax = from.x;
		   Ay = from.y;
		   
		   // Get point B
		   Bx = to.x;
		   By = to.y;
		   
		   // Get point C
		   int Cx = (Bx + (Ay - By));
		   int Cy = (By + (Bx - Ay));
		   
		   // Get point D
		   int Dx = (Ax + (Ay - By));
		   int Dy = (Ay + (Bx - Ay));
		   
		   // Draw lines counter clockwise
		   g.drawLine(Ax, Ay, Bx, By); // A -> B
		   g.drawLine(Bx, By, Cx, Cy); // B -> C
		   g.drawLine(Cx, Cy, Dx, Dy); // C -> D
		   g.drawLine(Dx, Dy, Ax, Ay); // D -> A
	   }
	}