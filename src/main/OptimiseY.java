package main;

public class OptimiseY {
	/**
	 * @param x The x co-ordinate to remain constant during execution
	 */
	public static void optimise(final double x) {
		//Declare vars for storing Z (f(x,y))
		double fOfLowerBound;
		double fOfUpperBound;
		double fOfXAndY; //Current midpoint
		double[] midpoint = new double[2];
		//As we are only optimising Y, X will remain constant
		midpoint[0] = x;
		//Sets the midpoint based on the new bounds
		midpoint[1] = (Main.upperBound[1] + Main.lowerBound[1]) / 2;
		while (true) {
			//Calculates f(x,y) for the upper bound, lower bound and midpoint
			fOfLowerBound = Function.output(x, Main.lowerBound[1]);
			fOfUpperBound = Function.output(x, Main.upperBound[1]);
			fOfXAndY = Function.output(x, midpoint[1]);
			//Casts out the highest bound
			if (fOfLowerBound > fOfUpperBound && fOfLowerBound > fOfXAndY) {
				Main.lowerBound[1] = midpoint[1];
			}
			if (fOfUpperBound > fOfLowerBound && fOfUpperBound > fOfXAndY) {
				Main.upperBound[1] = midpoint[1];
			}
			//Generates a new midpoint
			midpoint[1] = (Main.upperBound[1] + Main.lowerBound[1]) / 2;
			//Calculates whether we should stop
			if (StopCriteria.stop(Function.output(x, Main.upperBound[1]), Function.output(x, Main.lowerBound[1]))) {
				break;
			}
		} 
		//System.out.println("Optimal value for y found at :" + x + ", " + midpoint[1]);
		Main.currentPoint[0] = x;
		Main.currentPoint[1] = midpoint[1];
	}
}
