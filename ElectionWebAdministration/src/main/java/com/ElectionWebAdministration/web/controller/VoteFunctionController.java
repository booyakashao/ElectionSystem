package com.ElectionWebAdministration.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ElectionWebAdministration.web.be.AndroidCandidate;
import com.ElectionWebAdministration.web.be.AndroidVoteCast;
import com.ElectionWebAdministration.web.be.AndroidVoter;
import com.ElectionWebAdministration.web.be.Candidate;
import com.ElectionWebAdministration.web.be.Vote;
import com.ElectionWebAdministration.web.be.Voter;
import com.ElectionWebAdministration.web.be.WebUser;
import com.ElectionWebAdministration.web.service.CandidateService;
import com.ElectionWebAdministration.web.service.UserService;
import com.ElectionWebAdministration.web.service.VoteService;

@Controller
public class VoteFunctionController {

	private static final Logger logger = Logger.getLogger(VoteFunctionController.class);
	
	@Autowired
	@Qualifier("candidateService")
	private CandidateService candidateService;
	
	@Autowired
	@Qualifier("voteService")
	private VoteService voteService;
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
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
		
		if(voteService.voterHasVote(currentVoter)) {
			Vote currentVote = voteService.getVoteByVoter(currentVoter);
			if(currentVote.getCandidate().getId() == currentCandidate.getId() &&
				currentVote.getCandidate().getDescription().matches(currentCandidate.getDescription()) &&
				currentVote.getCandidate().getName().matches(currentCandidate.getName())) {
				model.addAttribute("currentVote", "You are curently voting for this candidate.");
				model.addAttribute("thisCandidateVoted", true);
			} else {
				model.addAttribute("thisCandidateVoted", false);
				model.addAttribute("currentVote", "You are currenty voting for " + currentVote.getCandidate().getName() + ". Do you want to change your vote?");
			}
		} else {
			model.addAttribute("thisCandidateVoted", false);
		}

		model.addAttribute("currentCandidate", currentCandidate);
		
		return "votecandidate";
	}
	
	@RequestMapping(value="/castvote/{candidateId}", method=RequestMethod.GET)
	public String castVote(ModelMap model, @PathVariable("candidateId") long candidateId) {
		
		WebUser currentUser = (WebUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Voter currentVoter = currentUser.getVoter();
		Candidate targetCandidate = candidateService.getCandidateById(candidateId);
		
		if(voteService.voterHasVote(currentVoter)) {
			Vote currentVote = voteService.getVoteByVoter(currentVoter);
			if(currentVote.getCandidate() != targetCandidate) {
				voteService.deleteVote(currentVote.getId());
				
				voteService.createVote(new Vote(targetCandidate, currentVoter));
			}
		} else {
			voteService.createVote(new Vote(targetCandidate, currentVoter));
		}
		
		return voteCandidate(model, candidateId);
	}
	
	//Android Functions=================================================================================================
	
	@RequestMapping(value="/androidvote/votercandidate", method=RequestMethod.POST)
	public @ResponseBody Candidate getCandidateForVoter(@RequestBody AndroidVoter androidVoter) {
		
		Voter currentVoter = new Voter();
		currentVoter.setId(androidVoter.getId());
		
		if(voteService.voterHasVote(currentVoter)) {
			Vote currentVote = voteService.getVoteByVoter(currentVoter);
			return currentVote.getCandidate();
		} else {
			return null;
		}
	}
	
	@RequestMapping(value="/androidvote/allcandidates", method=RequestMethod.GET)
	public @ResponseBody List<Candidate> getAllCandidates() {
		return candidateService.getAllCandidates();
	}
	
	@RequestMapping(value="/androidvote/candidatepage", method=RequestMethod.POST)
	public @ResponseBody Candidate getCandidateById(@RequestBody AndroidCandidate androidCandidate) {
		return candidateService.getCandidateById(androidCandidate.getId());
	}
	
	@RequestMapping(value="/androidvote/castvote", method=RequestMethod.POST)
	public void castVote(@RequestBody AndroidVoteCast androidVoteCast) {
		Vote vote = new Vote();
		vote.setCandidate(candidateService.getCandidateById(androidVoteCast.getCandidateId()));
		vote.setVoter(userService.getVoterById(androidVoteCast.getVoterId()));
		
		voteService.createVote(vote);
	}
	
	//==================================================================================================================
}
