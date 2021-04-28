package com.iteyes.apiautomation.controller;

import com.iteyes.apiautomation.dto.ApiManagerDto;
import com.iteyes.apiautomation.dto.ParameterManagerDto;
import com.iteyes.apiautomation.service.logic.ApiServiceImpl;
import com.iteyes.apiautomation.service.logic.UrlCreateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("")
public class mainController {

    @Autowired
    private ApiServiceImpl apiService;

    @Autowired
    private UrlCreateServiceImpl urlCreateService;

    @RequestMapping("main")
    public String getApiList(Model model) {

        model.addAttribute("alist", apiService.findApiList());

        return "main";
    }

    @RequestMapping(value = "/main/api1", method = RequestMethod.GET)
    public String getParamList(Model model) {

        List<ParameterManagerDto> list = apiService.findParamList();
        model.addAttribute("plist", list);

        List<ApiManagerDto> alist = apiService.findApiList();

        model.addAttribute("alist",alist);

        return "api1";
    }

    @RequestMapping(value="/main/api1",method=RequestMethod.POST)
    public String callApi(@RequestParam(value="apiId")String apiId,Model model,@RequestParam(value="keyArr") List<String> keyArr, @RequestParam(value="valueArr") List<String> valueArr)throws Exception {

        List<String> apiPreview = urlCreateService.showPreview(apiId,keyArr,valueArr);
        model.addAttribute("a",apiPreview);
        return "preview";
    }

}





//    @RequestMapping(value="/main/api1",method=RequestMethod.POST)
//    public String readUrl(ParameterManagerDto dto,@RequestParam("param")){
//
//        return null;
//    }





