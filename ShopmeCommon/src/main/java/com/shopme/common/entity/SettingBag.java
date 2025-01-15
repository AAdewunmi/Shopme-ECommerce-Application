package com.shopme.common.entity;

import java.util.List;

public class SettingBag {
	
	private List<Setting> listSettings;

	public SettingBag(List<Setting> listSettings) {
		super();
		this.listSettings = listSettings;
	}
	
	public Setting get(String key) {
		int index = listSettings.indexOf(new Setting(key));
		if (index >= 0) {
			return listSettings.get(index);
		}
		return null;
	}

}
