package com.nacorpio.pj.social.serialization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Section {

	private String name;
	private String content;
	private boolean reloaded = false;
	private List<String> properties = new ArrayList<String>();
	
	public Section() {
		this.name = "Object";
	}
	
	public Section(String par1, String par2) {
		this.name = par1;
		this.content = par2;
	}
	
	/**
	 * Returns the name of the section.
	 * @return the name.
	 */
	public final String getName() {
		return this.name;
	}
	
	/**
	 * Set a new name for the section.<br>
	 * <i>Requires a reload.
	 * @param par1 the new name.
	 */
	public final void setName(String par1) {
		this.name = par1;
	}
	
	public final void addProperty(String par1) {
		if (!reloaded) {
			properties.add("- " + par1);
			this.reload();
		}
	}
	
	public final String getProperty(int par1) {
		return properties.get(par1);
	}
	
	public final void clearProperties() {
		if (!reloaded) {
			properties.clear();
			this.reload();
		}
	}
	
	public final void removeProperty(int par1) {
		if (!reloaded) {
			properties.remove(par1);
			this.reload();
		}
	}
	
	public final List<String> getProperties() {
		return this.properties;
	}
	
	public final String getContent() {
		return this.content;
	}
	
	public final String getSource() {
		String var1 = "(" + name + "):{";
		// if (this.content == null || this.content == "") {
			if (!(properties.size() == 0 && properties == null)) {
				for (int i = 0; i < properties.size(); i++) {
					String prop = properties.get(i);
					if (i < properties.size() - 1) {
						var1 += prop + ",";
					} else {
						var1 += prop;
					}
				}
			}		
		//} else {
		//	var1 += content;
		//}
		var1 += "};";
		return var1;
	}
	
	public final void reload() {
		this.reloaded = true;
		//System.out.println(getSource());
		this.content = getSource().split(Pattern.quote("{"))[1].split(Pattern.quote("}"))[0];
		clearProperties();
		if (getProperties().size() > 0) {
			for (String str: content.split(Pattern.quote(","))) {
				this.addProperty(str);
			}
		} else {
			this.addProperty(this.content);
		}
		this.reloaded = false;
	}
	
}
