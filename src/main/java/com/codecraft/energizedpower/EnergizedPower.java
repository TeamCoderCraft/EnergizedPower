package com.codecraft.energizedpower;

import com.codecraft.energizedpower.handlers.GuiHandler;
import com.codecraft.energizedpower.init.ModBlocks;
import com.codecraft.energizedpower.init.ModCrafting;
import com.codecraft.energizedpower.init.ModEntities;
import com.codecraft.energizedpower.init.ModEvents;
import com.codecraft.energizedpower.init.ModFluidContainers;
import com.codecraft.energizedpower.init.ModFluids;
import com.codecraft.energizedpower.init.ModItems;
import com.codecraft.energizedpower.init.ModOres;
import com.codecraft.energizedpower.init.ModPackets;
import com.codecraft.energizedpower.init.ModTiles;
import com.codecraft.energizedpower.init.ModWorldGen;
import com.codecraft.energizedpower.proxy.CommonProxy;
import com.codecraft.energizedpower.reference.Reference;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * The main mod class
 * @author Matthieu Parizeau
 */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class EnergizedPower {
	
	/**
	 * The instance of the mod
	 */
	@Instance(Reference.MOD_ID)
	public static EnergizedPower instance;
	
	/**
	 * The proxy of the mod
	 */
	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.COMMON_PROXY)
	public static CommonProxy proxy;
	
	/**
	 * PreInitialize the mod
	 * @param event FMLPreInit event
	 */
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ModFluids.init();
		ModBlocks.init();
		ModItems.init();
		ModCrafting.init();
		ModEntities.init();
		ModTiles.init();
		ModPackets.init();
		ModWorldGen.init();
		ModOres.init();
		ModEvents.init();
		GuiHandler.init();
		proxy.preInit();
	}
	
	/**
	 * Initialize the mod
	 * @param event FMLInit event
	 */
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.init();
		ModFluidContainers.init();	
	}
	
	/**
	 * PostInitialize the mod
	 * @param event FMLPostInit event
	 */
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		proxy.postInit();
	}
	
}
