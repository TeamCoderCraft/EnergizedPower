package com.codecraft.energizedpower.init;

import net.minecraft.block.Block;

import com.codecraft.energizedpower.blocks.BlockPipe;
import com.codecraft.energizedpower.blocks.ItemBlockPipe;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Contains all the mods blocks
 * @author Matthieu Parizeau
 */
public class ModBlocks {
	
	public static Block pipe;
	
	/**
	 * Initialize Blocks
	 */
	public static void init()
	{
		pipe = new BlockPipe().setBlockName("pipe").setBlockTextureName("pipe");
		
		GameRegistry.registerBlock(pipe, ItemBlockPipe.class, "pipe");
	}
	
}
