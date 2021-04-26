package com.iteyes.apiautomation.controller;

import com.iteyes.apiautomation.dto.ApiManagerDto;
import com.iteyes.apiautomation.service.logic.ApiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class mainController {

    @Autowired
    private ApiServiceImpl apiService;

    @GetMapping (value="/main")
    public String getapiList(Model model){

        model.addAttribute("alist",apiService.findApiList());

        return "main";

    }


}
