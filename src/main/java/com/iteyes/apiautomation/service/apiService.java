package com.iteyes.apiautomation.service;

import com.iteyes.apiautomation.dto.ApiManagerDto;

import com.iteyes.apiautomation.dto.ParameterManagerDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mainRepo")
public interface apiService {

     List<ApiManagerDto> findApiList();

     List<ParameterManagerDto> findParamList();


}
