package com.iteyes.apiautomation.store;

import com.iteyes.apiautomation.domain.ApiManagerDTO;
import com.iteyes.apiautomation.domain.ParameterManagerDTO;

import java.util.List;

public interface ApiStore {

    List<ApiManagerDTO> findAllApiList();

    List<ParameterManagerDTO> findAllParameterList(String apiID);

    List<String> findParameterNameByApiId(String apiId);

    String findServiceKeyByApiId(String apiId);

    String findUrlByApiId(String apiId);

}
