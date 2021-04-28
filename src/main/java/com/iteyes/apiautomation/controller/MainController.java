package com.iteyes.apiautomation.controller;

import com.iteyes.apiautomation.domain.ApiManagerDTO;
import com.iteyes.apiautomation.domain.ParameterManagerDTO;
import com.iteyes.apiautomation.service.ApiService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Log4j2
public class MainController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/apiList")
    public String list(Model model) {
        List<ApiManagerDTO> apiList = apiService.getApiList();
        model.addAttribute("apiList", apiList);
        return "main";
    }

    @GetMapping("/parameterList")
    public String apiCallRequest(@RequestParam("apiId") String apiId, Model model) {
        List<ParameterManagerDTO> parameterList = apiService.getParameterList(apiId);
        model.addAttribute("parameterList", parameterList);
        model.addAttribute("apiId", apiId);
        log.info(parameterList);
        return "apiRequest";
    }

    @PostMapping("/apiSaveResult")
    public String saveRequest(@RequestParam(value = "parameterValue", required = true) List<String> parameterValue,
                              @RequestParam(value = "apiId") String apiId, Model model) {

        try {
            String message = apiService.saveJson(apiId, parameterValue);
            model.addAttribute("resultMessage", message);
            log.info("====================적재 성공=========================");
        } catch (Exception e) {
            model.addAttribute("resultMessage", e.getMessage());
            log.info("====================적재 fail=========================");
        }

        return "apiSaveResult";
    }

}
