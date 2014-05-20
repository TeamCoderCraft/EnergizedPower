package com.codecraft.energizedpower.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

import com.codecraft.energizedpower.api.PipeType;
import com.codecraft.energizedpower.core.MathUtil;
import com.codecraft.energizedpower.core.PipeHelper;
import com.codecraft.energizedpower.tiles.TilePipe;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderPipe implements ISimpleBlockRenderingHandler {
	
	private static final float MIN = 16F / 48F;
	private static final float MAX = 32F / 48F;
	
	public RenderPipe()
	{
		
	}

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer)
	{
		this.setCenterBounds(block);
		renderer.setRenderBoundsFromBlock(block);
		this.renderInventory(block, metadata);
		block.setBlockBoundsForItemRender();
	}
	
	public void setCenterBounds(Block block)
	{
		block.setBlockBounds(MIN, MIN, MIN, MAX, MAX, MAX);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		this.setCenterBounds(block);
		renderer.setRenderBoundsFromBlock(block);
		renderer.renderStandardBlock(block, x, y, z);
		
		PipeType type = ((TilePipe)world.getTileEntity(x, y, z)).getType();
		
		for (ForgeDirection direction : PipeHelper.getConnections(world, x, y, z, type))
		{
			block.setBlockBounds(MathUtil.min(direction.offsetX, MIN, MAX), MathUtil.min(direction.offsetY, MIN, MAX), MathUtil.min(direction.offsetZ, MIN, MAX), MathUtil.max(direction.offsetX, MIN, MAX), MathUtil.max(direction.offsetY, MIN, MAX), MathUtil.max(direction.offsetZ, MIN, MAX));
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);
		}
		
		block.setBlockBoundsForItemRender();
		
		return true;
	}
	
	public void renderInventory(Block block, int metadata)
	{
		
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId)
	{
		return true;
	}

	@Override
	public int getRenderId()
	{
		return -1;
	}
	
}