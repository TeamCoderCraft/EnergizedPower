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

public class PipeHelper {
	
	public static List<ForgeDirection> getConnections(IBlockAccess world, int x, int y, int z, PipeType type)
	{
		List<ForgeDirection> connections = new ArrayList<ForgeDirection>();
		
		Location location = new Location(world, x, y, z);
		for (ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS)
		{
			Location dirLoc = location.getFromDirection(direction);
			if (dirLoc.getTile() != null)
			{
				if (dirLoc.getTile() instanceof IPipe)
				{
					IPipe pipe = (IPipe)dirLoc.getTile();
					if (pipe.getType() == type)
					{
						connections.add(direction);
					}
				} else if (dirLoc.getTile() instanceof IInventory && type == PipeType.ITEM)
				{
					connections.add(direction);
				} else if ((dirLoc.getTile() instanceof IFluidTank || dirLoc.getTile() instanceof IFluidHandler) && type == PipeType.FLUID)
				{
					connections.add(direction);
				}
			}
		}
		return connections;
	}
	
}
