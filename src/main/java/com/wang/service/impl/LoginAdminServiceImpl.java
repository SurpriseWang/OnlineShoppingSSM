package com.wang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wang.mappers.AdminMapper;
import com.wang.pojo.Admin;
import com.wang.pojo.AdminExample;
import com.wang.service.LoginAdminService;

@Service
public class LoginAdminServiceImpl implements LoginAdminService {
	@Autowired
	private AdminMapper adminMapper;

	@Override
	public boolean queryLoginAdmin(String adminname, String password) {
		AdminExample adminExample = new AdminExample();
		adminExample.createCriteria().andAdminnameEqualTo(adminname).andPasswordEqualTo(password);
		List<Admin> admin = adminMapper.selectByExample(adminExample);
		if (admin.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
}
