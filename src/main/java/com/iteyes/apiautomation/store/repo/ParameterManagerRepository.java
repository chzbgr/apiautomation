package com.iteyes.apiautomation.store.repo;


import com.iteyes.apiautomation.store.entity.ParameterManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParameterManagerRepository extends JpaRepository<ParameterManager,String> {
    List<ParameterManager> findAllByApiId(String apiId);

    @Query(value = "select PARAMETER_NAME from PARAMETER_MANAGER where API_ID = :apiId", nativeQuery = true)
    List<String> findParameterNameByApiId(@Param("apiId") String apiID);
}
