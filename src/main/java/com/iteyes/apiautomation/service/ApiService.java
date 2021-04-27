package com.iteyes.apiautomation.service;

import com.iteyes.apiautomation.domain.ApiManagerDTO;
import com.iteyes.apiautomation.domain.ParameterManagerDTO;

import java.util.List;

public interface ApiService {

    List<ApiManagerDTO> getApiList();

    List<ParameterManagerDTO> getParameterList(String apiId);
}
