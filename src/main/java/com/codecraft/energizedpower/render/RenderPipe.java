package com.codecraft.energizedpower.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

import com.codecraft.energizedpower.api.PipeType;
import com.codecraft.energizedpower.core.MathUtil;
import com.codecraft.energizedpower.core.PipeHelper;
import com.codecraft.energizedpower.reference.Reference;
import com.codecraft.energizedpower.tiles.TilePipe;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

/**
 * Pipe Renderer
 * @author Matthieu Parizeau
 */
public class RenderPipe implements ISimpleBlockRenderingHandler {
	
	private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/blocks/pipe.png");
	
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
		Tessellator tessellator = Tessellator.instance;
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		
		tessellator.startDrawingQuads();
		{
			// Outside
			
			// Front
			tessellator.addVertexWithUV(MIN, 0.0F, MIN, MIN, MIN);
			tessellator.addVertexWithUV(MIN, 1.0F, MIN, MIN, MAX);
			tessellator.addVertexWithUV(MAX, 1.0F, MIN, MAX, MAX);
			tessellator.addVertexWithUV(MAX, 0.0F, MIN, MAX, MIN);
			
			// Back
			tessellator.addVertexWithUV(MIN, 0.0F, MAX, MIN, MIN);
			tessellator.addVertexWithUV(MIN, 1.0F, MAX, MIN, MAX);
			tessellator.addVertexWithUV(MAX, 1.0F, MAX, MAX, MAX);
			tessellator.addVertexWithUV(MAX, 0.0F, MAX, MAX, MIN);
			
			// Left
			tessellator.addVertexWithUV(MIN, 0.0F, MIN, MIN, MIN);
			tessellator.addVertexWithUV(MIN, 0.0F, MAX, MIN, MAX);
			tessellator.addVertexWithUV(MIN, 1.0F, MAX, MAX, MAX);
			tessellator.addVertexWithUV(MIN, 1.0F, MIN, MAX, MIN);
			
			// Left
			tessellator.addVertexWithUV(MAX, 0.0F, MIN, MIN, MIN);
			tessellator.addVertexWithUV(MAX, 0.0F, MAX, MIN, MAX);
			tessellator.addVertexWithUV(MAX, 1.0F, MAX, MAX, MAX);
			tessellator.addVertexWithUV(MAX, 1.0F, MIN, MAX, MIN);
			
			// Top
			tessellator.addVertexWithUV(MIN, 1.0F, MIN, MIN, MIN);
			tessellator.addVertexWithUV(MIN, 1.0F, MAX, MIN, MAX);
			tessellator.addVertexWithUV(MAX, 1.0F, MAX, MAX, MAX);
			tessellator.addVertexWithUV(MAX, 1.0F, MIN, MAX, MIN);
			
			// Bottom
			tessellator.addVertexWithUV(MIN, 0.0F, MIN, MIN, MIN);
			tessellator.addVertexWithUV(MIN, 0.0F, MAX, MIN, MAX);
			tessellator.addVertexWithUV(MAX, 0.0F, MAX, MAX, MAX);
			tessellator.addVertexWithUV(MAX, 0.0F, MIN, MAX, MIN);
			
			// Inside
			
			// Front
			tessellator.addVertexWithUV(MAX, 0.0F, MIN, MAX, MIN);
			tessellator.addVertexWithUV(MAX, 1.0F, MIN, MAX, MAX);
			tessellator.addVertexWithUV(MIN, 1.0F, MIN, MIN, MAX);
			tessellator.addVertexWithUV(MIN, 0.0F, MIN, MIN, MIN);
			
			// Back
			tessellator.addVertexWithUV(MAX, 0.0F, MAX, MAX, MIN);
			tessellator.addVertexWithUV(MAX, 1.0F, MAX, MAX, MAX);
			tessellator.addVertexWithUV(MIN, 1.0F, MAX, MIN, MAX);
			tessellator.addVertexWithUV(MIN, 0.0F, MAX, MIN, MIN);
			
			// Left
			tessellator.addVertexWithUV(MIN, 1.0F, MIN, MAX, MIN);
			tessellator.addVertexWithUV(MIN, 1.0F, MAX, MAX, MAX);
			tessellator.addVertexWithUV(MIN, 0.0F, MAX, MIN, MAX);
			tessellator.addVertexWithUV(MIN, 0.0F, MIN, MIN, MIN);
			
			// Left
			tessellator.addVertexWithUV(MAX, 1.0F, MIN, MAX, MIN);
			tessellator.addVertexWithUV(MAX, 1.0F, MAX, MAX, MAX);
			tessellator.addVertexWithUV(MAX, 0.0F, MAX, MIN, MAX);
			tessellator.addVertexWithUV(MAX, 0.0F, MIN, MIN, MIN);
			
			// Top
			tessellator.addVertexWithUV(MAX, 1.0F, MIN, MAX, MIN);
			tessellator.addVertexWithUV(MAX, 1.0F, MAX, MAX, MAX);
			tessellator.addVertexWithUV(MIN, 1.0F, MAX, MIN, MAX);
			tessellator.addVertexWithUV(MIN, 1.0F, MIN, MIN, MIN);
			
			// Bottom
			tessellator.addVertexWithUV(MAX, 0.0F, MIN, MAX, MIN);
			tessellator.addVertexWithUV(MAX, 0.0F, MAX, MAX, MAX);
			tessellator.addVertexWithUV(MIN, 0.0F, MAX, MIN, MAX);
			tessellator.addVertexWithUV(MIN, 0.0F, MIN, MIN, MIN);
		}
		tessellator.draw();
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