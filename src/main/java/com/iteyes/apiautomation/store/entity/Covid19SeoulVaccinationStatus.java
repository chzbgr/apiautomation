package com.iteyes.apiautomation.store.entity;


import com.iteyes.apiautomation.store.entity.key.Covid19SeoulVaccinationStatusKey;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "COVID19_SEOUL_VACCINATION_STATUS")
@IdClass(Covid19SeoulVaccinationStatusKey.class)
public class Covid19SeoulVaccinationStatus {

    @Id
    @Column(name = "S_VC_DT")
    private String sVcDt;

    @Id
    @Column(name = "REG_DT")
    private String regDt;

    @Id
    @Column(name = "WORK_DTTM")
    private String workDttm;

    @Column(name = "S_1QT_FIR_SUB")
    private String s1qtFirSub;

    @Column(name = "S_1QT_FIR_INC")
    private String s1qtFirInc;

    @Column(name = "S_1QT_FIR_RATE")
    private String s1qtFirRate;

    @Column(name = "S_1QT_SCD_SUB")
    private String s1qtScdSub;

    @Column(name = "S_1QT_SCD_INC")
    private String s1qtScdInc;

    @Column(name = "S_1QT_SCD_RATE")
    private String s1qtScdRate;

    @Column(name = "S_2QT_FIR_SUB")
    private String s2qtFirSub;

    @Column(name = "S_2QT_FIR_INC")
    private String s2qtFirInc;

    @Column(name = "S_2QT_FIR_RATE")
    private String s2qtFirRate;

    @Column(name = "S_2QT_SCD_SUB")
    private String s2qtScdSub;

    @Column(name = "S_2QT_SCD_INC")
    private String s2qtScdInc;

    @Column(name = "S_2QT_SCD_RATE")
    private String s2qtScdRate;

    @Column(name = "S_3QT_FIR_SUB")
    private String s3qtFirSub;

    @Column(name = "S_3QT_FIR_INC")
    private String s3qtFirInc;

    @Column(name = "S_3QT_FIR_RATE")
    private String s3qtFirRate;

    @Column(name = "S_3QT_SCD_SUB")
    private String s3qtScdSub;

    @Column(name = "S_3QT_SCD_INC")
    private String s3qtScdInc;

    @Column(name = "S_3QT_SCD_RATE")
    private String s3qtScdRate;

    @Column(name = "S_4QT_FIR_SUB")
    private String s4qtFirSub;

    @Column(name = "S_4QT_FIR_INC")
    private String s4qtFirInc;

    @Column(name = "S_4QT_FIR_RATE")
    private String s4qtFirRate;

    @Column(name = "S_4QT_SCD_SUB")
    private String s4qtScdSub;

    @Column(name = "S_4QT_SCD_INC")
    private String s4qtScdInc;

    @Column(name = "S_4QT_SCD_RATE")
    private String s4qtScdRate;

    @Column(name = "S_1QT_FIR_ADD")
    private String s1qtFirAdd;

    @Column(name = "S_1QT_SCD_ADD")
    private String s1qtScdAdd;

    @Column(name = "S_2QT_FIR_ADD")
    private String s2qtFirAdd;

    @Column(name = "S_2QT_SCD_ADD")
    private String s2qtScdAdd;

    @Column(name = "S_3QT_FIR_ADD")
    private String s3qtFirAdd;

    @Column(name = "S_3QT_SCD_ADD")
    private String s3qtScdAdd;

    @Column(name = "S_4QT_FIR_ADD")
    private String s4qtFirAdd;

    @Column(name = "S_4QT_SCD_ADD")
    private String s4qtScdAdd;
}
