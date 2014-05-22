package com.codecraft.energizedpower.api.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public abstract class OverlayBase extends Gui {
	
	protected FontRenderer font;
	protected int mouseX, mouseY;
	
	public OverlayBase()
	{
		this.font = Minecraft.getMinecraft().fontRenderer;
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public final void renderOverlay(RenderGameOverlayEvent event)
	{
		this.mouseX = event.mouseX;
		this.mouseY = event.mouseY;
		if (!Minecraft.getMinecraft().gameSettings.showDebugInfo)
			render(0, 0, event.resolution, event.type);
	}
	
	public abstract void render(int x, int y, ScaledResolution resolution, ElementType type);
	
}
