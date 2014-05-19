package com.codecraft.energizedpower.core;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Ore Registry
 * @author Matthieu Parizeau
 */
public class OreRegistry {
	private static final HashMap<Integer, ArrayList<Ore>> ores = new HashMap<Integer, ArrayList<Ore>>();
	
	/**
	 * Register an ore to the world generator
	 * @param ore the ore to register
	 */
	public static void registerOre(Ore ore)
	{
		if (!OreRegistry.hasDimension(ore.dimension))
			OreRegistry.ores.put(ore.dimension, new ArrayList<Ore>());
		if (!OreRegistry.containsOre(ore))
			ores.get(ore.dimension).add(ore);
	}
	
	/**
	 * Unregister an ore from the world generator
	 * @param ore the ore to unregister
	 */
	public static void unregisterOre(Ore ore)
	{
		if (OreRegistry.containsOre(ore))
			ores.remove(ore);
	}
	
	/**
	 * Get an ore from the world generator
	 * @param dimension the dimension to look in
	 * @param index the index of the ore in the specified dimension
	 * @return the ore from the world generator
	 */
	public static Ore getOre(int dimension, int index)
	{
		if (!hasDimension(dimension))
			return null;
		return ores.get(dimension).get(index);
	}
	
	/**
	 * Checks if the specified ore is already registered
	 * @param ore the ore to check
	 * @return whether or not the ore is registered
	 */
	public static boolean containsOre(Ore ore)
	{
		if (!hasDimension(ore.dimension))
			return false;
		return ores.get(ore.dimension).contains(ore);
	}
	
	/**
	 * Checks if the specified dimension contains any ores
	 * @param dimension the dimension to check
	 * @return whether or not the specified dimension contains any ores
	 */
	public static boolean hasDimension(int dimension)
	{
		return ores.containsKey(dimension);
	}
	
	/**
	 * Gets the amount of dimensions with ores
	 * @return the amount of dimensions with ores
	 */
	public static int numDimension()
	{
		return ores.size();
	}
	
	/**
	 * Gets the amount of ores that are registered in the specified dimension
	 * @param dimension the dimension to check
	 * @return the amount of ores that are registered in the specified dimension
	 */
	public static int numOres(int dimension)
	{
		if (!hasDimension(dimension))
			return 0;
		return ores.get(dimension).size();
	}
	
	/**
	 * Gets the ore list for the specified dimension
	 * @param dimension the dimension to check
	 * @return the ore list for the specified dimension
	 */
	public static ArrayList<Ore> getDimensionOres(int dimension)
	{
		if (!hasDimension(dimension))
			return null;
		return OreRegistry.ores.get(dimension);
	}
}
