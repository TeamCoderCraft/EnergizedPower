package com.codecraft.energizedpower.init;

import net.minecraft.block.Block;

import com.codecraft.energizedpower.blocks.BlockPipe;
import com.codecraft.energizedpower.blocks.EnergizedWater;
import com.codecraft.energizedpower.blocks.ItemBlockPipe;
import com.codecraft.energizedpower.tabs.EnergizedPowerTabs;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Contains all the mods blocks
 * @author Matthieu Parizeau
 */
public class ModBlocks {
	
	public static Block pipe;
	public static Block energizedWater;
	
	/**
	 * Initialize Blocks
	 */
	public static void init()
	{
		pipe = new BlockPipe().setBlockName("pipe").setBlockTextureName("pipe");
		energizedWater = new EnergizedWater().setBlockName("energizedWater").setBlockTextureName("energized_water");
		
		GameRegistry.registerBlock(pipe, ItemBlockPipe.class, "pipe");
		GameRegistry.registerBlock(energizedWater, "energized_water");
	}
	
}
