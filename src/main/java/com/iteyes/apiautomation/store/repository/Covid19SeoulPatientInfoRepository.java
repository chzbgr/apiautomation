package com.iteyes.apiautomation.store.repository;

import com.iteyes.apiautomation.store.entity.Covid19SeoulPatientInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Covid19SeoulPatientInfoRepository extends JpaRepository<Covid19SeoulPatientInfo, String> {
}
