package com.patryk.application.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;

import com.patryk.application.models.Category;
import com.patryk.application.models.User;

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
	private String username;

	private Category category;
	private User user;
	private String voted;
	private Set<User> votedusers = new HashSet<>();
	private String voteType;

	public String getvoteType() {
		return voteType;
	}

	public void setvoteType(String voteType) {
		this.voteType = voteType;
	}

	public String getVoted() {
		return voted;
	}

	public void setVoted(String voted) {
		this.voted = voted;
	}

	public Set<User> getVotedusers() {
		return votedusers;
	}

	public void setVotedusers(Set<User> votedusers) {
		this.votedusers = votedusers;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public DealDTO() {

	}

}
