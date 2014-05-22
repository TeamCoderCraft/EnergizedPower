package com.codecraft.energizedpower.events;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.FillBucketEvent;

import com.codecraft.energizedpower.init.ModBlocks;
import com.codecraft.energizedpower.init.ModItems;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class BucketHandler {
	
	@SubscribeEvent
	public void onFillBucket(FillBucketEvent event)
	{
		Block block = event.world.getBlock(event.target.blockX, event.target.blockY, event.target.blockZ);
		if (block == ModBlocks.energizedWater)
		{
			event.result = new ItemStack(ModItems.energizedWaterBucket);
			event.world.setBlockToAir(event.target.blockX, event.target.blockY, event.target.blockZ);
			event.setResult(Result.ALLOW);
		}
	}
	
}
