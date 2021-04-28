package com.iteyes.apiautomation.store.repository;

import com.iteyes.apiautomation.store.entity.ParameterManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParameterManagerRepository extends JpaRepository<ParameterManager, String> {
    List<ParameterManager> findAllByApiId(String apiID);
}
