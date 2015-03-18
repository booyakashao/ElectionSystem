package com.ElectionWebAdministration.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ElectionWebAdministration.web.be.AndroidLogin;
import com.ElectionWebAdministration.web.be.Voter;
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
		
		userService.deleteVoter(voterId);
		model.addAttribute("voterDeleteConfirm", "Voter " + voterId + " has been deleted.");
		
		return administrationPage(model);
	}
	
	//===========================================================================================
	
	//Mobile Login Paths=======================================================================
	@RequestMapping(value="/androidlogin", method = RequestMethod.POST)
	public @ResponseBody Voter testJSONRequest(@RequestBody AndroidLogin androidLogin) {
		
		// find voter by username
		Voter foundVoter = null;
		
		try {
			foundVoter = userService.findVoterByUsername(androidLogin.getUsername());
		} catch (Exception e) {
			logger.error("Voter not found.");
			logger.error("Username: " + androidLogin.getUsername());
			logger.error("Password: " + androidLogin.getPassword());
			return new Voter();
		}
				
		
		if(userService.checkPasswordMatch(androidLogin.getPassword(), foundVoter.getPassword())) {
			logger.info("The passwords match");
		} else {
			logger.info("The passwords do not match");
		}
		
		return foundVoter;
	}
	
	@RequestMapping(value="/androidlogin/getAllVoters/", method = RequestMethod.GET)
	public @ResponseBody List<Voter> getAllVoters() {
		return userService.getAllVoters();
	}
	
	//=========================================================================================
}
