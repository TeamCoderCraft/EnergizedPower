package com.codecraft.energizedpower.proxy;

import com.codecraft.energizedpower.init.ModOverlays;
import com.codecraft.energizedpower.render.RenderPipe;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * The Client Proxy
 * @author Matthieu Parizeau
 */
@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
	
	public static int pipeId;
	
	@Override
	public void preInit()
	{
		super.preInit();
		
		pipeId = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(pipeId, new RenderPipe());
	}
	
	@Override
	public void init()
	{
		
	}
	
	@Override
	public void postInit()
	{
		
		ModOverlays.init();
	}
	
}
