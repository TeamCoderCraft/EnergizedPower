package com.codecraft.energizedpower.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;

import com.codecraft.energizedpower.reference.Reference;
import com.codecraft.energizedpower.tabs.EnergizedPowerTabs;

/**
 * Standard TileEntity Block
 * @author Matthieu Parizeau
 */
public abstract class StandardTileBlock extends BlockContainer {
	
	/**
	 * Block Constructor
	 * @param material the block material
	 */
	public StandardTileBlock(Material material)
	{
		super(material);
		this.setCreativeTab(EnergizedPowerTabs.mainTab);
	}
	
	/**
	 * Set the blocks texture
	 * @param texture the texture to set
	 * @return this block
	 */
	@Override
	public StandardTileBlock setBlockTextureName(String texture)
	{
		return (StandardTileBlock)super.setBlockTextureName(Reference.MOD_ID + ":" + texture);
	}
	
	/**
	 * Set the blocks hardness
	 * @param hardness the hardness to set
	 * @return this block
	 */
	@Override
	public StandardTileBlock setHardness(float hardness)
	{
		return (StandardTileBlock)super.setHardness(hardness);
	}
	
	/**
	 * Set the blocks resistance
	 * @param resistance the resistance to set
	 * @return this block
	 */
	@Override
	public StandardTileBlock setResistance(float resistance)
	{
		return (StandardTileBlock)super.setResistance(resistance);
	}
	
	/**
	 * Set the blocks name
	 * @param name the name to set
	 * @return this block
	 */
	@Override
	public StandardTileBlock setBlockName(String name)
	{
		return (StandardTileBlock)super.setBlockName(name);
	}
	
}
