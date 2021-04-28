
package com.iteyes.apiautomation.controller;

import com.iteyes.apiautomation.domain.ApiManagerDTO;
import com.iteyes.apiautomation.domain.ParamCreateDTO;
import com.iteyes.apiautomation.domain.ParameterManagerDTO;
import com.iteyes.apiautomation.service.ApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Log4j2
public class MainController {

    @Autowired
    private ApiService apiService;

//    @Autowired
//    private ApiManagerRepository apiManagerRepository;

    @GetMapping("/")
    public String list(Model model) {
        List<ApiManagerDTO> apiList = apiService.getApiList();
        model.addAttribute("apiList", apiList);
        return "main";
    }

    @GetMapping("/apiRequest")
    public String apiRequest(@RequestParam("apiId") String apiId, Model model) {
        List<ParameterManagerDTO> parameterList = apiService.getParameterList(apiId);
        model.addAttribute("parameterList", parameterList);
        log.info(parameterList);
        return "detail";
    }

    @PostMapping("/apiRequest/callApi")
    public String callApi(Model model, ParamCreateDTO dto) {
        Map<String, String> map = new HashMap<>();

        String[] key_arr = dto.getKeyArr().split(","); // key array , 바탕으로 split
        String[] val_arr = dto.getValArr().split(","); // value array , 바탕으로 split

        for(int i = 0; i < key_arr.length; i++) {
            map.put(key_arr[i], val_arr[i]);
        }

        System.out.println(map);
        model.addAttribute("preview",map);
        //mainService.getDataList(dto.getApiId(), map);

        return "preview";
    }



    @RequestMapping("/api/callApi")
    public String callApi(Model model, @RequestParam(value="apiId") String apiId,
                          @RequestParam(value="keyArr") List<String> keyArr,
                          @RequestParam(value="valueArr") List<String> valueArr) {
        System.out.println(apiId);
        System.out.println(keyArr.toString());
        System.out.println(valueArr.toString());
//        System.out.println(keyArr.toString());
//        System.out.println(valueArr.toString());
        return "main";
    }

}


