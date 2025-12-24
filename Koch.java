/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        /*
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		*/

		/*
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		*/

		snowFlake(Integer.parseInt(args[0]));
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {

		if (n == 0){
			StdDraw.line(x1, y1, x2, y2);
			return;
		}
		
		double x3 = (((Math.sqrt(3)) / 6 ) * (y1 - y2) + (0.5 * (x1 + x2)));
		double y3 = (((Math.sqrt(3)) / 6 ) * (x2 - x1) + (0.5 * (y1 + y2)));

		double px13 = x1 + (x2 - x1) / 3.0;
		double py13 = y1 + (y2 - y1) / 3.0;
		double px23 = x1 + 2 * (x2 - x1) / 3.0;
		double py23 = y1 + 2 * (y2 - y1) / 3.0;
		//StdDraw.line(px13, py13, x3, y3);
		//StdDraw.line(px23, py23, x3, y3);

		curve(n - 1, x1, y1, px13, py13);
		curve(n - 1, px13, py13, x3, y3);
		curve(n - 1, x3, y3, px23, py23);
		curve(n - 1, px23, py23, x2, y2);

	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
		// Draws a Koch snowflake of depth n
		
		double x1bottom = 0.55; double y1bottom = 0.05;
		double x1right = 0.95; double y1right = 0.75;
		double x1left = 0.15; double y1left = 0.75;

		//StdDraw.line(x1bottom, y1bottom, x1right, y1right);
		//StdDraw.line(x1right, y1right, x1left, y1left);
		//StdDraw.line(x1left, y1left, x1bottom, y1bottom);

		curve (n,x1left, y1left, x1right, y1right);
		curve (n ,x1right, y1right ,x1bottom, y1bottom);
		curve (n ,x1bottom, y1bottom, x1left, y1left);
		


	}
}
