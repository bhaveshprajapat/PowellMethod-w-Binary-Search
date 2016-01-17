package main;

//To be changed in accordance  to Optimise Y's releveance to X
public class OptimiseX {

	public static void optimise(final double y) {
		double fOflowerBound = Function.output(y, Main.lowerBound[1]);
		double fOfupperBound = Function.output(y, Main.upperBound[1]);
		double fOfXAndY = Function.output(y, Main.startPoint[1]);
		if (fOflowerBound > fOfupperBound && fOflowerBound > fOfXAndY) {
			Main.lowerBound[1] = Main.startPoint[1];
		}
		if (fOfupperBound > fOflowerBound && fOfupperBound > fOfXAndY) {
			Main.upperBound[1] = Main.startPoint[1];
		}
		double[] midpoint = new double[2];
		midpoint[0] = y;
		midpoint[1] = (Main.upperBound[1] + Main.lowerBound[1]) / 2;
		while (true) {

			fOflowerBound = Function.output(y, Main.lowerBound[1]);
			fOfupperBound = Function.output(y, Main.upperBound[1]);
			fOfXAndY = Function.output(y, midpoint[1]);
			if (fOflowerBound > fOfupperBound && fOflowerBound > fOfXAndY) {
				Main.lowerBound[1] = midpoint[1];
			}
			if (fOfupperBound > fOflowerBound && fOfupperBound > fOfXAndY) {
				Main.upperBound[1] = midpoint[1];
			}
			midpoint[1] = (Main.upperBound[1] + Main.lowerBound[1]) / 2;

			if (StopCriteria.stop(Function.output(y, Main.upperBound[1]), Function.output(y, Main.lowerBound[1]))) {
				break;
			}
		} // End Loop
		System.out.println("Optimal value for Y found at :" + midpoint[0] + ", " + midpoint[1]);

	}
}
