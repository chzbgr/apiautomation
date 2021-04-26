package com.iteyes.apiautomation.store;

import com.iteyes.apiautomation.dto.ApiManagerDto;
import com.iteyes.apiautomation.dto.ParameterManagerDto;

import java.util.List;

public interface mainRepo {

    List<ApiManagerDto> findAllApiList();

    List<ParameterManagerDto> findAllParamList();

}
