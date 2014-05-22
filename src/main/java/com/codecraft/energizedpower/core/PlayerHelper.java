package com.codecraft.energizedpower.core;

import net.minecraft.client.Minecraft;
import net.minecraft.util.MovingObjectPosition;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Client Side Player Helper Class
 * @author Matthieu Parizeau
 */
@SideOnly(Side.CLIENT)
public class PlayerHelper {
	
	/**
	 * Gets what the player is looking at
	 * @return the location of what the player is looking at
	 */
	@SideOnly(Side.CLIENT)
	public static Location getLookingAt()
	{
		Location location = null;
		MovingObjectPosition pos = Minecraft.getMinecraft().objectMouseOver;
		location = new Location(Minecraft.getMinecraft().theWorld, pos.blockX, pos.blockY, pos.blockZ);
		return location;
	}
	
}
