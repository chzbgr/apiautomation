package com.iteyes.apiautomation.controller;

import com.iteyes.apiautomation.dto.ApiManagerDto;
import com.iteyes.apiautomation.service.logic.ApiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/main")
public class mainController {

    @Autowired
    private ApiServiceImpl apiService;

    @RequestMapping("")
    public String getApiList(Model model){

        model.addAttribute("alist",apiService.findApiList());

        return "main";

    }

    @GetMapping (value="/api1")
    public String getParamList(Model model) {

        model.addAttribute("plist",apiService.findParamList());

        return "api1";
    }


}
