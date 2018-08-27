package cn.appsys.service.developer;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.appinfo.AppInfoMapper;
import cn.appsys.pojo.AppInfo;

@Service
public class AppInfoServiceImpl implements AppInfoService {
	@Resource
	private AppInfoMapper appInfoMapper;

	@Override
	public List<AppInfo> getAppInfoList(String querySoftwareName, Integer queryStatus, Integer queryCategoryLevel1,
			Integer queryCategoryLevel2, Integer queryCategoryLevel3, Integer queryFlatformId, Integer devId,
			Integer currentPageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		List<AppInfo> list = new ArrayList<AppInfo>();
		try {
			list = appInfoMapper.getAppInfoList(querySoftwareName, queryStatus, queryCategoryLevel1,
					queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, devId, (currentPageNo-1)*pageSize, pageSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getAppInfoCount(String querySoftwareName, Integer queryStatus, Integer queryCategoryLevel1,
			Integer queryCategoryLevel2, Integer queryCategoryLevel3, Integer queryFlatformId, Integer devId) {
		return appInfoMapper.getAppInfoCount(querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2,
				queryCategoryLevel3, queryFlatformId, devId);

	}

}
