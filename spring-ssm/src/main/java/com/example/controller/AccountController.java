package com.example.controller;

import com.example.domain.Account;
import com.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // 保存表单得到的数据，会自动装填到account
    @RequestMapping(value="/save", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String save(Account account){
        System.out.println("正在保存数据");
        accountService.save(account);
        return "保存成功";
    }

    // 查询
    @RequestMapping(value="/findAll")
    public ModelAndView findAll(){
        List<Account> accountList = accountService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("accountList", accountList);
        // SpringMVC会根据配置加上前后缀
        modelAndView.setViewName("accountList");
        return modelAndView;
    }
}
