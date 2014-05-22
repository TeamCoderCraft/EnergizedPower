package com.codecraft.energizedpower.init;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;

import com.codecraft.energizedpower.items.ItemDebug;
import com.codecraft.energizedpower.items.ItemWrench;
import com.codecraft.energizedpower.reference.Reference;
import com.codecraft.energizedpower.tabs.EnergizedPowerTabs;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Contains all the mods items
 * @author Matthieu Parizeau
 */
public class ModItems {
	
	public static Item wrench;
	public static Item energizedWaterBucket;
	public static Item debug;
	
	/**
	 * Initialize Items
	 */
	public static void init()
	{
		wrench = new ItemWrench().setUnlocalizedName("wrench").setTextureName("wrench");
		energizedWaterBucket = new ItemBucket(ModBlocks.energizedWater).setUnlocalizedName("energizedWaterBucket").setTextureName(Reference.MOD_ID + ":" + "bucket_energized_water").setCreativeTab(EnergizedPowerTabs.mainTab).setContainerItem(Items.bucket);
		
		GameRegistry.registerItem(wrench, "wrench");
		GameRegistry.registerItem(energizedWaterBucket, "bucket_energized_water");
		
		debug = new ItemDebug().setUnlocalizedName("debug").setTextureName("debug");
		GameRegistry.registerItem(debug, "debug");
	}
	
}
