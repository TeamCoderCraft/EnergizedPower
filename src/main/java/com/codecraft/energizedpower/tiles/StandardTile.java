package com.codecraft.energizedpower.tiles;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

/**
 * Standard Tile
 * @author Matthieu Parizeau
 */
public class StandardTile extends TileEntity {
	
	public StandardTile() { }
	
	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound compound = new NBTTagCompound();
		writeToNBT(compound);
		Packet packet = new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, blockMetadata, compound);
		return packet;
	}
	
	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
	{
		this.readFromNBT(pkt.func_148857_g());
	}
	
}
