package com.codecraft.energizedpower.items;

import com.codecraft.energizedpower.EnergizedPower;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDebug extends StandardItem {
	
	public ItemDebug()
	{
		
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		player.openGui(EnergizedPower.instance, 0, world, x, y, z);
		return true;
	}
	
}
