package com.codecraft.energizedpower.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;

import com.codecraft.energizedpower.api.client.gui.widget.Widget;
import com.codecraft.energizedpower.api.inventory.ContainerBase;

public class ContainerTestMachine extends ContainerBase {

	public ContainerTestMachine(InventoryPlayer par1InventoryPlayer)
	{
		this.addWidget(new Widget(this, 176, 10, "Test"));
		
		for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(par1InventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(par1InventoryPlayer, i, 8 + i * 18, 142));
        }
	}

	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return true;
	}
	
}
