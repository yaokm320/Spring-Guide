package com.example.controller;

import com.example.domain.User;
import com.example.domain.VO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.Array;
import java.util.Arrays;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {

    // SpringMVC数据相应：【页面跳转】，字符串形式
    @RequestMapping(value="/quick1", method = RequestMethod.GET)
    public String save1(){
        // 转发：直接给字符串，会拼接上前缀和后缀，这里是/jsp/success.jsp
        return "success";

        // 转发：前面有forward关键字，需要写全路径
        // return "forward:/jsp/success.jsp";

        // 重定向：需要加上redirect关键词，需要写全路径
        // return "redirect:/jsp/success.jsp";
    }

    // SpringMVC数据相应：【页面跳转】，ModelAndView形式
    @RequestMapping(value="/quick2")
    public ModelAndView save2(){
        /*
        Model: 封装模型
        View：展示视图
        * */
        ModelAndView modelAndView = new ModelAndView();
        // 增加模型数据
        modelAndView.addObject("username", "yaokm");
        // 设置视图名称
        modelAndView.setViewName("success2");
        return modelAndView;
    }

    // SpringMVC数据相应：【页面跳转】，ModelAndView形式
    // Model和View是结合在一起的
    @RequestMapping(value="/quick3")
    public ModelAndView save3(ModelAndView modelAndView){
        // 增加模型数据
        modelAndView.addObject("username", "yaokm");
        // 设置视图名称
        modelAndView.setViewName("success1");
        return modelAndView;
    }

    // SpringMVC数据相应：【页面跳转】，Model和字符串结合
    // Model和view是分开的，可以向Model里面增加数据，View通过字符串的形式返回
    @RequestMapping(value="/quick4")
    public String save4(Model model){
        model.addAttribute("username", "yaokm");
        return "success1";
    }

    // SpringMVC数据相应：【页面跳转】，请求域和字符串形式
    // 通过传统的方式，向请求域中添加数据，这里的Request对象是SpringMVC自动注入
    @RequestMapping(value="/quick5")
    public String save5(HttpServletRequest request){
        request.setAttribute("username", "yaokm");
        return "success1";
    }

    // SpringMVC数据相应：【回写数据】，直接返回字符串
    @RequestMapping(value="/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello world!");
    }

    // SpringMVC数据相应：【回写数据】，直接返回字符串
    @RequestMapping(value="/quick7")
    @ResponseBody               // 告诉Spring框架，不进行页面跳转，直接数据响应
    public String save7() throws IOException {
        return "hello world!";
    }

    // SpringMVC数据相应：【回写数据】，直接返回json格式的字符串
    @RequestMapping(value="/quick8")
    @ResponseBody               // 告诉Spring框架，不进行页面跳转，直接数据响应
    public String save8() throws IOException {
        return "{\"username\":\"yaokm\"}";      // 内部的字符串引号需要转意
    }

    // SpringMVC数据相应：【回写数据】，借助jackson工具返回json格式的字符串
    @RequestMapping(value="/quick9")
    @ResponseBody               // 告诉Spring框架，不进行页面跳转，直接数据响应
    public String save9() throws IOException {
        User user = new User();
        user.setUsername("Alice");
        user.setAge(20);
        // 使用jackson工具转化成json格式
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        return json;
    }

    // SpringMVC数据相应：【回写数据】，返回对象或集合，SpringMVC会使用RequestMappingHandlerAdapter自动转换
    @RequestMapping(value="/quick10")
    @ResponseBody               // 告诉Spring框架，不进行页面跳转，直接数据响应
    public User save10() throws IOException {
        User user = new User();
        user.setUsername("Alice");
        user.setAge(20);
        return user;
    }

    // SpringMVC获取请求数据【基本类型数据】
    @RequestMapping(value="/quick11")
    @ResponseBody               // 告诉Spring框架，不进行页面跳转
    public void save11(String username, int age){
        System.out.println(username);
        System.out.println(age);
    }

    // SpringMVC获取请求数据【POJO对象】
    @RequestMapping(value="/quick12")
    @ResponseBody               // 告诉Spring框架，不进行页面跳转
    public void save12(User user){
        System.out.println(user);
    }

    // SpringMVC获取请求数据【数组形式】http://localhost:8080/user/quick13?strList=zhang&strList=wang
    // 注意的是url里面的strList要和方法的参数名字相同，SpringMVC才能自动将其装填
    @RequestMapping(value="/quick13")
    @ResponseBody               // 告诉Spring框架，不进行页面跳转
    public void save13(String[] strList){
        System.out.println(Arrays.asList(strList));
    }

    // SpringMVC获取请求数据【集合形式】，一般使用表单的形式，
    @RequestMapping(value="/quick14")
    @ResponseBody               // 告诉Spring框架，不进行页面跳转
    public void save14(VO vo){
        System.out.println(vo);
    }

    // SpringMVC获取请求数据【基本类型】，使用@RequestParam注解进行页面参数与方法参数的映射，即页面的name会被映射给username
    @RequestMapping(value="/quick15")
    @ResponseBody                   // 告诉Spring框架，不进行页面跳转
    public void save15(@RequestParam("name") String username){
        System.out.println(username);
    }

    // SpringMVC获取请求数据【基本类型】，使用@RequestParam注解进行页面参数与方法参数的映射，即页面的name会被映射给username
    // localhost:8080/quick16/zhang
    @RequestMapping(value="/quick16/{username}")
    @ResponseBody                   // 告诉Spring框架，不进行页面跳转
    public void save16(@PathVariable(value = "username", required = true) String username){
        System.out.println(username);
    }

    // SpringMVC自定义类型转换器
    @RequestMapping(value="/quick17")
    @ResponseBody                   // 告诉Spring框架，不进行页面跳转
    public void save17(Date data){
        System.out.println(data);
    }

    // SpringMVC获取请求头， @RequestHeader
    @RequestMapping(value="/quick18")
    @ResponseBody                   // 告诉Spring框架，不进行页面跳转
    public void save18(@RequestHeader(value="User-Agent", required = false) String user_agent){
        System.out.println(user_agent);
    }

    // SpringMVC获取请求头， @CookieValue
    @RequestMapping(value="/quick19")
    @ResponseBody                   // 告诉Spring框架，不进行页面跳转
    public void save19(@CookieValue(value = "JSESSIONID") String cookie_id){
        System.out.println(cookie_id);
    }

    // SpringMVC获取请求头， @CookieValue
    @RequestMapping(value="/quick20")
    @ResponseBody                   // 告诉Spring框架，不进行页面跳转
    public void save20(String username, MultipartFile multipartFile) throws IOException {
        String originalFilename = multipartFile.getOriginalFilename();
        multipartFile.transferTo(new File("/Users/yaokaiming/Downloads/"+originalFilename));
    }
}