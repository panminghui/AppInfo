package cn.appsys.service.developer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.appsys.dao.appinfo.AppInfoMapper;
import cn.appsys.pojo.AppInfo;

@Service
public class AppInfoServiceImpl implements AppInfoService {
	private AppInfoMapper appInfoMapper;

	@Override
	public List<AppInfo> getAppInfoList(String querySoftwareName, Integer queryStatus, Integer queryCategoryLevel1,
			Integer queryCategoryLevel2, Integer queryCategoryLevel3, Integer queryFlatformId, Integer devId,
			Integer currentPageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		List<AppInfo> list =new ArrayList<AppInfo>();
		try {
			list = appInfoMapper.getAppInfoList(querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2,
					queryCategoryLevel3, queryFlatformId, devId, currentPageNo, pageSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(AppInfo a : list){
			System.out.println(a.getAPKName()+"=================================================");
		}
		return list;
	}

}
