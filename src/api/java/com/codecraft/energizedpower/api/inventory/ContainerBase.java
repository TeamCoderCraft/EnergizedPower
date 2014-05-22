package com.codecraft.energizedpower.api.inventory;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.inventory.Container;

import com.codecraft.energizedpower.api.client.gui.widget.Widget;

public abstract class ContainerBase extends Container {
	
	protected List<Widget> widgets;
	
	public ContainerBase()
	{
		widgets = new ArrayList<Widget>();
	}
	
	public void addWidget(Widget widget)
	{
		widgets.add(widget);
	}
	
	public List<Widget> getWidgets()
	{
		return this.widgets;
	}
	
}
