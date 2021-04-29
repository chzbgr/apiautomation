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

        List<ApiManagerDto> alist =apiService.findApiList();

        model.addAttribute("alist", alist);

        return "main";
    }

    @RequestMapping( value = "/main/{apiId}", method = RequestMethod.GET)
    public String getParamList( Model model,@PathVariable(name="apiId") String apiId) {

        List<ParameterManagerDto> list = apiService.findParamList(apiId);

        model.addAttribute("plist", list);

      //  model.addAttribute("apiId",apiId);

        return "api1";
    }

    @RequestMapping(value="/main/api1",method=RequestMethod.POST)
    public String callApi(@RequestParam(value="apiId")String apiId,Model model,@RequestParam(value="keyArr") List<String> keyArr, @RequestParam(value="valueArr") List<String> valueArr)throws Exception {
        System.out.println("넘어온 controller의 apiid는:"+apiId);
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





