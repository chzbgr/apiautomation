package com.iteyes.apiautomation.store;

import com.iteyes.apiautomation.store.entity.ApiManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ApiManagerRepository extends JpaRepository<ApiManager, String> {
}
