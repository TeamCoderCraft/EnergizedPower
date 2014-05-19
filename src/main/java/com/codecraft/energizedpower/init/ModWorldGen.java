package com.codecraft.energizedpower.init;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import com.codecraft.energizedpower.core.Ore;
import com.codecraft.energizedpower.core.OreRegistry;
import com.codecraft.energizedpower.core.WorldGenHelper;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Contains all the mods world generation
 * @author Matthieu Parizeau
 */
public class ModWorldGen implements IWorldGenerator {

	/**
	 * Initialize WorldGen
	 */
	public static void init()
	{
		GameRegistry.registerWorldGenerator(new ModWorldGen(), 0);
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		// Generate the ores for the current dimension
		this.generateOres(world, random, chunkX, chunkZ);
		
		// Based on the dimension call a different generate method
		switch (world.provider.dimensionId)
		{
			case 0: // overworld
				this.generateSurface(world, random, chunkX, chunkZ);
				break;
			case 1: // end
				this.generateEnd(world, random, chunkX, chunkZ);
				break;
			case -1: //nether
				this.generateNether(world, random, chunkX, chunkZ);
				break;
		}
	}
	
	/**
	 * Generate Ores
	 * @param world the world to generate in
	 * @param random the world random number generator
	 * @param chunkX the chunk X position
	 * @param chunkZ the chunk Z position
	 */
	public void generateOres(World world, Random random, int chunkX, int chunkZ)
	{
		int x = chunkX * 16;
		int z = chunkZ * 16;
		
		// Get the ores for this dimension
		ArrayList<Ore> ores = OreRegistry.getDimensionOres(world.provider.dimensionId);
		if (ores != null)
		{
			// If it has any ores generate them
			for (Ore ore : ores)
			{
				WorldGenHelper.generateOre(world, random, x, z, ore);
			}
		}
	}

	/**
	 * Generates the overworld
	 * @param world the world to generate in
	 * @param random the world random number generator
	 * @param chunkX the chunk X position
	 * @param chunkZ the chunk Z position
	 */
	public void generateSurface(World world, Random random, int chunkX, int chunkZ)
	{
		
	}

	/**
	 * Generates the nether
	 * @param world the world to generate in
	 * @param random the world random number generator
	 * @param chunkX the chunk X position
	 * @param chunkZ the chunk Z position
	 */
	public void generateNether(World world, Random random, int chunkX, int chunkZ)
	{

	}

	/**
	 * Generates the end
	 * @param world the world to generate in
	 * @param random the world random number generator
	 * @param chunkX the chunk X position
	 * @param chunkZ the chunk Z position
	 */
	public void generateEnd(World world, Random random, int chunkX, int chunkZ)
	{

	}

}
