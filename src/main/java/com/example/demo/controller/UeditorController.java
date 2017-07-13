package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ueditor.ActionEnter;


@Controller
@RequestMapping("/ueditor")
public class UeditorController {

	@Autowired 
	private ActionEnter actionEnter;
	
	@ResponseBody
	@RequestMapping("/upload")
	public String exe(HttpServletRequest request) throws JSONException {
		return actionEnter.exec(request);
	}
	
}
