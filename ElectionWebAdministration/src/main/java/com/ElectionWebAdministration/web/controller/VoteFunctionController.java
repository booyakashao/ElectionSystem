package com.ElectionWebAdministration.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ElectionWebAdministration.web.be.Candidate;
import com.ElectionWebAdministration.web.be.Voter;
import com.ElectionWebAdministration.web.be.WebUser;
import com.ElectionWebAdministration.web.service.CandidateService;

@Controller
public class VoteFunctionController {

	private static final Logger logger = Logger.getLogger(VoteFunctionController.class);
	
	@Autowired
	@Qualifier("candidateService")
	private CandidateService candidateService;
	
	@RequestMapping(value="/vote", method=RequestMethod.GET)
	public String votePage(ModelMap model) {
		
		model.addAttribute("allCandidates", candidateService.getAllCandidates());
		
		return "vote";
	}
	
	@RequestMapping(value="/votecandidate/{candidateId}", method=RequestMethod.GET)
	public String voteCandidate(ModelMap model, @PathVariable("candidateId") long candidateId) {
		
		WebUser currentUser = (WebUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Voter currentVoter = currentUser.getVoter();
		
		Candidate currentCandidate = candidateService.getCandidateById(candidateId);
		
		model.addAttribute("currentCandidate", currentCandidate);
		
		return "votecandidate";
	}
}
