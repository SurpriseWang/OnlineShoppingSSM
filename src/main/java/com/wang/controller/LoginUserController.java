package com.wang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wang.service.LoginAdminService;

@Controller
public class LoginUserController {
	@Autowired
	private LoginAdminService loginAdminService;

	@ResponseBody
	@RequestMapping("/queryLoginAdmin.action")
	public Boolean queryLoginAdmin(String adminname, String password) {
		boolean loginAdmin = loginAdminService.queryLoginAdmin(adminname, password);
		if (loginAdmin) {
			return true;
		} else {
			return false;
		}
	}
}