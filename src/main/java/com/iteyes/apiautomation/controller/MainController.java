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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author eunju Kang
 */
@Controller
@Log4j2
public class MainController {

    @Autowired
    private ApiService apiService;

    /**
     * 첫 화면 Api 목록
     * @param model api 이름 목록을 화면에 전달
     * @return main 첫 화면 html
     */
    @GetMapping("/apiList")
    public String list(Model model) {
        List<ApiManagerDTO> apiList = apiService.getApiList();
        model.addAttribute("apiList", apiList);
        return "main";
    }

    /**
     * api의 요청 변수 목록
     * @param apiId 첫 화면에서 선택한 api의 Id값 전달
     * @param model 요청 변수 목록을 화면에 전달
     * @return apiRequest api 요청하는 화면(변수 목록)
     */
    @GetMapping("/parameterList")
    public String apiCallRequest(@RequestParam("apiId") String apiId, Model model) {
        List<ParameterManagerDTO> parameterList = apiService.getParameterList(apiId);
        model.addAttribute("parameterList", parameterList);
        model.addAttribute("apiId", apiId);
        return "apiRequest";
    }

    /**
     * api 요청 결과 미리보기 제공
     * @param parameterValue 요청변수 입력 값
     * @param apiId
     * @param model 미리보기 결과 code, message 전달
     * @return preview html
     * @throws Exception
     */
    @PostMapping("/preview")
    public String previewRequest(@RequestParam(value = "parameterValue", required = true) List<String> parameterValue,
                                 @RequestParam(value = "apiId") String apiId, Model model) throws Exception {

        List<String> previewList = apiService.previewJson(apiId, parameterValue);
        model.addAttribute("resultCode", previewList.get(0));
        model.addAttribute("resultMessage", previewList.get(1));
        return "preview";
    }

    /**
     * api 호출 결과 파싱하여 DB저장
     * @param parameterValue 요청변수 입력 값
     * @param apiId
     * @param model 적재 결과 message 전달
     * @return apiSaveResult html
     */
    @PostMapping("/apiSaveResult")
    public String saveRequest(@RequestParam(value = "parameterValue", required = true) List<String> parameterValue,
                              @RequestParam(value = "apiId") String apiId, Model model) {

        try {
            String message = apiService.saveJson(apiId, parameterValue);
            model.addAttribute("resultMessage", message);
        } catch (Exception e) {
            model.addAttribute("resultMessage", e.getMessage());
        }
        return "apiSaveResult";
    }

}
