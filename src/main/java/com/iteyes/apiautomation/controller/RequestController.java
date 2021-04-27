package com.iteyes.apiautomation.controller;

import com.iteyes.apiautomation.domain.ApiManagerDTO;
import com.iteyes.apiautomation.domain.ParameterManagerDTO;
import com.iteyes.apiautomation.service.ApiService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@Log4j2
public class RequestController {

    @Autowired
    private final ApiService apiService;

    public RequestController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/apiRequest")
    public String apiRequest(@RequestParam("apiId") String apiId, Model model) {
        List<ParameterManagerDTO> parameterList = apiService.getParameterList(apiId);
        model.addAttribute("parameterList", parameterList);
        log.info(parameterList);
        return "apiRequest";
    }


}
