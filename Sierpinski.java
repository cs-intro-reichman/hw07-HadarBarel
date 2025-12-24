/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {

		StdDraw.setCanvasSize(500, 500);
		StdDraw.setXscale(0,1);
		StdDraw.setYscale(0,1);

		double x1 = 0.0; double y1 = 0.0;
		double x2 = 1.0; double y2 = 0.0;
		double x3 = 0.5; double y3 = Math.sqrt(3)/2;

		StdDraw.line(x1, y1, x2, y2);
		StdDraw.line(x2, y2, x3, y3);
		StdDraw.line(x3, y3, x1, y1);

		sierpinski(n, x1, x2, x3, y1, y2, y3);
	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3, double y1, double y2, double y3) {

		if (n == 0){
			return;
		}
		
		double new_x1 = (x1 + x3) / 2; double new_y1 = (y1 + y3) / 2;
		double new_x2 = (x2 + x3) / 2; double new_y2 = (y2 + y3) / 2;
		double new_x3 = (x1 + x2) / 2; double new_y3 = (y1 + y2) / 2;

		StdDraw.line(new_x1, new_y1, new_x2, new_y2);
		StdDraw.line(new_x2, new_y2, new_x3, new_y3);
		StdDraw.line(new_x3, new_y3, new_x1, new_y1);


		sierpinski(n-1, new_x1, new_x2, x3, new_y1, new_y2, y3);
		sierpinski(n-1, new_x3, x2, new_x2, new_y3, y2, new_y2);
		sierpinski(n-1, x1, new_x3, new_x1, y1, new_y3, new_y1);
		


	}
}
