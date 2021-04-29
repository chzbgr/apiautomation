package com.iteyes.apiautomation.service.logic;
import com.iteyes.apiautomation.dto.ApiManagerDto;
import com.iteyes.apiautomation.dto.ParameterManagerDto;
import com.iteyes.apiautomation.service.apiService;
import com.iteyes.apiautomation.store.mainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ApiServiceImpl implements apiService {

    @Autowired
    public mainRepo mainrepo;

    @Override
    public List<ApiManagerDto> findApiList() {
        return mainrepo.findAllApiList();
    }

    @Override
    public List<ParameterManagerDto> findParamList(String apiId) {
        return mainrepo.findAllParamList(apiId);

    }


}