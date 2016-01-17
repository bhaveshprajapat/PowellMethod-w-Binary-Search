package main;

public class StopCriteria {

	/**
	 * @param last
	 *            The previous set of coordinates being used in calculations
	 * @param current
	 *            The current set of coordinates being used in calculations
	 * @return
	 */
	public static boolean stop(double last, double current) {
		if (Math.abs(current - last) < Main.tolerance) {
			return true;
		} else {
			return false;
		}

	}
}
