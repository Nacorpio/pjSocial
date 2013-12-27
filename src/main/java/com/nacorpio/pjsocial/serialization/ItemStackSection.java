package com.nacorpio.pjsocial.serialization;

import org.bukkit.inventory.ItemStack;

import com.nacorpio.pjsocial.util.SerializationUtil;

public class ItemStackSection extends Section {

	public ItemStackSection(ItemStack[] par1) {
		this.setName("Inventory");
		for (ItemStack var: par1) {
			if (var != null)
				this.addProperty(SerializationUtil.toShortString(var));
		}
	}
	
}
