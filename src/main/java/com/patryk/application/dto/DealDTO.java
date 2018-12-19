package com.patryk.application.dto;

import javax.validation.constraints.NotNull;

import com.patryk.application.models.Category;

public class DealDTO {

	private int dealID;
	@NotNull
	private String link;
	@NotNull
	private String description;
	@NotNull
	private String name;
	@NotNull
	private String price;
	private String image;
	private int score; 

	private int categoryID;

	private Category category;

	public int getDealID() {
		return dealID;
	}

	public void setDealID(int dealID) {
		this.dealID = dealID;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
}
