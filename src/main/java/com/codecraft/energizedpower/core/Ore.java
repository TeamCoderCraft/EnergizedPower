package com.codecraft.energizedpower.core;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

/**
 * A Wrapper Class for ores
 * @author Matthieu Parizeau
 */
public class Ore {
	
	/**
	 * The ore block
	 */
	public final Block oreBlock;
	/**
	 * The metadata of the ore block
	 */
	public final int oreMeta;
	/**
	 * The target block to replace; example: stone
	 */
	public final Block target;
	
	/**
	 * Maximum amount of ores per vein
	 */
	public final int amount;
	/**
	 * Amount of times to try generating per chunk
	 */
	public final int tries;
	/**
	 * Minimum Y Position
	 */
	public final int minY;
	/**
	 * Maximum Y Position
	 */
	public final int maxY;
	/**
	 * The dimension to generate the ore in
	 */
	public final int dimension;
	
	/**
	 * Ore Constructor
	 * @param oreBlock the ore block
	 * @param amount the maximum amount of ores per vein
	 * @param tries the amount of times to try generating per chunk
	 * @param maxY the maximum y position
	 */
	public Ore(Block oreBlock, int amount, int tries, int maxY)
	{
		this(oreBlock, amount, tries, 0, maxY, 0);
	}
	
	/**
	 * Ore Constructor
	 * @param oreBlock the ore block
	 * @param amount the maximum amount of ores per vein
	 * @param tries the amount of times to try generating per chunk
	 * @param maxY the maximum y position
	 * @param dimension the dimension to generate the ore in
	 */
	public Ore(Block oreBlock, int amount, int tries, int maxY, int dimension)
	{
		this(oreBlock, amount, tries, 0, maxY, dimension);
	}
	
	/**
	 * Ore Constructor
	 * @param oreBlock the ore block
	 * @param amount the maximum amount of ores per vein
	 * @param tries the amount of times to try generating per chunk
	 * @param minY the minimum y position
	 * @param maxY the maximum y position
	 * @param dimension the dimension to generate the ore in
	 */
	public Ore(Block oreBlock, int amount, int tries, int minY, int maxY, int dimension)
	{
		this(oreBlock, 0, amount, tries, minY, maxY, dimension);
	}
	
	/**
	 * Ore Constructor
	 * @param oreBlock the ore block
	 * @param oreMeta the ore block metadata
	 * @param amount the maximum amount of ores per vein
	 * @param tries the amount of times to try generating per chunk
	 * @param minY the minimum y position
	 * @param maxY the maximum y position
	 * @param dimension the dimension to generate the ore in
	 */
	public Ore(Block oreBlock, int oreMeta, int amount, int tries, int minY, int maxY, int dimension)
	{
		this(oreBlock, oreMeta, dimension == 1 ? Blocks.end_stone : (dimension == -1 ? Blocks.netherrack : Blocks.stone), 0, amount, tries, minY, maxY, dimension);
	}
	
	/**
	 * Ore Constructor
	 * @param oreBlock the ore block
	 * @param oreMeta the ore block metadata
	 * @param target the target block to replace
	 * @param amount the maximum amount of ores per vein
	 * @param tries the amount of times to try generating per chunk
	 * @param minY the minimum y position
	 * @param maxY the maximum y position
	 * @param dimension the dimension to generate the ore in
	 */
	public Ore(Block oreBlock, int oreMeta, Block target, int replaceMeta, int amount, int tries, int minY, int maxY, int dimension)
	{
		this.oreBlock = oreBlock;
		this.oreMeta = oreMeta;
		this.target = target;
		this.amount = amount;
		this.tries = tries;
		this.minY = minY;
		this.maxY = maxY;
		this.dimension = dimension;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof Ore))
			return false;
		
		Ore ore = (Ore) o;
		
		return this.oreBlock == ore.oreBlock && this.oreMeta == ore.oreMeta && this.target == ore.target && this.amount == ore.amount && this.tries == ore.tries && this.minY == ore.minY
				&& this.maxY == ore.maxY && this.dimension == ore.dimension;
	}
}
