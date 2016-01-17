package main;

public class OptimiseY {
	public static void optimise(final double x) {
		double foflowerBound = Function.output(x, Main.lowerBound[1]);
		double fofupperBound = Function.output(x, Main.upperBound[1]);
		double fofXAndY = Function.output(x, Main.startPoint[1]);
		if (foflowerBound > fofupperBound && foflowerBound > fofXAndY) {
			Main.lowerBound[1] = Main.startPoint[1];
		}
		if (fofupperBound > foflowerBound && fofupperBound > fofXAndY) {
			Main.upperBound[1] = Main.startPoint[1];
		}
		double[] midpoint = new double[2];
		midpoint[0] = x;
		midpoint[1] = (Main.upperBound[1] + Main.lowerBound[1]) / 2;
		while (true) {

			foflowerBound = Function.output(x, Main.lowerBound[1]);
			fofupperBound = Function.output(x, Main.upperBound[1]);
			fofXAndY = Function.output(x, midpoint[1]);
			if (foflowerBound > fofupperBound && foflowerBound > fofXAndY) {
				Main.lowerBound[1] = midpoint[1];
			}
			if (fofupperBound > foflowerBound && fofupperBound > fofXAndY) {
				Main.upperBound[1] = midpoint[1];
			}
			midpoint[1] = (Main.upperBound[1] + Main.lowerBound[1]) / 2;

			if (StopCriteria.stop(Function.output(x, Main.upperBound[1]), Function.output(x, Main.lowerBound[1]))) {
				break;
			}
		} // End Loop
		System.out.println("Optimal value for Y found at :" + midpoint[0] + ", " + midpoint[1]);

	}
}
