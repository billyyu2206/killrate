package com.etonghk.killrate.controller.helper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ami.Tsai
 * @date 2019年1月27日
 */
public class ApiUriHelper {
	
	static List<String> excludeSessionUrls = new ArrayList<>();
	static List<String> excludeSessionWildcardUrl = new ArrayList<>();
	static {
		excludeSessionUrls.add("/betRecord/send");
		excludeSessionUrls.add("/awardNumber/clearKillRate");
		excludeSessionUrls.add("/cache/reset");
		excludeSessionUrls.add("/killrateSetting/switch");
		excludeSessionUrls.add("/killrateSetting/changeSwitch");
		excludeSessionWildcardUrl.add("/awardNumber/*");
		excludeSessionWildcardUrl.add("/gameIssus/*");
	}

	public static Boolean checkIsApiUri(String uri) {
		Boolean isApiUri = false;
		if (excludeSessionUrls.contains(uri)) {
			isApiUri = true;
		}else {
			for(String urlPattern:excludeSessionWildcardUrl) {
				urlPattern = urlPattern.replace("*", "");
				if(uri.contains(urlPattern)) {
					isApiUri = true;
				}
			}
		}
		return isApiUri;
	}

}
