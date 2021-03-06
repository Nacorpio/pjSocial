package com.nacorpio.pjsocial.serialization;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.google.common.base.Optional;
import com.nacorpio.pjsocial.util.SerializationUtil;

/**
 * This represents a serialization-section.<br>
 * Those are used for either saving lists of data or just variables.<br>
 * Section can be extended and be used as a way to save custom data.
 */
public abstract class Section {

	private String name;
	private String content;
	private boolean reloaded = false;
	private List<Object> properties = new ArrayList<Object>();
	
	public Section(Object par1) {
		this.name = "Object";
		this.initialize(par1);
	}
	
	public Section(String par1, String par2) {
		if (SerializationUtil.isValidSectionName(par1)) {
			this.name = par1;
			this.content = par2;
		}	
	}
	
	/**
	 * This is the only point where you can choose what's saved.
	 * @param par1 the instance to save.
	 */
	abstract void initialize(Object par1);
	
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
	
	/**
	 * Add a new property to the section.<br>
	 * There are no rules when it comes to adding the data.<br>
	 * It can either be used as an array, or just variables.<br>
	 * <i>Doesn't require a reload.
	 * @param par1 the property.
	 */
	public final void addProperty(Object par1) {
		if (!reloaded) {
			properties.add(par1);
			this.reload();
		}
	}
	
	/**
	 * Returns the property that starts with/contains the specified String.<br>
	 * @param par1 the property to look for.
	 * @return 
	 */
	public final Object getProperty(Object par1) {
		for (Object prop: properties) {
			if (prop.toString().startsWith(par1.toString()) || prop.toString().contains(par1.toString())) {
				return prop;
			}
		}
		return null;
	}
	
	public final Object[] getArray(Object par1) {
		Object var1 = getValue(getProperty(par1));
		return var1.toString().split(Pattern.quote("["))[1].split(Pattern.quote("]"))[0].split(Pattern.quote(","));
	}
	
	public final Object getValue(Object par1) {
		Object var1 = getProperty(par1);
		return var1.toString().split(": ")[1];
	}
	
	/**
	 * Returns the property at the specified index.
	 * @param par1 the index.
	 * @return the property.
	 */
	public final Object getProperty(int par1) {
		return properties.get(par1);
	}
	
	/**
	 * Clear all the properties of the section.<br>
	 * <i>Doesn't require a reload.
	 */
	public final void clearProperties() {
		if (!reloaded) {
			properties.clear();
			this.reload();
		}
	}
	
	/**
	 * Remove a property from the section.<br>
	 * <i>Doesn't require a reload.
	 * @param par1 the index.
	 */
	public final void removeProperty(int par1) {
		if (!reloaded) {
			properties.remove(par1);
			this.reload();
		}
	}
	
	/**
	 * Returns all the properties of the section.<br>
	 * When reloaded, the properties are parsed from the source.
	 * @return the properties.
	 */
	public final List<Object> getProperties() {
		return this.properties;
	}
	
	/**
	 * Returns the content within the curly-brackets.
	 * @return the content.
	 */
	public final String getContent() {
		return this.content;
	}
	
	/**
	 * Returns the entire source of the serialization.<br>
	 * This is built together manually in the {@link #getSource()}.
	 * @return the source.
	 */
	public final String getSource() {
		String var1 = "(" + name + "):{";
		// if (this.content == null || this.content == "") {
			if (!(properties.size() == 0 && properties == null)) {
				for (int i = 0; i < properties.size(); i++) {
					Object prop = properties.get(i);
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
	
	/**
	 * Reload the changes of the section.<br>
	 * This method is required to be executed at many points.<br>
	 * All the source-code will be updated in this method.
	 */
	public final void reload() {
		this.reloaded = true;
		//System.out.println(getSource());
		this.content = getSource().split(Pattern.quote("{"))[1].split(Pattern.quote("}"))[0].replace("],", "]&");
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
