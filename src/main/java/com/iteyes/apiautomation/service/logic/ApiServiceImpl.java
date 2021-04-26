package com.iteyes.apiautomation.service.logic;

import com.iteyes.apiautomation.domain.ApiManagerDTO;
import com.iteyes.apiautomation.service.ApiService;
import com.iteyes.apiautomation.store.ApiManagerRepository;
import com.iteyes.apiautomation.store.entity.ApiManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    @Autowired
    private ApiManagerRepository apiManagerRepository;


    @Override
    public ArrayList findAllApiList() {
        List<ApiManager> apis = apiManagerRepository.findAll();
        List<ApiManagerDTO> apiList = new ArrayList<>();

        for (int i=0; i<apis.size(); i++) {
            ApiManagerDTO api = new ApiManagerDTO();
            api.setApiId(apis.get(i).getApiId());
            api.setApiUrl(apis.get(i).getApiUrl());
            api.setApiName(apis.get(i).getApiName());
            api.setServiceKey(apis.get(i).getServiceKey());
            apiList.add(api);
        }

        return (ArrayList) apiList;

    }
}
