package com.codecraft.energizedpower.api;

/**
 * Implemented By Pipes
 * @author Matthieu Parizeau
 */
public interface IPipe extends IPipeConnection {
	
	/**
	 * Get the type of pipe
	 * @return the type of pipe
	 */
	public PipeType getType();
	
}
