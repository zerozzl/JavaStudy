package com.zerozzl.study.spring.web.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zerozzl.study.vo.UserVO;

@RestController
@RequestMapping("/login")
public class LoginController {

	@RequestMapping(value = "/doLogin",
			method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String doLogin(@Valid UserVO vo) {
		return "welcome: " + vo.toString();
	}

}
