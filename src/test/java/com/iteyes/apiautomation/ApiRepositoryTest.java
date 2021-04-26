package com.iteyes.apiautomation;

import com.iteyes.apiautomation.domain.ApiManagerDTO;
import com.iteyes.apiautomation.store.ApiManagerRepository;
import com.iteyes.apiautomation.store.entity.ApiManager;
import com.iteyes.apiautomation.store.jpa.ApiManagerRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApiRepositoryTest {

    ApiManagerRepository repository = new ApiManagerRepositoryImpl();

    @Test
    public void list() {
        List<ApiManager> result = repository.findAll();
        System.out.println(result);
    }

}
