package com.codecraft.energizedpower.api;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Implement this to make it compatible with the wrench
 * @author Matthieu Parizeau
 */
public interface IWrenchableBlock {
	
	/**
	 * Get the drops when the wrench is used
	 * @param world the world
	 * @param x the x position
	 * @param y the y position
	 * @param z the z position
	 * @param player the player
	 * @param side the side hit
	 * @param hitX the x position of the side hit
	 * @param hitY the y position of the side hit
	 * @param hitZ the z position of the side hit
	 * @return the drops to drop when the block is broken with the wrench
	 */
	public List<ItemStack> getWrenchDrops(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ);
	
	/**
	 * Get whether or not the wrench can be used on this block
	 * @param world the world
	 * @param x the x position
	 * @param y the y position
	 * @param z the z position
	 * @param player the player
	 * @param side the side hit
	 * @param hitX the x position of the side hit
	 * @param hitY the y position of the side hit
	 * @param hitZ the z position of the side hit
	 * @return whether or not the wrench can be used on this block
	 */
	public boolean canWrench(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ);
	
	/**
	 * Called when the wrench is used on this block
	 * @param world the world
	 * @param x the x position
	 * @param y the y position
	 * @param z the z position
	 * @param player the player
	 * @param side the side hit
	 * @param hitX the x position of the side hit
	 * @param hitY the y position of the side hit
	 * @param hitZ the z position of the side hit
	 * @return whether or not this block has custom wrench functionality
	 */
	public boolean onWrench(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ);
	
}
