
package com.iteyes.apiautomation.store;

import com.iteyes.apiautomation.domain.ApiManagerDTO;
import com.iteyes.apiautomation.domain.ParameterManagerDTO;

import java.util.List;

public interface ApiStore {

    List<ApiManagerDTO> findAllApiList();
    List<ParameterManagerDTO> findAllParameterList(String apiId);

}