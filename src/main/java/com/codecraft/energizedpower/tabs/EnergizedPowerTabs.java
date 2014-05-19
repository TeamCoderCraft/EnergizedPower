package com.codecraft.energizedpower.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class EnergizedPowerTabs {
	
	public static CreativeTabs mainTab = new CreativeTabs("main")
	{
		
		@Override
		public Item getTabIconItem()
		{
			return Items.apple; // TODO: Set Proper Item
		}
		
	};
	
}
