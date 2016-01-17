package main;

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

	public static void main(String[] args) {
		// Set variables up
		startPoint[0] = Double.parseDouble(args[0]);
		startPoint[1] = Double.parseDouble(args[1]);
		initialBounds = Integer.parseInt(args[2]);
		tolerance = Double.parseDouble(args[3]);
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

		// Optimise within bounds for Y ONLY
		OptimiseY.optimise(startPoint[0]);

	}

}
