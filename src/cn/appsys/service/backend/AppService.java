package cn.appsys.service.backend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppInfo;

public interface AppService {
	/**
	 * 根据条件查询AppInfo表的集合
	 * 
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
	public List<AppInfo> getAppInfoList(@Param(value = "softwareName") String querySoftwareName,
			@Param(value = "categoryLevel1") Integer queryCategoryLevel1,
			@Param(value = "categoryLevel2") Integer queryCategoryLevel2,
			@Param(value = "categoryLevel3") Integer queryCategoryLevel3,
			@Param(value = "flatformId") Integer queryFlatformId,
			@Param(value = "from") Integer currentPageNo, 
			@Param(value = "pageSize") Integer pageSize) throws Exception;

	public int getAppInfoCount(@Param(value = "softwareName") String querySoftwareName,
			@Param(value = "categoryLevel1") Integer queryCategoryLevel1,
			@Param(value = "categoryLevel2") Integer queryCategoryLevel2,
			@Param(value = "categoryLevel3") Integer queryCategoryLevel3,
			@Param(value = "flatformId") Integer queryFlatformId) throws Exception;
	
	public AppInfo getAppInfo(@Param(value="id")Integer id)throws Exception;
	
	public boolean updateStatus(@Param(value="status")Integer status,
			@Param(value="id")Integer id) throws Exception;
}
