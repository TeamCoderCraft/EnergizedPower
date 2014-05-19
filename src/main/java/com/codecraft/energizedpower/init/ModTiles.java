package com.codecraft.energizedpower.init;

import com.codecraft.energizedpower.reference.Reference;
import com.codecraft.energizedpower.tiles.TilePipe;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Contains all the mods tiles
 * @author Matthieu Parizeau
 */
public class ModTiles {
	
	/**
	 * Initialize Tiles
	 */
	public static void init()
	{
		GameRegistry.registerTileEntity(TilePipe.class, Reference.MOD_ID + ":" + "pipe");
	}
	
}
