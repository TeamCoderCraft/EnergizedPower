package com.codecraft.energizedpower.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.codecraft.energizedpower.init.ModBlocks;

/**
 * Contains all the creative tabs for the mod
 * @author Matthieu Parizeau
 */
public class EnergizedPowerTabs {
	
	public static CreativeTabs mainTab = new CreativeTabs("main")
	{
		
		@Override
		public Item getTabIconItem()
		{
			return Item.getItemFromBlock(ModBlocks.pipe);
		}
		
	};
	
}
