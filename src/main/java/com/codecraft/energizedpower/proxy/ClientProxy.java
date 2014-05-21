package com.codecraft.energizedpower.proxy;

import com.codecraft.energizedpower.render.RenderPipe;

import cpw.mods.fml.client.registry.RenderingRegistry;

/**
 * The Client Proxy
 * @author Matthieu Parizeau
 */
public class ClientProxy extends CommonProxy {
	
	public static int pipeId;
	
	@Override
	public void init()
	{
		super.init();
		
		pipeId = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(pipeId, new RenderPipe());
	}
	
}
