package com.codecraft.energizedpower.core;

/**
 * Various String Utilities
 * @author Matthieu Parizeau
 */
public class StringUtil {
	
	/**
	 * Get a camel case version of a string
	 * @param string the string to change to camel case
	 * @return the specified string in camel case
	 */
	public static String toCamelCase(String string)
	{
		return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
	}
}
