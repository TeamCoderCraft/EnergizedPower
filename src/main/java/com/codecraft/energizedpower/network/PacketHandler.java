package com.codecraft.energizedpower.network;

import net.minecraft.entity.player.EntityPlayerMP;

import com.codecraft.energizedpower.reference.Reference;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

/**
 * Generic Packet Handler
 * @author Matthieu Parizeau
 */
public class PacketHandler {
	
	protected static SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.modid);
	
	/**
	 * Register a packet
	 * @param packet the packet to register
	 * @param side the side to register the packet for
	 * @param id the id of the packet
	 */
	@SuppressWarnings("unchecked")
	public static void register(Class<? extends IPacket> packet, Side side, int id)
	{
		INSTANCE.registerMessage((Class<? extends IMessageHandler<IMessage, IMessage>>)packet, (Class<IMessage>)packet, id, side);
	}
	
	/**
	 * Send a packet to all players
	 * @param packet the packet to send
	 */
	public static void sendToAll(IPacket packet)
	{
		INSTANCE.sendToAll(packet);
	}
	
	/**
	 * Send a packet to a player
	 * @param packet the packet to send
	 * @param player the player to send the packet to
	 */
	public static void sendTo(IPacket packet, EntityPlayerMP player)
	{
		INSTANCE.sendTo(packet, player);
	}
	
	/**
	 * Send a packet to all players around a specified point
	 * @param packet the packet to send
	 * @param point the specified point
	 */
	public static void sendToAllAround(IPacket packet, TargetPoint point)
	{
		INSTANCE.sendToAllAround(packet, point);
	}
	
	/**
	 * Send a packet to all players in a specified dimension
	 * @param packet the packet to send 
	 * @param dimensionId the dimension to send the packet to
	 */
	public static void sendToDimension(IPacket packet, int dimensionId)
	{
		INSTANCE.sendToDimension(packet, dimensionId);
	}
	
	/**
	 * Send a packet to the server
	 * @param packet the packet to send
	 */
	public static void sendToServer(IPacket packet)
	{
		INSTANCE.sendToServer(packet);
	}
	
}
