package com.iteyes.apiautomation.service;

import com.iteyes.apiautomation.domain.ApiManagerDTO;
import com.iteyes.apiautomation.domain.ParameterManagerDTO;
import com.iteyes.apiautomation.domain.RequestFormDTO;

import java.util.List;

public interface DataService {

    List<ApiManagerDTO> getApiList();

    List<ParameterManagerDTO> getParameterList(String apiId);

}
