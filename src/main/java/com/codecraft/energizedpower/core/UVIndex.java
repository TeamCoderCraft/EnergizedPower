package com.codecraft.energizedpower.core;

/**
 * UV Wrapper
 * @author Matthieu Parizeau
 */
public class UVIndex {
	
	public final double minU, maxU, minV, maxV;
	
	/**
	 * Initializes a new UVIndex
	 * @param minU minimum U
	 * @param maxU maximum U
	 * @param minV minimum V
	 * @param maxV maximum V
	 */
	public UVIndex(double minU, double maxU, double minV, double maxV)
	{
		this.minU = minU;
		this.maxU = maxU;
		this.minV = minV;
		this.maxV = maxV;
	}
	
}
