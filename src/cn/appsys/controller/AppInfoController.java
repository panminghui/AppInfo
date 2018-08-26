package cn.appsys.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.AppInfo;
import cn.appsys.service.developer.AppInfoService;

@Controller
@RequestMapping("/app")
public class AppInfoController {
	@Resource
	private AppInfoService AppInfoService;
	private Logger logger = Logger.getLogger(DevUserController.class);

	@RequestMapping("/flatform/app/list")
	public String getAppInfoList(@RequestParam(value = "querySoftwareName", required = false) String querySoftwareName,
			@RequestParam(value = "queryStatus", required = false) Integer queryStatus,
			@RequestParam(value = "queryCategoryLevel1", required = false) Integer queryCategoryLevel1,
			@RequestParam(value = "queryCategoryLevel2", required = false) Integer queryCategoryLevel2,
			@RequestParam(value = "queryCategoryLevel3", required = false) Integer queryCategoryLevel3,
			@RequestParam(value = "queryFlatformId", required = false) Integer queryFlatformId,
			@RequestParam(value = "devId", required = false) Integer devId,
			@RequestParam(value = "currentPageNo", required = false) Integer currentPageNo,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,Model model) {
		List<AppInfo> list =new ArrayList<AppInfo>();
		list = AppInfoService.getAppInfoList(querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2,
				queryCategoryLevel3, queryFlatformId, devId, currentPageNo, pageSize);
		/*model.addAttribute("appInfoList", appInfoList);
		model.addAttribute("statusList", statusList);
		model.addAttribute("flatFormList", flatFormList);
		model.addAttribute("categoryLevel1List", categoryLevel1List);
		model.addAttribute("pages", pages);*/
		model.addAttribute("queryStatus", queryStatus);
		model.addAttribute("querySoftwareName", querySoftwareName);
		model.addAttribute("queryCategoryLevel1", queryCategoryLevel1);
		model.addAttribute("queryCategoryLevel2", queryCategoryLevel2);
		model.addAttribute("queryCategoryLevel3", queryCategoryLevel3);
		model.addAttribute("queryFlatformId", queryFlatformId);
		return "developer/appinfolist";
	}
}
