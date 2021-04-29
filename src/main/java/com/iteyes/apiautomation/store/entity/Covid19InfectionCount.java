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

    @Column
    private String accDefRate;

    @Column
    private String accExamCnt;

    @Column
    private String accExamCompCnt;

    @Column
    private String careCnt;

    @Column
    private String clearCnt;

    @Column
    private String createDt;

    @Column
    private String deathCnt;

    @Column
    private String decideCnt;

    @Column
    private String examCnt;

    @Column
    private String resutlNegCnt;

    @Column
    private String seq;

    @Column
    private String stateDt;

    @Column
    private String stateTime;

    @Column
    private String updateDt;

}
