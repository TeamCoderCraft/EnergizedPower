package com.codecraft.energizedpower.init;

import net.minecraft.item.Item;

import com.codecraft.energizedpower.items.ItemWrench;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Contains all the mods items
 * @author Matthieu Parizeau
 */
public class ModItems {
	
	public static Item wrench;
	
	/**
	 * Initialize Items
	 */
	public static void init()
	{
		wrench = new ItemWrench().setUnlocalizedName("wrench").setTextureName("wrench");
		
		GameRegistry.registerItem(wrench, "wrench");
	}
	
}
