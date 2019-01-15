package com.etonghk.killrate.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etonghk.killrate.vo.AwardNumberBean;

@RestController
@RequestMapping("/awardNumber")
public class AwardNumberController {

	@PostMapping("/gameId/{gameId}/issue/{issue}")
	public AwardNumberBean getAwardNumber(@PathVariable String gameId,@PathVariable String issue) {
		
		AwardNumberBean result = new AwardNumberBean();
		result.setAwardNumber("1,2,3,4,5");
		result.setGameId(gameId);
		result.setIssue(issue);
		result.setTimeStamp(new Date());
		
		return result;
	}
	
	
}
