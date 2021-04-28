package com.iteyes.apiautomation.controller;

import com.iteyes.apiautomation.domain.ParameterManagerDTO;
import com.iteyes.apiautomation.domain.RequestFormDTO;
import com.iteyes.apiautomation.service.DataService;
import com.iteyes.apiautomation.service.RequestService;
import lombok.extern.log4j.Log4j2;
import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.URL;
import java.util.List;

@Controller
@Log4j2
public class RequestController {

    @Autowired
    private DataService dataService;

    @Autowired
    private RequestService requestService;


    @GetMapping("/apiRequest")
    public String apiRequest(@RequestParam("apiId") String apiId, Model model) {
        List<ParameterManagerDTO> parameterList = dataService.getParameterList(apiId);
        model.addAttribute("parameterList", parameterList);
        model.addAttribute("apiId", apiId);
        log.info(parameterList);
        return "apiRequest";
    }

    @RequestMapping("/parameterRequest")
    public String parameterRequest(@RequestParam(value = "parameterValue", required = true) List<String> parameterValue, @RequestParam(value = "apiId") String apiId, Model model) throws IOException, JSONException {
        List<String> previewMessage = requestService.showPreview(apiId, parameterValue);
        model.addAttribute("previewMessage", previewMessage);
        return "preview";


    }


}
