package com.iteyes.apiautomation.store;

import com.iteyes.apiautomation.domain.ApiManagerDTO;
import com.iteyes.apiautomation.domain.ParameterManagerDTO;
import com.iteyes.apiautomation.store.repository.ApiManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ApiJpaStore implements ApiStore{

    @Autowired
    private ApiManagerRepository apiManagerRepository;

//    @Autowired
//    private ParameterManagerRepository parameterManagerRepository;


    @Override
    public List<ApiManagerDTO> findAllApiList() {
        return apiManagerRepository.findAll().stream().map(ApiManagerDTO::new).collect(Collectors.toList());
    }

//    @Override
//    public List<ParameterManagerDTO> findAllParameterList() {
//        return null;
//    }
}
