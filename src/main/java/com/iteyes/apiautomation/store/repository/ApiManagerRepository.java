package com.iteyes.apiautomation.store.repository;


import com.iteyes.apiautomation.store.entity.ApiManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiManagerRepository extends JpaRepository<ApiManager,String> {
}
