package cn.appsys.dao.backenduser;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.BackendUser;

public interface BackendUserMapper {
	/**
	 * 根据userCode获取用户记录
	 * @param userCode
	 * @return
	 */
	public BackendUser getLoginUser(@Param("userCode")String userCode) throws Exception;
}
