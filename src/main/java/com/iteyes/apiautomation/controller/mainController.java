package com.iteyes.apiautomation.controller;

import com.iteyes.apiautomation.dto.ParameterManagerDto;
import com.iteyes.apiautomation.service.logic.ApiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("")
public class mainController {

    @Autowired
    private ApiServiceImpl apiService;


    @RequestMapping("main")
    public String getApiList(Model model) {

        model.addAttribute("alist", apiService.findApiList());

        return "main";

    }

    @RequestMapping(value = "/main/api1", method = RequestMethod.GET)
    public String getParamList(Model model) {

        List<ParameterManagerDto> list = apiService.findParamList();
        model.addAttribute("plist", list);
        return "api1";
    }


    @PostMapping("/main/api1")
    public String callApi(Model model,
                          @RequestParam(value="keyArr") List<String> keyArr,
                          @RequestParam(value="valueArr") List<String> valueArr) {

        System.out.println(keyArr.toString());
        System.out.println(valueArr.toString());

        Map<String, String> map = new HashMap<>();

        for(int i = 0; i < keyArr.size(); i++) {
            map.put(keyArr.get(i), keyArr.get(i));
        }

        model.addAttribute("preview",map);
        return "preview";
    }
}





//    @RequestMapping(value="/main/api1",method=RequestMethod.POST)
//    public String readUrl(ParameterManagerDto dto,@RequestParam("param")){
//
//        return null;
//    }





