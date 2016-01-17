package main;

public class UseVector {
	public static double[] use(dVector newdirection, final double[] startPoint, double bounds) {
/*		double xvec = newdirection.x;
		double yvec = newdirection.y;
		double[] localupperxy = new double[Main.n];
		double[] locallowerxy = new double[Main.n];
		double[] savedPoint = new double[Main.n];
		int control = 0;

		// Declare vars for storing Z (f(x,y))
		double fOfLowerBound;
		double fOfUpperBound;
		double fOfXAndY; // Current midpoint
		double[] midpoint = new double[2];
		// As we are only optimising X, Y will remain constant
		midpoint[1] = startPoint[1];
		// Sets the midpoint based on the new bounds
		midpoint[0] = startPoint[0];
		while (true) {
			control += 1;
			locallowerxy[0] = midpoint[0] * (-1 * xvec * bounds);
			locallowerxy[1] = midpoint[1] * (-1 * yvec * bounds);
			localupperxy[0] = midpoint[0] * xvec * bounds;
			localupperxy[1] = midpoint[1] * yvec * bounds;

			// Calculates f(x,y) for the upper bound, lower bound and midpoint
			fOfLowerBound = Function.output(locallowerxy[0], locallowerxy[1]);
			fOfUpperBound = Function.output(localupperxy[0], localupperxy[1]);
			fOfXAndY = Function.output(midpoint[0], midpoint[1]);
			// Casts out the highest bound
			if (fOfLowerBound > fOfUpperBound && fOfLowerBound > fOfXAndY) {
				locallowerxy[0] = midpoint[0];
				locallowerxy[1] = midpoint[1];
			}
			if (fOfUpperBound > fOfLowerBound && fOfUpperBound > fOfXAndY) {
				localupperxy[0] = midpoint[0];
				localupperxy[1] = midpoint[1];
			}

			// Generates a new midpoint
			savedPoint[0] = midpoint[0];
			savedPoint[1] = midpoint[1];
			midpoint[0] = (localupperxy[0] + locallowerxy[0]) / 2;
			midpoint[1] = (localupperxy[1] + locallowerxy[1]) / 2;

			// Calculates whether we should stop
			double fOfSP = Function.output(savedPoint[0], savedPoint[1]);
			double fOfCP = Function.output(midpoint[0], midpoint[1]);
			if (StopCriteria.stop(fOfSP, fOfCP)) {
				break;
			}
		}
		if (control == 100) {
			break;
		}

	}

	double[] ans = new double[Main.n];ans[0]=midpoint[0];ans[1]=midpoint[1];

	return ans;*/
		
		// To write new code for optimising z by y by x
}}
