package com.nacorpio.pjsocial.serialization;

public class CollectiveSection extends Section {

	public CollectiveSection(Object... par1) {
		this.setName("Collection");
		for (Object var: par1) {
			if (var != null)
				this.addProperty(var);
		}
	}
	
}
