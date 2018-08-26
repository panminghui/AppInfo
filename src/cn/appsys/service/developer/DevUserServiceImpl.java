package cn.appsys.service.developer;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.devuser.DevUserMapper;
import cn.appsys.pojo.DevUser;
@Service("DevUserService")
public class DevUserServiceImpl implements DevUserService {
	@Resource
	private DevUserMapper mapper;
	@Override
	public DevUser login(String devCode,String password) {
		DevUser user = null;
		user = mapper.getLoginUser(devCode);
		if (user !=null) {
			if (!user.getDevPassword().equals(password)) {
				user = null;
			}
		}
		return user;
	}

}
