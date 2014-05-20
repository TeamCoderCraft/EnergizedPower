package com.codecraft.energizedpower.core;

public class MathUtil {
	
	public static float min(float dirOffset, float min, float max)
	{
		return dirOffset == 1 ? max : dirOffset == -1 ? 0 : min;
	}
	
	public static float max(float dirOffset, float min, float max)
	{
		return dirOffset == 1 ? 1 : dirOffset == -1 ? min : max;
	}
	
}
