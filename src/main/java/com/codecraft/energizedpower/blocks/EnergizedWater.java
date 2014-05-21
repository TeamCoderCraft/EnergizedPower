package com.codecraft.energizedpower.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.BlockFluidClassic;

import com.codecraft.energizedpower.init.ModFluids;
import com.codecraft.energizedpower.reference.Reference;

public class EnergizedWater extends BlockFluidClassic {

	protected IIcon flowIcon;
	
	public EnergizedWater()
	{
		super(ModFluids.energizedWater, Material.water);
	}
	
	@Override
	public IIcon getIcon(int side, int meta)
	{
		return side != 0 && side != 1 ? this.flowIcon : this.blockIcon;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		this.blockIcon = register.registerIcon(textureName + "_still");
		this.flowIcon = register.registerIcon(textureName + "_flow");
	}
	
	/**
	 * Set the blocks texture
	 * @param texture the texture to set
	 * @return this block
	 */
	@Override
	public EnergizedWater setBlockTextureName(String texture)
	{
		return (EnergizedWater)super.setBlockTextureName(Reference.MOD_ID + ":" + texture);
	}
	
}
