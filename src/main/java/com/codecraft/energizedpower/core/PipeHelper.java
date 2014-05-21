package com.codecraft.energizedpower.core;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.inventory.IInventory;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.IFluidHandler;
import net.minecraftforge.fluids.IFluidTank;

import com.codecraft.energizedpower.api.IPipe;
import com.codecraft.energizedpower.api.PipeType;

/**
 * Various Helper Methods for Pipes
 * @author Matthieu Parizeau
 */
public class PipeHelper {
	
	/**
	 * Gets all the pipe connections at the specified location
	 * @param world the world
	 * @param x the x position
	 * @param y the y position
	 * @param z the z position
	 * @param type the type of the pipe
	 * @return all the pipe connections at the specified location
	 */
	public static List<ForgeDirection> getConnections(IBlockAccess world, int x, int y, int z, PipeType type)
	{
		List<ForgeDirection> connections = new ArrayList<ForgeDirection>();
		
		Location location = new Location(world, x, y, z);
		// Loop Through All Valid Directions
		for (ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS)
		{
			// Get a location based on the current direction
			Location dirLoc = location.getFromDirection(direction);
			if (dirLoc.getTile() != null)
			{
				if (dirLoc.getTile() instanceof IPipe)
				{
					// If it's a pipe of the same type then connect
					IPipe pipe = (IPipe)dirLoc.getTile();
					if (pipe.getType() == type)
					{
						connections.add(direction);
					}
				} else if (dirLoc.getTile() instanceof IInventory && type == PipeType.ITEM)
				{
					// If it's an inventory and it's the item type then connect
					connections.add(direction);
				} else if ((dirLoc.getTile() instanceof IFluidTank || dirLoc.getTile() instanceof IFluidHandler) && type == PipeType.FLUID)
				{
					// If it's a fluid related inventory and the pipe type is fluid then connect
					connections.add(direction);
				}
			}
		}
		return connections;
	}
	
}
