package com.shopme.setting;

import java.util.List;

import com.shopme.common.entity.Country;

public interface CountryRepository {
	
	public List<Country> findAllByOrderByNameAsc();

}
