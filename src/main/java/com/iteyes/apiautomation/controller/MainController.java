package com.iteyes.apiautomation.controller;

import com.iteyes.apiautomation.domain.ApiManagerDTO;
import com.iteyes.apiautomation.service.ApiService;
import com.iteyes.apiautomation.store.ApiManagerRepository;
import com.iteyes.apiautomation.store.entity.ApiManager;
import com.iteyes.apiautomation.store.jpa.ApiManagerRepositoryImpl;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Log4j2
public class MainController {


    @Autowired
    private ApiService apiService;

//    @Autowired
//    private ApiManagerRepository apiManagerRepository;

    @GetMapping("/main")
    public String list(Model model) {
//        List<ApiManagerDTO> apiList = apiService.findAllApiList();
//        log.info(apiList);
//        return "main";
//
        return "main";
    }
}
