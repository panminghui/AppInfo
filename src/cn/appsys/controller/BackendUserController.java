package cn.appsys.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.appsys.pojo.BackendUser;
import cn.appsys.service.backend.BackendUserService;
import cn.appsys.tools.Constants;



@Controller
@RequestMapping(value="/manager")
public class BackendUserController {
	private Logger logger = Logger.getLogger(BackendUserController.class);
	@Resource
	private BackendUserService backendUserService;
	
	/**
	 * 用户点击“后台管理系统入口”时跳入的登录界面
	 * 
	 * @return
	 */
	@RequestMapping(value="/index.html")
	public String login(){
		logger.debug("BackendUserController welcome login===========");
		return "backendlogin";
	}
	/**
	 * 登陆功能
	 * @param user
	 * @param session
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/dologin",method=RequestMethod.POST)
	public String dologin(BackendUser user,HttpSession session,HttpServletRequest request) throws Exception{
		logger.debug("dologin======================");
		BackendUser backend = backendUserService.login(user.getUserCode(), user.getUserPassword());
		if(backend != null){
			session.setAttribute(Constants.USER_SESSION, backend);
			return "redirect:/manager/backend/main";
		}else{
			request.setAttribute("error", "用户或者密码不正确");
			return "backendlogin";
		}
	}
	/**
	 * 判断用户是否是非法进入的
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/backend/main")
	public String main(HttpSession session){
		if(session.getAttribute(Constants.USER_SESSION) == null){
			return "redirect:/backend/index.html";
		}
		return "backend/main";
	}
	/**
	 * 用户注销
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/logout")
	public String logout(HttpSession session){
		logger.debug("logout========================");
		session.removeAttribute(Constants.USER_SESSION);
		return "backendlogin";
	}
}
