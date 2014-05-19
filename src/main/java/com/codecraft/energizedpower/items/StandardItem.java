package com.codecraft.energizedpower.items;

import com.codecraft.energizedpower.reference.Reference;
import com.codecraft.energizedpower.tabs.EnergizedPowerTabs;

import net.minecraft.item.Item;

/**
 * Standard Item
 * 
 * @author Matthieu Parizeau
 */
public class StandardItem extends Item {
	
	/**
	 * Item Constructor
	 */
	public StandardItem()
	{
		this.setCreativeTab(EnergizedPowerTabs.mainTab);
	}
	
	/**
	 * Set the items texture
	 * @param texture the texture to set
	 * @return this item
	 */
	@Override
	public StandardItem setTextureName(String texture)
	{
		return (StandardItem) super.setTextureName(Reference.MOD_ID + ":" + texture);
	}
	
	/**
	 * Set the items name
	 * @param name the name to set
	 * @return this item
	 */
	@Override
	public StandardItem setUnlocalizedName(String name)
	{
		return (StandardItem) super.setUnlocalizedName(name);
	}
	
}
