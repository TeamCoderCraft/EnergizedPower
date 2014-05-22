package com.codecraft.energizedpower.init;

import com.codecraft.energizedpower.overlays.OverlayDebug;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModOverlays {
	
	public static OverlayDebug debug;
	
	/**
	 * Initialize Overlays
	 */
	public static void init()
	{
		debug = new OverlayDebug();
	}
	
}
