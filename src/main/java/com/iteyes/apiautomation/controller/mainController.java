package com.iteyes.apiautomation.controller;

import com.iteyes.apiautomation.dto.ApiManagerDto;
import com.iteyes.apiautomation.dto.ParameterManagerDto;
import com.iteyes.apiautomation.service.logic.ApiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
@RequestMapping("")
public class mainController {

    @Autowired
    private ApiServiceImpl apiService;

    @RequestMapping("main")
    public String getApiList(Model model){

        model.addAttribute("alist",apiService.findApiList());

        return "main";

    }

    @RequestMapping (value="/main/api1",method= RequestMethod.GET)
    public String getParamList(Model model) {

        System.out.println("----------------------------------------------------------");
        List<ParameterManagerDto> list = apiService.findParamList();


        model.addAttribute("plist", list);

//        return null;
        return "api1";
    }


}
