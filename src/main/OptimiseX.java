package main;

public class OptimiseX {
	/**
	 * @param y
	 *            The y co-ordinate to remain constant during execution
	 */
	public static void optimise(final double y) {
		// Declare vars for storing Z (f(x,y))
		double fOfLowerBound;
		double fOfUpperBound;
		double fOfXAndY; // Current midpoint
		double[] midpoint = new double[2];
		// As we are only optimising X, Y will remain constant
		midpoint[1] = y;
		// Sets the midpoint based on the new bounds
		midpoint[0] = (Main.upperBound[0] + Main.lowerBound[0]) / 2;
		while (true) {
			// Calculates f(x,y) for the upper bound, lower bound and midpoint
			fOfLowerBound = Function.output(Main.lowerBound[0], y);
			fOfUpperBound = Function.output(Main.upperBound[0], y);
			fOfXAndY = Function.output(midpoint[0], y);
			// Casts out the highest bound
			if (fOfLowerBound > fOfUpperBound && fOfLowerBound > fOfXAndY) {
				Main.lowerBound[0] = midpoint[0];
			}
			if (fOfUpperBound > fOfLowerBound && fOfUpperBound > fOfXAndY) {
				Main.upperBound[0] = midpoint[0];
			}
			// Generates a new midpoint
			midpoint[0] = (Main.upperBound[0] + Main.lowerBound[0]) / 2;
			// Calculates whether we should stop
			if (StopCriteria.stop(Function.output(Main.upperBound[0], y), Function.output(Main.lowerBound[0], y))) {
				break;
			}
		}
		// System.out.println("Optimal value for x found at :" + midpoint[0] +
		// ", " + y);
		Main.currentPoint[0] = midpoint[0];
		Main.currentPoint[1] = y;
	}
}
