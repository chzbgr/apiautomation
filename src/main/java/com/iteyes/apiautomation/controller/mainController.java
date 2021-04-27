package com.iteyes.apiautomation.controller;

import com.iteyes.apiautomation.dto.ParamCreateDto;
import com.iteyes.apiautomation.dto.ParameterManagerDto;
import com.iteyes.apiautomation.service.logic.ApiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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


    @RequestMapping(value="/main/api/callApi",method=RequestMethod.POST)
    public String callApi(Model model, ParamCreateDto dto) {
        Map<String, String> map = new HashMap<>();

        String[] key_arr = dto.getKeyArr().split(",");
        String[] val_arr = dto.getValArr().split(",");

        for (int i = 0; i < key_arr.length; i++) {
            map.put(key_arr[i], val_arr[i]);
        }

        System.out.println(map);
        model.addAttribute("preview",map);
        //mainService.getDataList(dto.getApiId(), map);
        return "api1";
    }
}





//    @RequestMapping(value="/main/api1",method=RequestMethod.POST)
//    public String readUrl(ParameterManagerDto dto,@RequestParam("param")){
//
//        return null;
//    }





