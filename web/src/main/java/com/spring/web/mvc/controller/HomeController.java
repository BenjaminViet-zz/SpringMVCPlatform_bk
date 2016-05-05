package com.spring.web.mvc.controller;

import com.spring.business.UserService;
import com.spring.web.util.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: vietquocpham
 * Date: 3/28/16
 * Time: 23:24
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "/home.html", "/welcome.html"})
    public String homePage(ModelMap model) {
        model.addAttribute("greeting", "Hi, Welcome to mysite");
        return "welcome";
    }

    @RequestMapping(value = "/admin.html", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", SpringUtils.getPrincipal());
        return "admin";
    }

    @RequestMapping(value = "/db.html", method = RequestMethod.GET)
    public String dbaPage(ModelMap model) {
        model.addAttribute("user", SpringUtils.getPrincipal());
        return "dba";
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", SpringUtils.getPrincipal());
        return "accessDenied";
    }

    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value="/logout.html", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login.html?logout";
    }
}
