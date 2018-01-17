package com.rey70n.demo.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * @author Reyton
 */
@Controller
public class SystemController {

    private static final Logger logger = LoggerFactory.getLogger(SystemController.class);

    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
        logger.info("IP:{}访问【登录】页面。", request.getRemoteAddr());
        return "login";
    }

    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
        logger.info("IP:{}访问【首页】页面。", request.getRemoteAddr());
        return "index";
    }

    @RequestMapping("/")
    public String root(HttpServletRequest request) {
        logger.info("IP:{}访问【首页】页面。", request.getRemoteAddr());
        return "index";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        /***
         * 您可以随意重定向，但通常再次显示登录屏幕是一种很好的做法。
         */
        logger.info("IP:{}注销登录。", request.getRemoteAddr());
        return "redirect:/login";
    }
}