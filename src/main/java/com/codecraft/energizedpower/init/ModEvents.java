package com.codecraft.energizedpower.init;

import net.minecraftforge.common.MinecraftForge;

import com.codecraft.energizedpower.events.BucketHandler;
import com.codecraft.energizedpower.events.LivingHandler;

public class ModEvents {
	
	public static void init()
	{
		MinecraftForge.EVENT_BUS.register(new BucketHandler());
		MinecraftForge.EVENT_BUS.register(new LivingHandler());
	}
	
}
