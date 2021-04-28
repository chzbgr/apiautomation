package com.iteyes.apiautomation.service.logic;

import com.iteyes.apiautomation.domain.ApiManagerDTO;
import com.iteyes.apiautomation.domain.ParameterManagerDTO;
import com.iteyes.apiautomation.domain.RequestFormDTO;
import com.iteyes.apiautomation.service.DataService;
import com.iteyes.apiautomation.store.ApiStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private ApiStore apiStore;

    @Override
    public List<ApiManagerDTO> getApiList() {
        return apiStore.findAllApiList();
    }

    @Override
    public List<ParameterManagerDTO> getParameterList(String apiId) {
        return apiStore.findAllParameterList(apiId);
    }


}
