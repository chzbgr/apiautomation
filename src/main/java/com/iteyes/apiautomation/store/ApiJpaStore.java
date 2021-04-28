package com.iteyes.apiautomation.store;

import com.iteyes.apiautomation.domain.ApiManagerDTO;
import com.iteyes.apiautomation.domain.ParameterManagerDTO;
import com.iteyes.apiautomation.store.repository.ApiManagerRepository;
import com.iteyes.apiautomation.store.repository.ParameterManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ApiJpaStore implements ApiStore{

    @Autowired
    private ApiManagerRepository apiManagerRepository;

    @Autowired
    private ParameterManagerRepository parameterManagerRepository;

    public ApiJpaStore(ApiManagerRepository apiManagerRepository, ParameterManagerRepository parameterManagerRepository) {
        this.apiManagerRepository = apiManagerRepository;
        this.parameterManagerRepository = parameterManagerRepository;
    }

    @Override
    public List<ApiManagerDTO> findAllApiList() {
        return apiManagerRepository.findAll().stream().map(ApiManagerDTO::new).collect(Collectors.toList());
        // [[a],[b]] >>> [a,b]
    }

    @Override
    public List<ParameterManagerDTO> findAllParameterList(String apiID) {
        return parameterManagerRepository.findAllByApiId(apiID).stream().map(ParameterManagerDTO::new).collect(Collectors.toList());
    }
}