package com.shopme.common.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "countries")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length = 45)
	private String name;
	
	@Column(nullable = false, length = 5)
	private String code;
	
	@OneToMany(mappedBy = "country")
	private Set<State> states;

	public Country() {
		
	}
	
	public Country(String name) {
		this.name = name;
	}
	
	public Country(String name, String code) {
		this.name = name;
		this.code = code;
	}
	
	public Country(String name, String code, Set<State> states) {
		this.name = name;
		this.code = code;
		this.states = states;
	}
	
	public Country(Integer id, String name, String code) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
	}

	public Country(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", code=" + code + "]";
	}

}
