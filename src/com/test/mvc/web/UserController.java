package com.test.mvc.web;
 


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.*; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*; 
import org.springframework.web.servlet.*; 

import com.alibaba.fastjson.JSON;


/** 
 * 控制器，用Controller注解 
 */ 
@Controller 
@RequestMapping("/user")
public class UserController { 

	private Logger log = Logger.getLogger(UserController.class);
  

    /** 
     * 如果不需要Model，直接返String更简单，对应的view为add1.jsp 
     */ 
    @RequestMapping(value = "/add1") 
    public String login(){ 
        return "user/add1"; 
    } 

    @RequestMapping(value = "/add2") 
    public String login2(){ 
        return "user/add2"; 
    } 
    @RequestMapping(value = "/add3") 
    public String login3(){ 
        return "user/add3"; 
    } 
    @RequestMapping(value = "/add4") 
    public String login4(){ 
        return "user/add4"; 
    } 
    
    
    @RequestMapping("/addUser1")
    public String addUser1(String userName,String password) {
    	log.info("userName is:"+userName);
    	log.info("password is:"+password);
        return "/user/success";
    }
    
    
    
    @RequestMapping("/addUser2")
    public String addUser2(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        log.info("userName is:"+userName);
        log.info("password is:"+password);
        request.setAttribute("username", userName);
        request.setAttribute("password", password);
        return "/user/success";
    }
    
    @RequestMapping("/addUser3")
    public String addUser3(User user,Model model) {
        log.info("userName is:"+user.getUserName());
        log.info("password is:"+user.getPassword());
        model.addAttribute(user);
        return "/user/success2";
    }
    
    @RequestMapping("/addUser4")
    @ResponseBody
    public String addUser4(User user) {
        log.info("userName is:"+user.getUserName());
        log.info("password is:"+user.getPassword());
        return user.getUserName();
    }
    
    @RequestMapping("/addUser5")
    @ResponseBody
    public User addUser5(User user) {
        log.info("userName is:"+user.getUserName());
        log.info("password is:"+user.getPassword());
        return user;
    }
    
    @RequestMapping("/addUser6")
    public void addUser6(User user,PrintWriter out) {
        log.info("userName is:"+user.getUserName());
        log.info("password is:"+user.getPassword());
        String json=null;
        /**
         * 使用Jackson
         */
        ObjectMapper map=new ObjectMapper();
        try {
			json=map.writeValueAsString(user);
			
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        log.info("使用Jackson:"+json);
        
        /**
         * 使用fastjson
         */
        json=JSON.toJSONString(user);
        log.info("使用fastjson:"+json);
        out.write(json);
        
    }
    
    
    
    @RequestMapping("redirect")
    public String redirectForm(){
    	
    	return "redirect:/welcome";
    }
    
    
} 