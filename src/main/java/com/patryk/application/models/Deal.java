package com.patryk.application.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "deal")
public class Deal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int dealID;
	@NotNull
	@Length(max = 1000)
	private String link;
	@NotNull
	@Length(max = 1000)
	private String description;
	@Length(max = 100)
	@NotNull
	private String name;
	@Length(max = 15)
	private String price;
	@Length(max = 255)
	private String image;
	private int score = 0;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoryID")
	public Category category;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userID")
	public User user;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "deals_users", joinColumns = @JoinColumn(name = "deal_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> votedusers = new ArrayList<>();
	@Transient
	private int categoryID;
	@Transient
	private String username;
	@Transient
	private String voted;

	public String getVoted() {
		return voted;
	}

	public void setVoted(String voted) {
		this.voted = voted;
	}

	public List<User> getVotedusers() {
		return votedusers;
	}

	public void setVotedusers(List<User> votedusers) {
		this.votedusers = votedusers;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Transient
	public int getCategoryID() {
		return categoryID;
	}

	@Transient
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public int getDealID() {
		return dealID;
	}

	public void setDealID(int deal_id) {
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Deal() {

	}

	public Deal(int dealID, @NotNull @Length(max = 1000) String link, @NotNull @Length(max = 1000) String description,
			@Length(max = 100) @NotNull String name, @NotNull String price, String image, int score, Category category,
			User user, int categoryID) {
		super();
		this.dealID = dealID;
		this.link = link;
		this.description = description;
		this.name = name;
		this.price = price;
		this.image = image;
		this.score = score;
		this.category = category;
		this.user = user;
		this.categoryID = categoryID;
	}

}
