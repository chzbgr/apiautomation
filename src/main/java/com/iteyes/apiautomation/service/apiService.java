package com.iteyes.apiautomation.service;

import com.iteyes.apiautomation.dto.ApiManagerDto;
import com.iteyes.apiautomation.dto.ParameterManagerDto;
import com.iteyes.apiautomation.store.entity.ApiManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ApiManagerRepository")
public interface apiService {

    public List<ApiManagerDto> findApiList();

    public List<ParameterManagerDto> findParamList();
}
