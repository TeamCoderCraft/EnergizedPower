package com.codecraft.energizedpower.core;

import java.util.Objects;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

public class Location {
	
	private IBlockAccess world;
	private int x, y, z;
	
	public Location(IBlockAccess world, int x, int y, int z)
	{
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Block getBlock()
	{
		return world.getBlock(x, y, z);
	}
	
	public int getMetadata()
	{
		return world.getBlockMetadata(x, y, z);
	}
	
	public TileEntity getTile()
	{
		return world.getTileEntity(x, y, z);
	}
	
	public Location getFromDirection(ForgeDirection direction)
	{
		switch (direction)
		{
			case DOWN:
				return new Location(world, x, y - 1, z);
			case EAST:
				return new Location(world, x + 1, y, z);
			case NORTH:
				return new Location(world, x, y, z - 1);
			case SOUTH:
				return new Location(world, x, y, z + 1);
			case UP:
				return new Location(world, x, y + 1, z);
			case WEST:
				return new Location(world, x - 1, y, z);
			default:
				return null;
			
		}
	}
	
	@Override
	public String toString()
	{
		return "Location:{X:" + x + ", Y:" + y + ", Z:" + z + "}";
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof Location))
			return false;
		
		Location loc = (Location)o;
		
		return this.getWorld() == loc.getWorld() && this.getX() == loc.getX() && this.getY() == loc.getY() && this.getZ() == loc.getZ();
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(this.world, this.x, this.y, this.z);
	}
	
	public IBlockAccess getWorld()
	{
		return this.world;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public int getZ()
	{
		return this.z;
	}
	
}
