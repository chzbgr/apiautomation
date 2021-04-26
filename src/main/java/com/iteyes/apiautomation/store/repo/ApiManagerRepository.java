package com.iteyes.apiautomation.store.repo;

import com.iteyes.apiautomation.store.entity.ApiManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiManagerRepository extends JpaRepository<ApiManager,String> {

    //List<String> findAll(String data);
}
