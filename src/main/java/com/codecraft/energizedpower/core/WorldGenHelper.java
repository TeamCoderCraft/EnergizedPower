package com.codecraft.energizedpower.core;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

/**
 * A helper class for WorldGen related tasks
 * @author Matthieu Parizeau
 */
public class WorldGenHelper {
	
	/**
	 * Generate an ore vein at a specified location
	 * @param world the world to generate in
	 * @param random the world random number generator
	 * @param x the x position
	 * @param z the z position
	 * @param ore the ore to generate
	 */
	public static void generateOre(World world, Random random, int x, int z, Ore ore)
	{
		for (int i = 0; i < ore.tries; i++)
		{
			int x1 = random.nextInt(16) + x;
			int y1 = random.nextInt(ore.maxY - ore.minY) + ore.minY;
			int z1 = random.nextInt(16) + z;
			
			new WorldGenMinable(ore.oreBlock, ore.amount, ore.target).generate(world, random, x1, y1, z1);
		}
	}
	
}
