package com.codecraft.energizedpower.core;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Contains Item Utilities
 * @author Matthieu Parizeau
 */
public class ItemUtil {
	
	/**
	 * Drops an itemstack at the specified position
	 * @param world the world
	 * @param x the x position
	 * @param y the y position
	 * @param z the z position
	 * @param stack the itemstack to drop
	 */
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
