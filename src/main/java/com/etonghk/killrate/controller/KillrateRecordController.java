/**
 * 
 */
package com.etonghk.killrate.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.etonghk.killrate.awardnmber.constant.KillrateConstant;
import com.etonghk.killrate.controller.dto.request.KillrateRecordRequest;
import com.etonghk.killrate.dao.page.Page;
import com.etonghk.killrate.domain.KillrateAward;
import com.etonghk.killrate.service.killrateaward.KillrateAwardService;

/**
 * @author Peter.Hong
 * @date 2019年1月17日
 */
@Controller
@RequestMapping("killrate/awardRecord")
public class KillrateRecordController {

	@Autowired
	private KillrateAwardService killrateAwardService;
	
	private final static String PAGE = "killrate/awardRecord/index";
	
	private static List<String> gameList = new ArrayList<String>();
	static {
		KillrateConstant.allGameMap.forEach((k,v)->gameList.add(k));
	}
	
	@RequestMapping()
	public String index(@ModelAttribute(value = "killRateReq")KillrateRecordRequest killRateReq,Model model) {
		model.addAttribute("gameList",gameList);
		model.addAttribute("killRate",killRateReq);
		return PAGE;
	}
	
	@RequestMapping("search")
	public String search(@ModelAttribute(value = "killRateReq")KillrateRecordRequest killRateReq, @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, Model model) {
		Page<KillrateAward> page = new Page<KillrateAward>();
		page.setPageNo(pageNo);
		page.setPageSize(100);
		page= killrateAwardService.selectForRecord(killRateReq.getLottery(), killRateReq.getIssueDate(), killRateReq.getIsKillRate(), page);
		
		model.addAttribute("gameList",gameList);
		model.addAttribute("killRate",killRateReq);
		model.addAttribute("killAwardList", page.getRecords());
		model.addAttribute("page",page);
		
		return PAGE;
	}
	
}
