package com.patryk.application.dto;

public class CategoryDTO {
	
	public int categoryID;
	
	private String categoryname;
	

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
