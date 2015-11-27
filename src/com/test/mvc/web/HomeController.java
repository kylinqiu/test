package com.test.mvc.web;
 


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.*; 
import org.springframework.web.bind.annotation.*; 
import org.springframework.web.servlet.*; 

/** 
 * ����������Controllerע�� 
 */ 
@Controller 
public class HomeController { 

    /** 
     * ӳ�䵽/welcome 
     */ 
    @RequestMapping(value = "/welcome") 
    public ModelAndView welcome(){ 

         ModelAndView mv = new ModelAndView("MyJsp");     //ʹ��welcome.jsp�������д������urlĬ��Ҳ��welcome.jsp 
         mv.addObject("hello", "Hello");    //model������һ����Ϊhello���ַ��� 

         Client client = new Client(); 
         client.setName("User"); 
         mv.addObject("client", client);    //������һ����Ϊclient���Զ������ 

         return mv; 
    } 

    /** 
     * �������ҪModel��ֱ�ӷ�String���򵥣���Ӧ��viewΪlogin_page.jsp 
     */ 
    @RequestMapping(value = "/login") 
    public String login(){ 
        return "user/login_page"; 
    } 

    /** 
     * һ������json�ķ�������ResponseBody��ʶ 
     * ������url�ж�������У�ʵ��RESTful����̫���� 
     * ���κ������Դ�url��ȡ��Ҳ���Զ�����ͨ�� 
     */ 
    @RequestMapping(value="/client/{name}", method = RequestMethod.GET) 
    @ResponseBody 
    public Client getClient(@PathVariable String name, String title){ 
        Client client = new Client(); 
        client.setName(title+ " " + name); 

        return client; 
    } 
    
  
} 