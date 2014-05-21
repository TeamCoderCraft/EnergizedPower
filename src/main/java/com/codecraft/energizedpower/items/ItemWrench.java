package com.codecraft.energizedpower.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.codecraft.energizedpower.api.IWrenchableBlock;
import com.codecraft.energizedpower.core.ItemUtil;

public class ItemWrench extends StandardItem {
	
	public ItemWrench()
	{
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean flag)
	{
		list.add(I18n.format("type.utility.name"));
		
		if (GuiScreen.isShiftKeyDown())
		{
			list.add(EnumChatFormatting.RED.toString() + I18n.format("item.wrench.desc"));
		} else {
			list.add(EnumChatFormatting.DARK_GRAY + I18n.format("phrase.moreInfo"));
		}
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if (!player.isSneaking())
			return false;
		Block block = world.getBlock(x, y, z);
		if (block instanceof IWrenchableBlock)
		{
			IWrenchableBlock wrenchable = (IWrenchableBlock)block;
			
			if (!wrenchable.canWrench(world, x, y, z, player, side, hitX, hitY, hitZ))
			{
				return false;
			}
			
			if (!wrenchable.onWrench(world, x, y, z, player, side, hitX, hitY, hitZ))
			{
				List<ItemStack> drops = wrenchable.getWrenchDrops(world, x, y, z, player, side, hitX, hitY, hitZ);
				for (ItemStack itemstack : drops)
				{
					ItemUtil.dropItem(world, x, y, z, itemstack);
				}
				world.setBlockToAir(x, y, z);
			}
			
			return true;
		} else {
			return false;
		}
	}
	
}
