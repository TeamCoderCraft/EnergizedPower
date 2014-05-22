package com.codecraft.energizedpower.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.codecraft.energizedpower.EnergizedPower;
import com.codecraft.energizedpower.gui.ContainerTestMachine;
import com.codecraft.energizedpower.gui.GuiTestMachine;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler {

	public static void init()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(EnergizedPower.instance, new GuiHandler());
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == 0)
		{
			return new ContainerTestMachine(player.inventory);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == 0)
		{
			return new GuiTestMachine(player.inventory);
		}
		return null;
	}
	
}
