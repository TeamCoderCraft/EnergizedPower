package com.codecraft.energizedpower.network;

import net.minecraft.network.Packet;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;

/**
 * Generic Packet
 * @author Matthieu Parizeau
 */
public abstract class IPacket implements IMessage, IMessageHandler<IPacket, IMessage> {
	
	/**
	 * Convert the packet to a Minecraft packet
	 * @return the Minecraft packet
	 */
	public Packet toPacket()
    {
        return PacketHandler.INSTANCE.getPacketFrom(this);
    }
	
}
