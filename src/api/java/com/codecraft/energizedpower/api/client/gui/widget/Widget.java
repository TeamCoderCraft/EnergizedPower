package com.codecraft.energizedpower.api.client.gui.widget;

import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

import com.codecraft.energizedpower.api.client.gui.GuiBase;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Widget {
	
	private static final ResourceLocation texture = new ResourceLocation("ccenergizedpower", "textures/gui/widgets/widget.png");
	private static final ResourceLocation textureLong = new ResourceLocation("ccenergizedpower", "textures/gui/widgets/widget_long.png");
	private static final ResourceLocation textureMain = new ResourceLocation("ccenergizedpower", "textures/gui/widgets/widget_main.png");
	
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
		this.width = 30;
		this.height = 28;
		this.open = false;
	}
	
	public boolean isOpen()
	{
		return this.open;
	}
	
	@SideOnly(Side.CLIENT)
	public void onClick()
	{
		this.open = !this.open;
	}
	
	@SideOnly(Side.CLIENT)
	public boolean isHovering(int mX, int mY)
	{
		if (this.open)
			return mX >= x && mX <= x + 100 && mY >= y && mY <= y + 28;
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
		if (this.open)
		{
			
		} else
		{
			if (this.isHovering(mouseX, mouseY))
				gui.drawToolTip(this.getToolTipText(), mouseX, mouseY);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void renderIcon(GuiBase gui, int x, int y, int mouseX, int mouseY)
	{
		//GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		//gui.bindTexture(TextureMap.locationBlocksTexture);
		//gui.drawTexturedModelRectFromIcon(this.x + x + this.width / 2 - 8, this.y + y + this.height / 2 - 8, ModBlocks.pipe.getIcon(0, 0), 16, 16);
	}
	
	@SideOnly(Side.CLIENT)
	public void renderOpen(GuiBase gui, int x, int y, int mouseX, int mouseY)
	{
		gui.bindTexture(textureMain);
		gui.drawWidget(this.x + x, this.y + y, 100, 128, this.color);
		gui.bindTexture(textureLong);
		gui.drawWidget(this.x + x, this.y + y, 100, 28, this.color);
		gui.drawString(this.getToolTipText(), this.x + x + this.width / 2 - gui.getStrWidth(this.getToolTipText()) / 2 + 20, this.y + y + this.height / 2 - gui.getStrHeight() / 2, 0x404040);
	}
	
	public void open()
	{
		this.open = true;
	}
	
	public void close()
	{
		this.open = false;
	}
	
	public String getToolTipText()
	{
		return this.tooltip;
	}
	
}
