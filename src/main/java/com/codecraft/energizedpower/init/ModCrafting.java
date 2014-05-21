package com.codecraft.energizedpower.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Contains all the mods crafting
 * @author Matthieu Parizeau
 */
public class ModCrafting {
	
	/**
	 * Initialize Crafting
	 */
	public static void init()
	{
		// Pipes
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.pipe, 8, 0), new Object[]{
			"X", "I", "X", 'X', Items.iron_ingot, 'I', Blocks.glass_pane
		});
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.pipe, 1, 1), new Object[]{
			"I", "X", 'I', Items.redstone, 'X', new ItemStack(ModBlocks.pipe, 1, 0)
		});
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.pipe, 1, 2), new Object[]{
			"I", "X", 'I', Items.clay_ball, 'X', new ItemStack(ModBlocks.pipe, 1, 0)
		});
		
		// Wrench
		GameRegistry.addRecipe(new ItemStack(ModItems.wrench), new Object[]{
			"X X", "XIX", " X ", 'X', Items.iron_ingot, 'I', Items.redstone
		});
	}
	
}
