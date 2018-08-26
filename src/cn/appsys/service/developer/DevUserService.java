package cn.appsys.service.developer;

import cn.appsys.pojo.DevUser;

public interface DevUserService {
	/**
	 * 登录验证
	 * 
	 * @param devCode
	 * @return
	 */
	public DevUser login(String devCode,String password);
}
