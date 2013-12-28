package com.nacorpio.pjsocial.serialization;

import org.bukkit.inventory.ItemStack;

import com.nacorpio.pjsocial.util.SerializationUtil;

public class ItemStackSection extends Section {

	public ItemStackSection(Object par1) {
		super(par1);
		this.setName("Inventory");		
	}

	@Override
	void initialize(Object par1) {
		ItemStack[] var1 = (ItemStack[]) par1;
		for (ItemStack var: var1) {
			if (var != null)
				this.addProperty(SerializationUtil.toShortString(var));
		}
	}
	
}
