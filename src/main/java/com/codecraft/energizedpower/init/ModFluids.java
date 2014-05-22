package com.codecraft.energizedpower.init;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFluids {
	
	public static Fluid energizedWater;
	
	/**
	 * Initialize Fluids
	 */
	public static void init()
	{
		energizedWater = new Fluid("energizedwater").setLuminosity(15).setUnlocalizedName("tile.energizedWater.name");
		
		FluidRegistry.registerFluid(energizedWater);
	}
	
}
