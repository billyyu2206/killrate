/**
 * 
 */
package com.etonghk.killrate.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.etonghk.killrate.controller.dto.request.KillrateRecordRequest;
import com.etonghk.killrate.dao.page.Page;
import com.etonghk.killrate.domain.KillrateAward;
import com.etonghk.killrate.service.killrateAward.KillrateAwardService;

/**
 * @author Peter.Hong
 * @date 2019年1月17日
 */
@Controller
@RequestMapping("killrate/awardRecord")
public class KillrateRecordController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private KillrateAwardService killrateAwardService;
	
	private final static String PAGE = "killrate/awardRecord/index";
	
	private static List<String> gameList = new ArrayList<String>();
	static {
		gameList.add("vipssc");
	}
	
	@RequestMapping()
	public String index(@ModelAttribute(value = "killRateReq")KillrateRecordRequest killRateReq,Model model) {
		model.addAttribute("gameList",gameList);
		model.addAttribute("killRate",killRateReq);
		return PAGE;
	}
	
	@RequestMapping("search")
	public String search(@ModelAttribute(value = "killRateReq")KillrateRecordRequest killRateReq, @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, Model model) {
		Page page = new Page();
		page.setPageNo(pageNo);
		List<KillrateAward> killAwardList= killrateAwardService.selectForRecord(killRateReq.getGameId(), killRateReq.getIssueDate(), killRateReq.getIsKillRate(), page);
		
		model.addAttribute("gameList",gameList);
		model.addAttribute("killRate",killRateReq);
		model.addAttribute("killAwardList", killAwardList);
		model.addAttribute("page",page);
		
		return PAGE;
	}
	
}
