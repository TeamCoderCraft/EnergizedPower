package com.codecraft.energizedpower.api;

public enum PipeType {
	ITEM(0),
	POWER(1),
	FLUID(2);
	
	private int id;
	
	private PipeType(int id)
	{
		this.id = id;
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