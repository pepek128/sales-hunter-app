package com.patryk.application.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.patryk.application.dto.DealDTO;
import com.patryk.application.dto.UserDTO;
import com.patryk.application.models.Deal;
import com.patryk.application.models.User;
import com.patryk.application.services.DealService;
import com.patryk.application.services.StorageService;

@RestController
public class DealController {
	HttpServletResponse response;
	private static final ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private DealService dealService;

	@Autowired
	private StorageService storageService;

	@GetMapping("/deals")
	public List<DealDTO> getAllDeals() {

		List<Deal> deals = dealService.getAllDeals();
		List<DealDTO> dealsDTO = usersMapper(deals);
		return dealsDTO;
	}

	@GetMapping("/deals/{id}")
	public DealDTO getDeal(@PathVariable Integer id) {

		Deal deal = dealService.getDeal(id);
		DealDTO dealDTO = userMapper(deal);
		return dealDTO;

	}

	@PostMapping("/deal")
	public void addNewDeal(@RequestBody DealDTO dealDTO) throws IOException {

		Deal deal = modelMapper.map(dealDTO, Deal.class);

		dealService.addNewDeal(deal);

	}

	@PutMapping("/deal")
	public void updateDealScore(@RequestParam("id") Integer id, @RequestParam("score") Integer score,
			@RequestParam("voted") String voted) throws IOException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Deal pom = dealService.getDeal(id);
		if (Math.abs(pom.getScore() - score) == 1 && voted.equals(authentication.getName())) {
			dealService.updateScore(voted, id, score);
		}

	}

	/*
	 * @PutMapping("/deal") public void updateDealScore(@RequestBody DealDTO
	 * dealDTO) {
	 * 
	 * Deal deal = userReMapper(dealDTO); System.out.println(deal.getVoted()); //
	 * dealService.updateScore(deal);
	 * System.out.println(deal.getUser().getUsername() + "" +
	 * deal.getUser().getName());
	 * 
	 * }
	 */
	/*
	 * @PutMapping("/edit") public void updateDeal(@RequestBody DealDTO dealDTO) {
	 * Authentication authentication =
	 * SecurityContextHolder.getContext().getAuthentication(); if
	 * (dealDTO.getUserDTO().getUsername().equals( authentication.getName())) { Deal
	 * deal = userReMapper(dealDTO);
	 * 
	 * dealService.updateDeal(deal); }
	 * 
	 * }
	 */
	@PutMapping("/edit")
	public void updateDeal(@RequestBody DealDTO dealDTO) throws IOException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (dealDTO.getUserDTO().getUsername().equals(authentication.getName())) {
			Deal deal = userReMapper(dealDTO);
			String oldfilename = dealService.getDeal(deal.getDealID()).getImage();
			System.out.println(oldfilename+deal.getImage());	
			
			if (oldfilename.length()>0 && !oldfilename.equals(deal.getImage()) && deal.getImage().length()>0) {
				storageService.deleteFile(oldfilename);
			}

			dealService.updateDeal(deal);
		}

	}

	@DeleteMapping("/delete/{id}")
	public void deleteDeal(@PathVariable Integer id) throws IOException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Deal pom = dealService.getDeal(id);
			
		if (pom.getUser().getUsername().equals(authentication.getName())) {
			System.out.println("weszlo");
			if (!pom.getImage().isEmpty()) {
				storageService.deleteFile(pom.getImage());
			}
			dealService.delete(id);
		}

	}

	@GetMapping("/deals/search/desc/{text}")
	public List<DealDTO> getDealsByDesc(@PathVariable String text) {
		List<Deal> deals = dealService.getDealByDesc(text);
		List<DealDTO> dealsDTO = usersMapper(deals);
		return dealsDTO;
	}

	@GetMapping("/deals/search/name/{name}")
	public List<DealDTO> getDealsByName(@PathVariable String name) {
		List<Deal> deals = dealService.getDealByName(name);
		List<DealDTO> dealsDTO = usersMapper(deals);
		return dealsDTO;
	}

	@GetMapping("/deals/search/cat/{categoryID}")
	public List<DealDTO> getDealsByCat(@PathVariable Integer categoryID) {
		List<Deal> deals = dealService.getDealByCat(categoryID);
		List<DealDTO> dealsDTO = usersMapper(deals);
		return dealsDTO;
	}

	@GetMapping("/recommended/{username}")
	public List<DealDTO> getRecommendedDeals(@PathVariable String username) {
		List<Deal> deals = dealService.getRecommendedDeals(username);
		List<DealDTO> dealsDTO = usersMapper(deals);

		return dealsDTO;
	}

	public List<DealDTO> usersMapper(List<Deal> deals) {

		List<DealDTO> dealsDTO = new ArrayList<>();
		List<User> voted = new ArrayList<>();
		DealDTO dealDTO = new DealDTO();
		UserDTO userDTO = new UserDTO();

		for (Deal x : deals) {

			voted = x.getVotedusers();
			List<UserDTO> votedDTO = new ArrayList<>();
			UserDTO authorDTO;
			for (User y : voted) {

				userDTO = modelMapper.map(y, UserDTO.class);
				votedDTO.add(userDTO);

			}
			authorDTO = modelMapper.map(x.getUser(), UserDTO.class);
			dealDTO = modelMapper.map(x, DealDTO.class);
			dealDTO.setVotedDTO(votedDTO);
			dealDTO.setUserDTO(authorDTO);
			dealsDTO.add(dealDTO);

		}
		return dealsDTO;
	}

	public DealDTO userMapper(Deal deal) {
		List<UserDTO> votedDTOList = new ArrayList<>();
		List<User> votedList = new ArrayList<>();
		UserDTO authorDTO;
		User author;
		DealDTO dealDTO = modelMapper.map(deal, DealDTO.class);

		author = deal.getUser();
		authorDTO = modelMapper.map(author, UserDTO.class);
		dealDTO.setUserDTO(authorDTO);

		votedList = deal.getVotedusers();
		for (User y : votedList) {

			votedDTOList.add(modelMapper.map(y, UserDTO.class));

		}

		dealDTO.setVotedDTO(votedDTOList);

		return dealDTO;
	}

	public Deal userReMapper(DealDTO dealDTO) {
		List<UserDTO> votedDTOList = new ArrayList<>();
		List<User> votedList = new ArrayList<>();
		UserDTO authorDTO;
		User author;
		Deal deal = modelMapper.map(dealDTO, Deal.class);

		authorDTO = dealDTO.getUserDTO();
		author = modelMapper.map(authorDTO, User.class);
		deal.setUser(author);

		votedDTOList = dealDTO.getVotedDTO();
		for (UserDTO y : votedDTOList) {

			votedList.add(modelMapper.map(y, User.class));

		}

		deal.setVotedusers(votedList);

		return deal;
	}
}
