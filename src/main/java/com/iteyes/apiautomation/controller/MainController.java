package com.iteyes.apiautomation.controller;

import com.iteyes.apiautomation.domain.ApiManagerDTO;
import com.iteyes.apiautomation.service.DataService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Log4j2
public class MainController {

    @Autowired
    private DataService dataService;


    @GetMapping("/main")
    public String list(Model model) {
        List<ApiManagerDTO> apiList = dataService.getApiList();
        model.addAttribute("apiList", apiList);
        return "main";
    }
}
