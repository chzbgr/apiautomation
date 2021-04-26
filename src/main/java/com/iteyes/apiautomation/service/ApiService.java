package com.iteyes.apiautomation.service;

import com.iteyes.apiautomation.domain.ApiManagerDTO;

import java.util.List;

public interface ApiService {

    List<ApiManagerDTO> getApiList();
}
