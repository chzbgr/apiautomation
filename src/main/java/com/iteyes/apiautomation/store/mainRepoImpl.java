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
        return parameterManagerRepository.findAll().stream().map(ParameterManagerDto::new).collect(Collectors.toList());
    }
}
