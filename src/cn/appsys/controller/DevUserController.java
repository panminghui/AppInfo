package cn.appsys.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.appsys.pojo.DevUser;
import cn.appsys.service.developer.DevUserService;
import cn.appsys.tools.Constants;

@Controller
@RequestMapping(value = "/dev")
public class DevUserController {
	@Resource
	private DevUserService DevUserService;
	
	private Logger logger = Logger.getLogger(DevUserController.class);

	/**
	 * 用户点击“开发者平台入口”时跳入的登录界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login.html")
	public String login() {
		logger.debug("DevUserController welcome login");
		return "devlogin";
	}
	/**
	 * 登陆功能
	 * @param user
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/dologin", method = RequestMethod.POST)
	public String dologin(DevUser user, HttpSession session, HttpServletRequest request) {
		logger.debug("dologin=========================");
		DevUser Dev = DevUserService.login(user.getDevCode(), user.getDevPassword());
		if (Dev != null) {
			session.setAttribute(Constants.DEV_USER_SESSION, Dev);
			return "redirect:/dev/flatform/main";
		} else {
			request.setAttribute("error", "用户或者密码不正确");
			return "devlogin";
		}
	}
	/**
	 * 判断用户是否是非法进入的
	 * @param session
	 * @return
	 */
	@RequestMapping("/flatform/main")
	public String main(HttpSession session) {
		if (session.getAttribute(Constants.DEV_USER_SESSION) == null) {
			return "redirect:/dev/login.html";
		}
		return "developer/main";
	}
	/**
	 * 用户注销
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute(Constants.DEV_USER_SESSION);
		return "devlogin";
	}
}
