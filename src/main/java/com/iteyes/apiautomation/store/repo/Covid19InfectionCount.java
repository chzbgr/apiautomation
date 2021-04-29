package com.iteyes.apiautomation.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Covid19InfectionCount extends JpaRepository<Covid19InfectionCount,String> {

    List<String> save();

}
