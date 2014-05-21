package com.codecraft.energizedpower.core;

import java.util.Objects;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Location Wrapper
 * @author Matthieu Parizeau
 */
public class Location {
	
	private IBlockAccess world;
	private int x, y, z;
	
	/**
	 * Creates a new location
	 * @param world the world
	 * @param x the x position
	 * @param y the y position
	 * @param z the z position
	 */
	public Location(IBlockAccess world, int x, int y, int z)
	{
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * Gets the block at this location
	 * @return the block at this location
	 */
	public Block getBlock()
	{
		return world.getBlock(x, y, z);
	}
	
	/**
	 * Gets the block metadata at this location
	 * @return the block metadata at this location
	 */
	public int getMetadata()
	{
		return world.getBlockMetadata(x, y, z);
	}
	
	/**
	 * Gets the tileentity at this location
	 * @return the tileentity at this location
	 */
	public TileEntity getTile()
	{
		return world.getTileEntity(x, y, z);
	}
	
	/**
	 * Gets another location based on the direction specified
	 * @param direction the direction to get the location from
	 * @return the new location
	 */
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
	
	/**
	 * Gets the world
	 * @return the world
	 */
	public IBlockAccess getWorld()
	{
		return this.world;
	}
	
	/**
	 * Gets the x position
	 * @return the x position
	 */
	public int getX()
	{
		return this.x;
	}
	
	/**
	 * Gets the y position
	 * @return the y position
	 */
	public int getY()
	{
		return this.y;
	}
	
	/**
	 * Gets the z position
	 * @return the z position
	 */
	public int getZ()
	{
		return this.z;
	}
	
}
