package com.codecraft.energizedpower.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFluidContainers {
	
	public static void init()
	{
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack("energizedwater", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(ModItems.energizedWaterBucket), FluidContainerRegistry.EMPTY_BUCKET));
	}
	
}
