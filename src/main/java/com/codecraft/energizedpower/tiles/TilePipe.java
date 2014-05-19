package com.codecraft.energizedpower.tiles;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.IBlockAccess;

import com.codecraft.energizedpower.api.IPipe;
import com.codecraft.energizedpower.api.PipeType;

/**
 * Pipe Tile
 * @author Matthieu Parizeau
 */
public class TilePipe extends StandardTile implements IPipe {
	
	/**
	 * Type of the pipe
	 */
	protected PipeType type;
	
	public TilePipe() { }
	
	public TilePipe(PipeType type)
	{
		this.type = type;
	}
	
	@Override
	public boolean canUpdate()
	{
		return super.canUpdate();
	}
	
	@Override
	public void updateEntity()
	{
		super.updateEntity();
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setInteger("Type", this.type.getId());
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		this.type = PipeType.getById(compound.getInteger("Type"));
	}

	@Override
	public boolean canConnect(IBlockAccess world, int x, int y, int z, int side, PipeType type)
	{
		return type == this.getType();
	}

	@Override
	public PipeType getType()
	{
		return this.type;
	}
	
}
