package com.iteyes.apiautomation.store.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "COVID19_SEOUL_INFECTION_COUNT")
public class Covid19SeoulInfectionCount {


    @Id
    @Column(name = "S_DT")
    private String sDt;

    @Column(name = "S_HJ")
    private String sHj;

    @Column(name = "SN_HJ")
    private String snHj;

    @Column(name = "S_CARE")
    private String sCare;

    @Column(name = "S_RECOVER")
    private String sRecover;

    @Column(name = "SN_RECOVER")
    private String snRecover;

    @Column(name = "S_DEATH")
    private String sDeath;

    @Column(name = "SY_TOTAL")
    private String syTotal;

    @Column(name = "SY_KJ")
    private String syKj;

    @Column(name = "SY_KH")
    private String syKh;

    @Column(name = "T_DT")
    private String tDt;

    @Column(name = "T_HJ")
    private String tHj;

    @Column(name = "N_HJ")
    private String nHj;

    @Column(name = "TY_CARE")
    private String tyCare;

    @Column(name = "RECOVER")
    private String recover;

    @Column(name = "DEATH")
    private String death;

    @Column(name = "TY_TOTAL")
    private String tyTotal;

    @Column(name = "TY_KJ")
    private String tyKj;

    @Column(name = "TY_KH")
    private String tyKh;

    @Column(name = "JGK_OVERSEAS_GS")
    private String jgkOverseasGs;

    @Column(name = "JGK_OVERSEAS_GH")
    private String jgkOverseasGh;

    @Column(name = "JGK_CONT_GS")
    private String jgkContGs;

    @Column(name = "JGK_CONT_GH")
    private String jgkContGh;

    @Column(name = "CHECKING")
    private String checking;


}
