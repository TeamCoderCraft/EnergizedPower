package com.codecraft.energizedpower.core;

/**
 * Various Math Utilities
 * @author Matthieu Parizeau
 */
public class MathUtil {
	
	/**
	 * Gets the minimum of two values based on direction
	 * @param dirOffset the offset of the direction
	 * @param min the minimum
	 * @param max the maximum
	 * @return the minimum of two values based on direction
	 */
	public static float min(float dirOffset, float min, float max)
	{
		return dirOffset == 1 ? max : dirOffset == -1 ? 0 : min;
	}
	
	/**
	 * Gets the maximum of two values based on direction
	 * @param dirOffset the offset of the direction
	 * @param min the minimum
	 * @param max the maximum
	 * @return the maximum of two values based on direction
	 */
	public static float max(float dirOffset, float min, float max)
	{
		return dirOffset == 1 ? 1 : dirOffset == -1 ? min : max;
	}
	
}
