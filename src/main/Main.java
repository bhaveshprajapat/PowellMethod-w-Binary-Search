package main;

import java.util.Scanner;

/**
 * @author Bhavesh Prajapat
 *
 */
public class Main {

	// Sets the n in the Sn value to 2 (for a 2 dimensional array)
	static int n = 2;
	// Creates a new double for storing bounds
	public static double initialBounds;
	// Create a new array for storing the start point
	public static double[] startPoint = new double[n];
	public static double tolerance;
	public static double[] lowerBound = new double[n];
	public static double[] upperBound = new double[n];
	public static double[] currentPoint = new double[n];
	public static int YIter = 0;

	/**
	 * @param args[0]
	 *            The starting X coordinate (typically 1)
	 * @param args[1]
	 *            The starting Y coordinate (typically 1)
	 * @param args[2]
	 *            The bounds for which co-ordinates should be tested to. This
	 *            allows you to configure an inequality in b where b is the
	 *            current point being tested. An example of such inequality is
	 *            as such: b-10 <= b <= b+10. This creates the upperBound and
	 *            lowerBound for each iteration of optimisation.
	 * @param args[3]
	 *            The tolerance for which the program is set to stop optimising
	 *            over a certain set of bounds. If our upperBound and lowerBound
	 *            are, per se, within 0.0001 of each other, we can predict that
	 *            the value we are looking for is very close to the midpoint
	 *            between those two bounds. You shouldn't use whole number
	 *            integers. An order of magnitude of x10-4 or less is
	 *            recommended. Input as decimal e.g. 0.0004
	 */
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		// Set variables up
		startPoint[0] = Double.parseDouble(args[0]);
		startPoint[1] = Double.parseDouble(args[1]);
		initialBounds = Integer.parseInt(args[2]);
		tolerance = Double.parseDouble(args[3]);
		// Asks for variables if any of them are null
		if (startPoint[0] == new Double(0)) {
			System.out.print("Enter X Co-Ordinates for start point: ");
			startPoint[0] = kb.nextDouble();
			System.out.println("");
		}
		if (startPoint[1] == new Double(0)) {
			System.out.print("Enter Y Co-Ordinates for start point: ");
			startPoint[1] = kb.nextDouble();
			System.out.println("");
		}
		if (initialBounds == 0) {
			System.out.print("Enter bounds: ");
			startPoint[0] = kb.nextInt();
			System.out.println("");
		}
		if (tolerance == new Double(0)) {
			System.out.print("Enter tolerance: ");
			startPoint[0] = kb.nextDouble();
			System.out.println("");
		}
		// Print current configuration
		System.out.println("Printing current configuration:");
		System.out.println("Start point: " + startPoint[0] + ", " + startPoint[1]);
		System.out.println("Initial bounds: " + initialBounds);
		System.out.println("Tolerance: " + tolerance);
		// Sets initial upper and lower bounds
		lowerBound[0] = startPoint[0] - initialBounds;
		lowerBound[1] = startPoint[1] - initialBounds;
		upperBound[0] = startPoint[0] + initialBounds;
		upperBound[1] = startPoint[1] + initialBounds;

		// Optimise through by startPoint
		OptimiseY.optimise(startPoint[0]);
		System.out.println("Optimise Y ran with result: X=" + startPoint[0]);
		OptimiseX.optimise(startPoint[1]);
		System.out.println("Optimise X ran with result: Y=" + startPoint[1]);
		YIter += 1;
		double[] savedPoint1 = new double[n];
		savedPoint1[0] = startPoint[0];
		savedPoint1[1] = startPoint[1];
		double[] savedPoint2 = new double[n];
		while (true) {
			savedPoint2[0] = currentPoint[0];
			savedPoint2[1] = currentPoint[1];
			// Optimise through by currentPoint
			OptimiseY.optimise(currentPoint[0]);
			System.out.println("Optimise Y ran with result: X=" + currentPoint[0]);
			OptimiseX.optimise(currentPoint[1]);
			System.out.println("Optimise X ran with result: Y=" + currentPoint[1]);
			YIter += 1;
			if (YIter == 2) {
				dVector newDirection = new dVector();
				newDirection.updateVect(savedPoint1[0], savedPoint1[1], savedPoint2[0], savedPoint2[1]);
				//The program wil end after this line
			}
			if (StopCriteria.stop(savedPoint2[0], currentPoint[0])
					&& StopCriteria.stop(savedPoint2[1], currentPoint[1])) {
				break;
			}
		}
		kb.close();
	}

}
