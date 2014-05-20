package com.codecraft.energizedpower.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.codecraft.energizedpower.api.PipeType;
import com.codecraft.energizedpower.proxy.ClientProxy;
import com.codecraft.energizedpower.tiles.TilePipe;

/**
 * Pipe Block
 * @author Matthieu Parizeau
 */
public class BlockPipe extends StandardTileBlock {

	public BlockPipe()
	{
		super(Material.iron);
		this.setHardness(0.6F);
		this.setResistance(1.0F);
		//float min = 5.5F / 16.0F;
		//float max = 1.0F-min;
		//this.setBlockBounds(min, min, min, max, max, max);
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return true;
	}
	
	@Override
	public int getRenderType()
	{
		return ClientProxy.pipeId;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TilePipe(PipeType.getById(metadata));
	}
	
}
