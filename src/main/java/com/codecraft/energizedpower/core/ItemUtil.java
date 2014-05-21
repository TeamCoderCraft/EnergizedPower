package com.codecraft.energizedpower.core;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemUtil {
	
	public static void dropItem(World world, double x, double y, double z, ItemStack stack)
	{
		if (!world.isRemote)
		{
			EntityItem item = new EntityItem(world, x, y, z, stack);
			item.delayBeforeCanPickup = 10;
			world.spawnEntityInWorld(item);
		}
	}
	
}
