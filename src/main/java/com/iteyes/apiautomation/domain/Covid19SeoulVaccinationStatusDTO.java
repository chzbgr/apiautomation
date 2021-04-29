package com.iteyes.apiautomation.domain;

import com.iteyes.apiautomation.store.entity.Covid19SeoulVaccinationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Covid19SeoulVaccinationStatusDTO {

    private String S_VC_DT;
    private String REG_DT;
    private String WORK_DTTM;
    private String S_1QT_FIR_SUB;
    private String S_1QT_FIR_INC;
    private String S_1QT_FIR_RATE;
    private String S_1QT_SCD_SUB;
    private String S_1QT_SCD_INC;
    private String S_1QT_SCD_RATE;
    private String S_2QT_FIR_SUB;
    private String S_2QT_FIR_INC;
    private String S_2QT_FIR_RATE;
    private String S_2QT_SCD_SUB;
    private String S_2QT_SCD_INC;
    private String S_2QT_SCD_RATE;
    private String S_3QT_FIR_SUB;
    private String S_3QT_FIR_INC;
    private String S_3QT_FIR_RATE;
    private String S_3QT_SCD_SUB;
    private String S_3QT_SCD_INC;
    private String S_3QT_SCD_RATE;
    private String S_4QT_FIR_SUB;
    private String S_4QT_FIR_INC;
    private String S_4QT_FIR_RATE;
    private String S_4QT_SCD_SUB;
    private String S_4QT_SCD_INC;
    private String S_4QT_SCD_RATE;
    private String S_1QT_FIR_ADD;
    private String S_1QT_SCD_ADD;
    private String S_2QT_FIR_ADD;
    private String S_2QT_SCD_ADD;
    private String S_3QT_FIR_ADD;
    private String S_3QT_SCD_ADD;
    private String S_4QT_FIR_ADD;
    private String S_4QT_SCD_ADD;

    /**
     * DTO 객체를 Entity 형태로 변환
     * @return entity
     */
    @Builder
    public Covid19SeoulVaccinationStatus toEntity() {
        return Covid19SeoulVaccinationStatus.builder()
                .sVcDt(S_VC_DT)
                .regDt(REG_DT)
                .workDttm(WORK_DTTM)
                .s1qtFirSub(S_1QT_FIR_SUB)
                .s1qtFirInc(S_1QT_FIR_INC)
                .s1qtFirRate(S_1QT_FIR_RATE)
                .s1qtScdSub(S_1QT_SCD_SUB)
                .s1qtScdInc(S_1QT_SCD_INC)
                .s1qtScdRate(S_1QT_SCD_RATE)
                .s2qtFirSub(S_2QT_FIR_SUB)
                .s2qtFirInc(S_2QT_FIR_INC)
                .s2qtFirRate(S_2QT_FIR_RATE)
                .s2qtScdSub(S_2QT_SCD_SUB)
                .s2qtScdInc(S_2QT_SCD_INC)
                .s2qtScdRate(S_2QT_SCD_RATE)
                .s3qtFirSub(S_3QT_FIR_SUB)
                .s3qtFirInc(S_3QT_FIR_INC)
                .s3qtFirRate(S_3QT_FIR_RATE)
                .s3qtScdSub(S_3QT_SCD_SUB)
                .s3qtScdInc(S_3QT_SCD_INC)
                .s3qtScdRate(S_3QT_SCD_RATE)
                .s4qtFirSub(S_4QT_FIR_SUB)
                .s4qtFirInc(S_4QT_FIR_INC)
                .s4qtFirRate(S_4QT_FIR_RATE)
                .s4qtScdSub(S_4QT_SCD_SUB)
                .s4qtScdInc(S_4QT_SCD_INC)
                .s4qtScdRate(S_4QT_SCD_RATE)
                .s1qtFirAdd(S_1QT_FIR_ADD)
                .s1qtScdAdd(S_1QT_SCD_ADD)
                .s2qtFirAdd(S_2QT_FIR_ADD)
                .s2qtScdAdd(S_2QT_SCD_ADD)
                .s3qtFirAdd(S_3QT_FIR_ADD)
                .s3qtScdAdd(S_3QT_SCD_ADD)
                .s4qtFirAdd(S_4QT_FIR_ADD)
                .s4qtScdAdd(S_4QT_SCD_ADD)
                .build();
    }
}
