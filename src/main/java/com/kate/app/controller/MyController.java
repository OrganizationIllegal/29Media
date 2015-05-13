package com.kate.app.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.kate.app.service.MyService;


@Controller
public class MyController {
	@Autowired
	private MyService myService;
	
	
	@RequestMapping({ "/", "/My" })
	public String test_controller(HttpServletRequest req, HttpServletResponse resp){
		//JSONObject json = new JSONObject();
		//String name = myService.test();
		//json.put("result", "Kate");
		req.setAttribute("result", "Kate");
		/*try{
		writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}*/
		//return "/My1.jsp";
		return "/My_H.jsp";
	}
	
	public void writeJson(String json, HttpServletResponse response)throws Exception{
	    response.setContentType("text/html");
	    response.setCharacterEncoding("UTF-8");
	    PrintWriter out = response.getWriter();
	    if(StringUtils.isNotEmpty(json)){
	        out.println(json);
	    }
	    out.flush();
	    out.close();
	}
	
}

