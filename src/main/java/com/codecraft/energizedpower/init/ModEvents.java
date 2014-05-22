package com.codecraft.energizedpower.init;

import net.minecraftforge.common.MinecraftForge;

import com.codecraft.energizedpower.events.BucketHandler;

public class ModEvents {
	
	public static void init()
	{
		MinecraftForge.EVENT_BUS.register(new BucketHandler());
	}
	
}
