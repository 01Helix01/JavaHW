// Rota3DTest.java: Rotating a cube about an axis 
//    parallel to a diagonal of its top plane.
//    Uses: Point3D, Rota3D (discussed above).
public class Rota3DCube {
	
   public static void main(String[] args) {
	   
	   // check number of command line arguments
	   if (args.length != 5) {
	      System.out.println("java Rota3DCube a1 a2 a3 alpha axis");
	      return;
	   }
	 
	  // parse command line arguments
	  float a1 = Integer.parseInt(args[0]);
	  float a2 = Integer.parseInt(args[1]);
	  float a3 = Integer.parseInt(args[2]);
	  int alpha = Integer.parseInt(args[3]);
	  String axis = args[4];
	      
	  // convert angle of rotation deg -> rad
	  double radians = Math.toRadians(alpha);
	  
	  Point3D arb = new Point3D(a1, a2, a3);
      
      // Specify point arb as directed axis of rotation
      // and alpha as the rotation angle:
      Rota3D.initRotate(arb, arb, alpha);
      // Vertices of a cube; 0, 1, 2, 3 at the bottom,
      // 4, 5, 6, 7 at the top. Vertex 0 at the origin O:
      Point3D[] v = {
            new Point3D(0, 0, 0), new Point3D(1, 0, 0),
            new Point3D(1, 1, 0), new Point3D(0, 1, 0),
            new Point3D(0, 0, 1), new Point3D(1, 0, 1),
            new Point3D(1, 1, 1), new Point3D(0, 1, 1)};
      
      Point3D[] vNew = {
              new Point3D(0, 0, 0), new Point3D(1, 0, 0),
              new Point3D(1, 1, 0), new Point3D(0, 1, 0),
              new Point3D(0, 0, 1), new Point3D(1, 0, 1),
              new Point3D(1, 1, 1), new Point3D(0, 1, 1)};
      
      
      // Translate arb to origin and move the cube accordingly
      for(int i = 0; i < 8; i++)
      {
    	  vNew[i].x -= a1;
    	  vNew[i].y -= a2;
    	  vNew[i].z -= a3;
      }
      
      

      // Rotate
      float r11=0, r12=0, r13=0, r21=0, r22=0, r23=0, r31=0, r32=0, r33=0;

      /*
		 		 | r11  r12  r13 |
			R =  | r21  r22  r23 |
				 | r31  r32  r33 |
       */
      
      float cos = (float)Math.cos(radians);
      float sin = (float)Math.sin(radians);
      
      // Form rotational matrix depending on our axis of rotation
      switch(axis) {
      case "x_axis":
    	  r11 = 1; r12 = 0; r13 = 0;
    	  r21 = 0; r22 = cos; r23 = sin;
    	  r31 = 0; r32 = -sin; r33 = cos;
    	  break;
      case "y_axis":
    	  r11 = cos; r12 = 0; r13 = -sin;
    	  r21 = 0; r22 = 1; r23 = 0;
    	  r31 = sin; r32 = 0; r33 = cos;
    	  break;
      case "z_axis":
    	  r11 = cos; r12 = sin; r13 = 0;
    	  r21 = -sin; r22 = cos; r23 = 0;
    	  r31 = 0; r32 = 0; r33 = 1;
    	  break;
      default: System.out.println("Invalid axis");
    	  break;
      }
      
      // Multiply rotational matrix by each point
      for(int i = 0; i < 8; i++)
      {
	      float x = v[i].x;
	      float y = v[i].y;
	      float z = v[i].z;
	      
	      float x1 = x*r11 + y*r12 + z*r13;
	      float x2 = x*r21 + y*r22 + z*r23;
	      float x3 = x*r31 + y*r32 + z*r33;
	      
	      vNew[i].x = x1;
	      vNew[i].y = x2;
	      vNew[i].z = x3;
      }

      // Translate arb back to it's original position and move cube accordingly
      for(int i = 0; i < 8; i++)
      {
    	  vNew[i].x += a1;
    	  vNew[i].y += a2;
    	  vNew[i].z += a3;
      }
      

      System.out.println("Rotate unit cube " + radians + " about the " + axis + " at point (" + a1 + ", " + a2 + ", " + a3 + ")");
      System.out.println("Vertices of cube:");
      System.out.println("    Before rotation    After rotation");
      for (int i = 0; i < 8; i++) {
         System.out.println(i + ":  " + 
        	v[i].x + " " + v[i].y + " " + v[i].z + "        " + 
        	vNew[i].x + " " + vNew[i].y + " " + vNew[i].z);
      }
   }
}