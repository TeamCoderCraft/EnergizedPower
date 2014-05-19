package com.codecraft.energizedpower.blocks;

import java.util.List;

import com.codecraft.energizedpower.api.PipeType;
import com.codecraft.energizedpower.core.StringUtil;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

/**
 * Item for Pipe Block
 * @author Matthieu Parizeau
 */
public class ItemBlockPipe extends ItemBlock {
	
	public ItemBlockPipe(Block block)
	{
		super(block);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean flag)
	{
		int meta = this.getMetadata(itemstack.getItemDamage());
		// get the pipe type from metadata
		PipeType type = PipeType.getById(meta);
		String name = StringUtil.toCamelCase(type.name());
		list.add(EnumChatFormatting.AQUA.toString() + name);
	}
	
	@Override
	public int getMetadata(int i)
	{
		return i;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubItems(Item item, CreativeTabs tabs, List list)
	{
		list.add(new ItemStack(item, 1, 0)); // Item
		list.add(new ItemStack(item, 1, 1)); // Power
		list.add(new ItemStack(item, 1, 2)); // Fluid
	}
	
}
