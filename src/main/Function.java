package main;

import net.sourceforge.jeval.EvaluationException;

public class Function {
	/**
	 * @param x
	 *            x in the fuction of x and y; f(x,y) = ...
	 * @param y
	 *            y in the function of x and y; f(x,y) = ...
	 * @return Returns the calculated value of f(x,y) = ... ... represent the
	 *         function written below, which must be adjusted if you want to try
	 *         different functions. By default; the function is: Math.pow(x - 2,
	 *         2) + Math.pow(y - 2, 2);
	 */
	public static double output(double x, double y) {

		// Insert function here:
		if (Main.udFunction) {
			Main.evaluator.putVariable("x", String.valueOf(x));
			Main.evaluator.putVariable("y", String.valueOf(y));
			try {
				return Double.parseDouble(Main.evaluator.evaluate(Main.function));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			} catch (EvaluationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}
		} else {
			return Math.pow((x - 169), 2) + Math.pow((y - 228), 2);
			
		}

	}
}
