package com.codecraft.energizedpower.overlays;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import com.codecraft.energizedpower.api.IDebugInfo;
import com.codecraft.energizedpower.api.client.gui.OverlayBase;
import com.codecraft.energizedpower.core.Location;
import com.codecraft.energizedpower.core.PlayerHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class OverlayDebug extends OverlayBase {
	
	public OverlayDebug()
	{
		
	}
	
	@Override
	public void render(int x, int y, ScaledResolution resolution, ElementType type)
	{
		Location location = PlayerHelper.getLookingAt();
		String tile = "";
		String blockName = "";
		if (!(location.getBlock() instanceof IDebugInfo))
		{
			if (location.getTile() != null)
				tile = "\\" + "tile";
			blockName = Block.blockRegistry.getNameForObject(location.getBlock()) + ":" + location.getMetadata() + tile;
			this.font.drawStringWithShadow("Looking At: " + blockName, x, y, 0xFFFFFF);
		} else {
			IDebugInfo info = (IDebugInfo)location.getBlock();
			List<String> lines = new ArrayList<String>();
			info.getInformation(Minecraft.getMinecraft().theWorld, location.getX(), location.getY(), location.getZ(), lines);
			int lastX = 0;
			for (String line : lines)
			{
				this.font.drawStringWithShadow(line, lastX, y, 0xFFFFFF);
				lastX += font.FONT_HEIGHT;
			}
		}
	}
	
}
