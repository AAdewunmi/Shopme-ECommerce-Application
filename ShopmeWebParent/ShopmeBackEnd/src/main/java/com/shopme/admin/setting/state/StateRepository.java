package com.shopme.admin.setting.state;

import org.springframework.data.repository.CrudRepository;

import com.shopme.common.entity.Country;
import com.shopme.common.entity.State;

public interface StateRepository extends CrudRepository<State, Integer> {

}
