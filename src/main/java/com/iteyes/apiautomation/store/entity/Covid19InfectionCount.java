package com.iteyes.apiautomation.store.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@Data
@Table(name="COVID19_INFECTION_COUNT",schema = "API_TEST_DB")
public class Covid19InfectionCount {

    @Id
    @Column(name = "LOAD_TIME")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String loadTime;
}
