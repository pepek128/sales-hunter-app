package com.patryk.application.dto;

import java.util.ArrayList;
import java.util.List;

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
	private UserDTO userDTO;
	private String voted;
	public List<UserDTO> votedDTO;	
	

	

	public String getVoted() {
		return voted;
	}

	public void setVoted(String voted) {
		this.voted = voted;
	}

	public List<UserDTO> getVotedDTO() {
		return votedDTO;
	}

	public void setVotedDTO(List<UserDTO> votedDTO) {
		this.votedDTO = votedDTO;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
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

	public DealDTO(int dealID, @NotNull String link, @NotNull String description, @NotNull String name,
			@NotNull String price, String image, int score, int categoryID, String username, Category category,
			UserDTO userDTO, String voted, List<UserDTO> votedDTO) {
		super();
		this.dealID = dealID;
		this.link = link;
		this.description = description;
		this.name = name;
		this.price = price;
		this.image = image;
		this.score = score;
		this.categoryID = categoryID;
		this.username = username;
		this.category = category;
		this.userDTO = userDTO;
		this.voted = voted;
		this.votedDTO = votedDTO;
	}

}
