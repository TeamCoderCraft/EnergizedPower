package com.codecraft.energizedpower.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.codecraft.energizedpower.api.IWrenchableBlock;
import com.codecraft.energizedpower.api.PipeType;
import com.codecraft.energizedpower.proxy.ClientProxy;
import com.codecraft.energizedpower.tiles.TilePipe;

/**
 * Pipe Block
 * @author Matthieu Parizeau
 */
public class BlockPipe extends StandardTileBlock implements IWrenchableBlock {

	public BlockPipe()
	{
		super(Material.ground);
		this.setHardness(10.0F);
		this.setResistance(0.0F);
		this.setStepSound(soundTypeGlass);
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@Override
	public int getRenderType()
	{
		return ClientProxy.pipeId;
	}
	
	@Override
	public int quantityDropped(int meta, int fortune, Random random)
	{
		return 0;
	}
	
	@Override
	public int damageDropped(int meta)
	{
		return meta;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TilePipe(PipeType.getById(metadata));
	}

	@Override
	public List<ItemStack> getWrenchDrops(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		List<ItemStack> list = new ArrayList<ItemStack>();
		
		list.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z)));
		
		return list;
	}

	@Override
	public boolean canWrench(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		return true;
	}

	@Override
	public boolean onWrench(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		return false;
	}
	
}
