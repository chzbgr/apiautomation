package com.iteyes.apiautomation.store;

import com.iteyes.apiautomation.dto.ApiManagerDto;
import com.iteyes.apiautomation.dto.ParameterManagerDto;
import com.iteyes.apiautomation.store.repo.ApiManagerRepository;

import com.iteyes.apiautomation.store.repo.ParameterManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;


@Repository
public class mainRepoImpl implements  mainRepo{

    @Autowired
    private ApiManagerRepository apiManagerRepository;


    @Autowired
    private ParameterManagerRepository parameterManagerRepository;

    @Override
    public List<ApiManagerDto> findAllApiList(){
        return apiManagerRepository.findAll().stream().map(ApiManagerDto::new).collect(Collectors.toList());
    }

    @Override
    public List<ParameterManagerDto> findAllParamList(){
        List<ParameterManagerDto> parameterManagerDtoList = parameterManagerRepository.findAllByApiId("api1").stream().map(ParameterManagerDto::new).collect(Collectors.toList());

        return parameterManagerDtoList;
    }

    @Override
    public List<String> findParameterNameByApiId(String apiId){
        return parameterManagerRepository.findParameterNameByApiId(apiId);
    }

    @Override
    public String findServiceKeyByApiId(String apiId){
        return apiManagerRepository.findServiceKeyByApiId(apiId);
    }

    @Override
    public String findUrlByApiId(String apiId){
        return apiManagerRepository.findUrlByApiId(apiId);
    }

}
