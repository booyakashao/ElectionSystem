package com.ElectionWebAdministration.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ElectionWebAdministration.web.be.Voter;
import com.ElectionWebAdministration.web.dao.IVoterDAO;
import com.ElectionWebAdministration.web.service.UserService;

@Controller
public class VoterFunctionController {

	private static final Logger logger = Logger.getLogger(VoterFunctionController.class);
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin(ModelMap model) {
		
		return "login";
	}
	
	@RequestMapping(value = "/loggedout", method = RequestMethod.GET)
	public String showLoggedOut(ModelMap model) {
		
		return "loggedout";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String registerVoterPage(ModelMap model) {
		model.addAttribute("voter", new Voter());
		
		return "signup";
	}
	
	@RequestMapping(value="/createaccount", method=RequestMethod.POST)
	public String doCreate(ModelMap model, @Valid Voter voter, BindingResult result) {
		
		userService.createVoter(voter);
		
		return "accountcreated";
	}
	
	@RequestMapping(value="/denied")
	public String showDenied(ModelMap model) {
		
		return "denied";
	}
	
	//Admin paths ===========================================================================
	
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String administrationPage(ModelMap model) {
		
		List<Voter> allVoters = userService.getAllVoters();
		
		model.addAttribute("allVoters", allVoters);
		
		return "admin";
	}
	
	@RequestMapping(value="/delete/{voterId}", method=RequestMethod.GET)
	public String deleteVote(@PathVariable("voterId") long voterId, ModelMap model) {
		
		userService.DeleteVoter(voterId);
		model.addAttribute("voterDeleteConfirm", "Voter " + voterId + " has been deleted.");
		
		return administrationPage(model);
	}
	
	//===========================================================================================
}
