package com.codecraft.energizedpower.api;

import net.minecraft.world.IBlockAccess;

/**
 * Implement this to be able to connect to pipes
 * @author Matthieu Parizeau
 */
public interface IPipeConnection {
	
	/**
	 * Can a pipe connect to this block
	 * @param world the world
	 * @param x the x position
	 * @param y the y position
	 * @param z the z position
	 * @param side the side of the block to connect to
	 * @param type the type of the pipe
	 * @return whether the pipe can connect to this block or not
	 */
	public boolean canConnect(IBlockAccess world, int x, int y, int z, int side, PipeType type);
	
}
