package com.ElectionWebAdministration.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ElectionWebAdministration.web.be.Candidate;
import com.ElectionWebAdministration.web.service.CandidateService;

@Controller
public class CandidateFunctionController {

	@Autowired
	@Qualifier("candidateService")
	private CandidateService candidateService;
	
	@RequestMapping(value="/candidatepage", method=RequestMethod.GET)
	public String candidatePage(ModelMap model) {
		
		model.addAttribute("allCandidates", candidateService.getAllCandidates());
		
		return "candidatepage";
	}
	
	@RequestMapping(value="/candidatepage/delete/{candidateId}", method=RequestMethod.GET)
	public String deleteCandidate(ModelMap model, @PathVariable("candidateId") long candidateId) {
		
		candidateService.deleteCandidate(candidateId);
		model.addAttribute("candidateDeleteConfirm", "Candidate " + candidateId + " has been deleted.");
		
		return candidatePage(model);
	}
	
	@RequestMapping(value="/newcandidatepage", method=RequestMethod.GET)
	public String newCandidatePage(ModelMap model) {
		
		model.addAttribute("candidate", new Candidate());
		
		return "newcandidatepage";
	}
	
	@RequestMapping(value="/createcandidate", method=RequestMethod.POST)
	public String createCandidatePage(ModelMap model, @Valid Candidate candidate, BindingResult result) {
		
		candidateService.createCandidate(candidate);
		
		return candidatePage(model);
	}
}
