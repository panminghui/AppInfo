package cn.appsys.service.backend;

import cn.appsys.pojo.BackendUser;

public interface BackendUserService {
	/**
	 * 登录验证
	 * 
	 * @param userCode
	 * @return
	 */
	public BackendUser login(String userCode,String userPassword) throws Exception;
}
