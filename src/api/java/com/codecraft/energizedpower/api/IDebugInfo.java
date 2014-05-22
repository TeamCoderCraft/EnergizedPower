package com.codecraft.energizedpower.api;

import java.util.List;

import net.minecraft.world.World;

public interface IDebugInfo {
	
	public void getInformation(World world, int x, int y, int z, List<String> lines);
	
}
