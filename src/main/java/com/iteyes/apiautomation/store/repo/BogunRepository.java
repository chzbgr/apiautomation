package com.iteyes.apiautomation.store.repo;

import com.iteyes.apiautomation.store.entity.Covid19InfectionCount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BogunRepository extends JpaRepository<Covid19InfectionCount,String> {
}
