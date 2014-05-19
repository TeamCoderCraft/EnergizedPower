package com.codecraft.energizedpower.api;

import net.minecraft.client.resources.I18n;

/**
 * Pipe Type
 * @author Matthieu Parizeau
 */
public enum PipeType {
	ITEM("item", 0),
	POWER("power", 1),
	FLUID("fluid", 2);
	
	private String name;
	private int id;
	
	private PipeType(String name, int id)
	{
		this.name = name;
		this.id = id;
	}
	
	public String getUnlocalizedName()
	{
		return "pipeType." + this.name;
	}
	
	public String getLocalizedName()
	{
		return I18n.format(getUnlocalizedName());
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public static PipeType getById(int id)
	{
		for (PipeType type : values())
		{
			if (type.getId() == id)
				return type;
		}
		return null;
	}
}