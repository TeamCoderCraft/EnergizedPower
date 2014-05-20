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
		super(Material.ground);
		this.setHardness(0.0F);
		this.setResistance(0.0F);
		this.setStepSound(soundTypeGlass);
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@Override
	public int getRenderType()
	{
		return ClientProxy.pipeId;
	}
	
	@Override
	public int damageDropped(int meta)
	{
		return meta;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TilePipe(PipeType.getById(metadata));
	}
	
}
