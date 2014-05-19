package com.codecraft.energizedpower.blocks;

import com.codecraft.energizedpower.reference.Reference;
import com.codecraft.energizedpower.tabs.EnergizedPowerTabs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Standard Block
 * @author Matthieu Parizeau
 */
public class StandardBlock extends Block {
	
	/**
	 * Block Constructor
	 * @param material the block material
	 */
	public StandardBlock(Material material)
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
	public StandardBlock setBlockTextureName(String texture)
	{
		return (StandardBlock)super.setBlockTextureName(Reference.MOD_ID + ":" + texture);
	}
	
	/**
	 * Set the blocks hardness
	 * @param hardness the hardness to set
	 * @return this block
	 */
	@Override
	public StandardBlock setHardness(float hardness)
	{
		return (StandardBlock)super.setHardness(hardness);
	}
	
	/**
	 * Set the blocks resistance
	 * @param resistance the resistance to set
	 * @return this block
	 */
	@Override
	public StandardBlock setResistance(float resistance)
	{
		return (StandardBlock)super.setResistance(resistance);
	}
	
	/**
	 * Set the blocks name
	 * @param name the name to set
	 * @return this block
	 */
	@Override
	public StandardBlock setBlockName(String name)
	{
		return (StandardBlock)super.setBlockName(name);
	}
	
}
