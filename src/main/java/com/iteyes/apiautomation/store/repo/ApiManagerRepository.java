package com.iteyes.apiautomation.store.repo;

import com.iteyes.apiautomation.store.entity.ApiManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApiManagerRepository extends JpaRepository<ApiManager,String> {

    @Query(value = "select SERVICE_KEY from API_MANAGER where API_ID = :apiId", nativeQuery = true)
    String findServiceKeyByApiId(@Param("apiId") String apiID);

    @Query(value = "select API_URL from API_MANAGER where API_ID = :apiId", nativeQuery = true)
    String findUrlByApiId(@Param("apiId") String apiID);



}
