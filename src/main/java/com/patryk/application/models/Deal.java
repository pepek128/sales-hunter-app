package com.patryk.application.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "deal")
public class Deal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int dealID;
	@NotNull
	private String link;
	@NotNull
	private String description;
	@NotNull
	private String name;
	@NotNull
	private String price;
	@Transient
	public int categoryID;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoryID")
	private Category category;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	

	public int getCategoryID() {
		return this.category.getCategory_id();
	}

	private int score = 0;

	public int getDeal_id() {
		return dealID;
	}

	public void setDeal_id(int deal_id) {
		this.dealID = deal_id;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Deal() {

	}

	public Deal(String link, String description, String name, String price, int score, Category category) {

		this.link = link;
		this.description = description;
		this.name = name;
		this.price = price;
		this.score = score;
		this.category=category;

	}

}
