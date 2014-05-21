package com.codecraft.energizedpower.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import com.codecraft.energizedpower.api.PipeType;

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
		list.add(I18n.format("type.transport.name"));
		
		if (GuiScreen.isShiftKeyDown())
		{
			list.add(EnumChatFormatting.RED.toString() + I18n.format("type.transport.name") + " " + type.getLocalizedName());
		} else {
			list.add(EnumChatFormatting.DARK_GRAY + I18n.format("phrase.moreInfo"));
		}
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
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
	{
		String typeName = PipeType.getById(stack.getItemDamage()).getLocalizedName();
		return typeName + " " + super.getItemStackDisplayName(stack);
	}
	
}
