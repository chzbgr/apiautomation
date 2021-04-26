package com.iteyes.apiautomation.service.logic;

import com.iteyes.apiautomation.dto.ApiManagerDto;
import com.iteyes.apiautomation.dto.ParameterManagerDto;
import com.iteyes.apiautomation.service.apiService;
import com.iteyes.apiautomation.store.mainRepo;
import com.iteyes.apiautomation.store.repo.ApiManagerRepository;
import com.iteyes.apiautomation.store.entity.ApiManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiServiceImpl implements apiService {

    @Autowired
    public final mainRepo mainrepo;


    public ApiServiceImpl(mainRepo mainrepo){
        this.mainrepo =mainrepo;

    }


    @Override
    public List<ApiManagerDto> findApiList() {
        return mainrepo.findAllApiList();
    }

    @Override
    public List<ParameterManagerDto> findParamList(){
        return mainrepo.findAllParamList();
    }


}

        //  @Override
        //  public List<String> findAlldjWjrnwjWjrn() {
        //     storeExample.findAll(data);
        //    return null;


