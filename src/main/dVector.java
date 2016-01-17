package main;

public class dVector {
	public double x, y;
	public double[] midpoint = new double[Main.n];

	public void updateVect(double x1, double y1, double x2, double y2) {
		x = x1 - x2;
		y = y1 - y2;
		midpoint[0] = (x1+x2)/2;
		midpoint[1] = (y1+y2)/2;
	}
}
