package com.nacorpio.pjsocial.serialization;

public class CollectiveSection extends Section {

	public CollectiveSection(Object par1) {
		super(par1);
		this.setName("Collection");	
	}

	@Override
	void initialize(Object par1) {
		Object[] var1 = (Object[]) par1;
		for (Object var: var1) {
			if (var != null)
				this.addProperty(var);
		}
	}
	
}
