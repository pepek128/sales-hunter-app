package com.patryk.application.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "category")

public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int categoryID;
	@NotNull
	private String category_name;
	@OneToMany(mappedBy="category",
			fetch=FetchType.LAZY)
	private List<Deal> deals = new ArrayList<>();

	public int getCategory_id() {
		return categoryID;
	}

	public void setCategory_id(int category_id) {
		this.categoryID = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
}
