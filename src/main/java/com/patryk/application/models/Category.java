package com.patryk.application.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "category")

public class Category {
	@Id
	public int categoryID;
	@NotNull
	private String categoryname;
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private List<Deal> deals = new ArrayList<>();

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int category_id) {
		this.categoryID = category_id;
	}

	public String getCategory_name() {
		return categoryname;
	}

	public void setCategory_name(String category_name) {
		this.categoryname = category_name;
	}

}
