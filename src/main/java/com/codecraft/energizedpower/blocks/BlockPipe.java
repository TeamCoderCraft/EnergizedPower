package com.codecraft.energizedpower.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.codecraft.energizedpower.api.PipeType;
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
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@Override
	public int getRenderType()
	{
		return -1;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TilePipe(PipeType.getById(metadata));
	}
	
}
