package com.codecraft.energizedpower.api.client.gui.widget;

import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

import com.codecraft.energizedpower.api.client.gui.GuiBase;
import com.codecraft.energizedpower.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Widget {
	
	private static final ResourceLocation texture = new ResourceLocation("ccenergizedpower", "textures/gui/widgets/widget.png");
	
	protected Container container;
	protected int color;
	protected int x, y, width, height;
	protected String tooltip;
	protected boolean open;
	
	public Widget(Container container, int x, int y, String tooltip)
	{
		this(container, x, y, tooltip, 0xFFFFFF);
	}
	
	public Widget(Container container, int x, int y, String tooltip, int color)
	{
		this.container = container;
		this.color = color;
		this.x = x;
		this.y = y;
		this.tooltip = tooltip;
		this.width = 26;
		this.height = 26;
		this.open = false;
	}
	
	@SideOnly(Side.CLIENT)
	public void onClick()
	{
		this.open = !this.open;
	}
	
	@SideOnly(Side.CLIENT)
	public boolean isHovering(int mX, int mY)
	{
		return mX >= x && mX <= x + width && mY >= y && mY <= y + height;
	}
	
	@SideOnly(Side.CLIENT)
	public void renderBackground(GuiBase gui, int x, int y, int mouseX, int mouseY)
	{
		if (this.open)
			renderOpen(gui, x, y, mouseX, mouseY);
		else {
			gui.bindTexture(texture);
			gui.drawWidget(this.x + x, this.y + y, width, height, this.color);
		}
		this.renderIcon(gui, x, y, mouseX, mouseY);
	}
	
	@SideOnly(Side.CLIENT)
	public void renderForeground(GuiBase gui, int x, int y, int mouseX, int mouseY)
	{
		if (this.isHovering(mouseX, mouseY))
			gui.drawToolTip(this.getToolTipText(), mouseX, mouseY);
	}
	
	@SideOnly(Side.CLIENT)
	public void renderIcon(GuiBase gui, int x, int y, int mouseX, int mouseY)
	{
		
	}
	
	@SideOnly(Side.CLIENT)
	public void renderOpen(GuiBase gui, int x, int y, int mouseX, int mouseY)
	{
		gui.bindTexture(texture);
		gui.drawWidget(this.x + x, this.y + y, 64, 64, this.color);
		gui.bindTexture(texture);
		gui.drawWidget(this.x + x, this.y + y, width, height, this.color);
	}
	
	public String getToolTipText()
	{
		return this.tooltip;
	}
	
}
