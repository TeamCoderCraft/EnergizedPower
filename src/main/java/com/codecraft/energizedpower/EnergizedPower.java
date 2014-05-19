package com.codecraft.energizedpower;

import com.codecraft.energizedpower.init.ModBlocks;
import com.codecraft.energizedpower.init.ModCrafting;
import com.codecraft.energizedpower.init.ModEntities;
import com.codecraft.energizedpower.init.ModItems;
import com.codecraft.energizedpower.init.ModTiles;
import com.codecraft.energizedpower.proxy.CommonProxy;
import com.codecraft.energizedpower.reference.Reference;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.SidedProxy;

@Mod(modid = Reference.modid, name = Reference.name, version = Reference.version)
public class EnergizedPower {
	
	@Instance(Reference.modid)
	public static EnergizedPower instance;
	
	@SidedProxy(clientSide = Reference.clientproxy, serverSide = Reference.commonproxy)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ModBlocks.init();
		ModItems.init();
		ModCrafting.init();
		ModEntities.init();
		ModTiles.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
	
}
