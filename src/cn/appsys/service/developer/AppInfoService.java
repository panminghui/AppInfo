package cn.appsys.service.developer;

import java.util.List;


import cn.appsys.pojo.AppInfo;

public interface AppInfoService {
	/**
	 * 根据条件查询AppInfo表的集合
	 * @param querySoftwareName
	 * @param queryStatus
	 * @param queryCategoryLevel1
	 * @param queryCategoryLevel2
	 * @param queryCategoryLevel3
	 * @param queryFlatformId
	 * @param devId
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 */
	public List<AppInfo> getAppInfoList(String querySoftwareName,
			Integer queryStatus,
			Integer queryCategoryLevel1,
			Integer queryCategoryLevel2,
			Integer queryCategoryLevel3,
			Integer queryFlatformId,
			Integer devId,
			Integer currentPageNo,
			Integer pageSize);
}
