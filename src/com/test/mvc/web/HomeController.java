package com.test.mvc.web;
 


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.*; 
import org.springframework.web.bind.annotation.*; 
import org.springframework.web.servlet.*; 

/** 
 * 控制器，用Controller注解 
 */ 
@Controller 
public class HomeController { 

    /** 
     * 映射到/welcome 
     */ 
    @RequestMapping(value = "/welcome") 
    public ModelAndView welcome(){ 

         ModelAndView mv = new ModelAndView("MyJsp");     //使用welcome.jsp，如果不写，根据url默认也是welcome.jsp 
         mv.addObject("hello", "Hello");    //model中增加一个名为hello的字符串 

         Client client = new Client(); 
         client.setName("User"); 
         mv.addObject("client", client);    //再增加一个名为client的自定义对象 

         return mv; 
    } 

    /** 
     * 如果不需要Model，直接返String更简单，对应的view为login_page.jsp 
     */ 
    @RequestMapping(value = "/login") 
    public String login(){ 
        return "user/login_page"; 
    } 

    /** 
     * 一个返回json的方法，用ResponseBody标识 
     * 可以在url中定义参数中，实现RESTful真是太简单了 
     * 传参很灵活，可以从url中取，也可以定义普通的 
     */ 
    @RequestMapping(value="/client/{name}", method = RequestMethod.GET) 
    @ResponseBody 
    public Client getClient(@PathVariable String name, String title){ 
        Client client = new Client(); 
        client.setName(title+ " " + name); 

        return client; 
    } 
    
  
} 