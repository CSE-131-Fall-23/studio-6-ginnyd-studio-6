package studio6;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {

	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	public static double geometricSum(int n) {
		
			// FIXME compute the geometric sum for the first n terms recursively
	    if (n == 0) {
	        return 0;
	    } else {
	        double firstTerm = 1.0 / Math.pow(2, n);
	        double commonRatio = 1.0 / 2;
	        double sum = firstTerm;
	        return sum + geometricSum(n - 1); // Recursively sum the previous terms.
	    }
		
	}

	/**
	 * This method uses recursion to compute the greatest common divisor
	 * for the two input values
	 * 
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
		
			// FIXME compute the gcd of p and q using recursion
        if (q == 0) {
            return p;
        } else {
            return gcd(q, p % q);
        }
	}

	

	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but it reverse order
	 */
	public static int[] toReversed(int[] array) {
        if (array.length == 0) {
            return new int[0]; // No change needed for arrays of length 0 or 1
        
        } else {
        int[] reversedArray = new int[array.length];
        return reverseHelper(array, reversedArray, 0, array.length - 1);
        }
	}
	
    private static int[] reverseHelper(int[] original, int[] reversed, int start, int end) {
        if (start >= end) {
        	reversed[start] = original[end];
            return reversed; 
        }

        reversed[start] = original[end];
        reversed[end] = original[start];

        // Recursive call to reverse the remaining elements
        return reverseHelper(original, reversed, start + 1, end - 1);
    }
    
    

	// FIXME create a helper method that can recursively reverse the given array
		


	/**
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	public static void circlesUponCircles(double xCenter, double yCenter, double radius,
			double radiusMinimumDrawingThreshold) {
        if (radius >= radiusMinimumDrawingThreshold) {
            // Draw the circle
            StdDraw.circle(xCenter, yCenter, radius);
            double newRadius = radius / 3.0;
            double xOffset = 2.0 * newRadius;
            double yOffset = 0.0;

            circlesUponCircles(xCenter - xOffset, yCenter + yOffset, newRadius, radiusMinimumDrawingThreshold);
            circlesUponCircles(xCenter + xOffset, yCenter + yOffset, newRadius, radiusMinimumDrawingThreshold);
            circlesUponCircles(xCenter, yCenter - 2 * newRadius, newRadius, radiusMinimumDrawingThreshold);
		}
		
		// FIXME

	}
	

}
