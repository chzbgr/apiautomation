package com.iteyes.apiautomation.service.logic;

import com.iteyes.apiautomation.domain.ApiManagerDTO;
import com.iteyes.apiautomation.domain.ParameterManagerDTO;
import com.iteyes.apiautomation.service.ApiService;
import com.iteyes.apiautomation.store.ApiStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    @Autowired
    private ApiStore apiStore;

    public ApiServiceImpl(ApiStore apiStore) {
        this.apiStore = apiStore;
    }

    @Override
    public List<ApiManagerDTO> getApiList() {
        return apiStore.findAllApiList();
    }

    @Override
    public List<ParameterManagerDTO> getParameterList(String apiId) {
        return apiStore.findAllParameterList(apiId);
    }
}
