package com.iteyes.apiautomation.store.repository;

import com.iteyes.apiautomation.store.entity.Covid19SeoulInfectionCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Covid19SeoulInfectionCountRepository extends JpaRepository<Covid19SeoulInfectionCount, String> {
}
