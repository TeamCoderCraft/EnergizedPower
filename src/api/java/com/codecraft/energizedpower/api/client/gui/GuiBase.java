package com.codecraft.energizedpower.api.client.gui;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.codecraft.energizedpower.api.client.gui.widget.Widget;
import com.codecraft.energizedpower.api.inventory.ContainerBase;

public abstract class GuiBase extends GuiContainer {
	
	public GuiBase(ContainerBase container)
	{
		super(container);
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int button)
	{
		super.mouseClicked(mouseX, mouseY, button);
		
		int mX = mouseX - guiLeft;
		int mY = mouseY - guiTop;
		
		for (Widget widget : this.getContainer().getWidgets())
		{
			boolean cont = false;
			for (Widget w : this.getContainer().getWidgets())
			{
				if (w.isOpen() && !widget.isOpen())
					cont = true;
			}
			if (cont)
				continue;
			if (widget.isHovering(mX, mY))
			{
				for (Widget w : this.getContainer().getWidgets())
					if (w != widget && w.isOpen())
						w.close();
				widget.onClick();
			}
		}
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		int x = (this.width - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;
		
		int mX = mouseX - guiLeft;
		int mY = mouseY - guiTop;
		
		for (Widget widget : this.getContainer().getWidgets())
		{
			boolean cont = false;
			for (Widget w : this.getContainer().getWidgets())
			{
				if (w.isOpen() && !widget.isOpen())
					cont = true;
			}
			if (cont)
				continue;
			widget.renderForeground(this, x, y, mX, mY);
		}
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int mouseX, int mouseY)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		int x = (this.width - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;
		
		int mX = mouseX - guiLeft;
		int mY = mouseY - guiTop;
		
		for (Widget widget : this.getContainer().getWidgets())
		{
			boolean cont = false;
			for (Widget w : this.getContainer().getWidgets())
			{
				if (w.isOpen() && !widget.isOpen())
					cont = true;
			}
			if (cont)
				continue;
			widget.renderBackground(this, x, y, mX, mY);
		}
	}
	
	public void bindTexture(ResourceLocation texture)
	{
		this.mc.getTextureManager().bindTexture(texture);
	}
	
	public void drawWidget(int x, int y, int w, int h, int color)
    {
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_I(color, 255);
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + h), (double)this.zLevel, (double)0, (double)1);
        tessellator.addVertexWithUV((double)(x + w), (double)(y + h), (double)this.zLevel, (double)1, (double)1);
        tessellator.addVertexWithUV((double)(x + w), (double)(y + 0), (double)this.zLevel, (double)1, (double)0);
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + 0), (double)this.zLevel, (double)0, (double)0);
        tessellator.draw();
    }
	
	public void drawToolTip(String tooltip, int mouseX, int mouseY)
	{
		List<String> list = new ArrayList<String>();
		list.add(tooltip);
		this.drawHoveringText(list, mouseX, mouseY, this.fontRendererObj);
	}
	
	public void drawString(String s, int x, int y, int color)
	{
		this.fontRendererObj.drawString(s, x, y, color);
	}
	
	public int getStrWidth(String s)
	{
		return this.fontRendererObj.getStringWidth(s);
	}
	
	public int getStrHeight()
	{
		return this.fontRendererObj.FONT_HEIGHT;
	}
	
	public ContainerBase getContainer()
	{
		return (ContainerBase)this.inventorySlots;
	}
	
}
