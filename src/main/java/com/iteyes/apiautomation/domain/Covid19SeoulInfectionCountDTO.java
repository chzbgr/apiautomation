package com.iteyes.apiautomation.domain;

import com.iteyes.apiautomation.store.entity.Covid19SeoulInfectionCount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Covid19SeoulInfectionCountDTO {

    private String S_DT;
    private String S_HJ;
    private String SN_HJ;
    private String S_CARE;
    private String S_RECOVER;
    private String SN_RECOVER;
    private String S_DEATH;
    private String SY_TOTAL;
    private String SY_KJ;
    private String SY_KH;
    private String T_DT;
    private String T_HJ;
    private String N_HJ;
    private String TY_CARE;
    private String RECOVER;
    private String DEATH;
    private String TY_TOTAL;
    private String TY_KJ;
    private String TY_KH;
    private String JGK_OVERSEAS_GS;
    private String JGK_OVERSEAS_GH;
    private String JGK_CONT_GS;
    private String JGK_CONT_GH;
    private String CHECKING;
    @Builder
    public Covid19SeoulInfectionCount toEntity() {
        return Covid19SeoulInfectionCount.builder()
                .sDt(S_DT)
                .sHj(S_HJ)
                .snHj(SN_HJ)
                .sCare(S_CARE)
                .sRecover(S_RECOVER)
                .snRecover(SN_RECOVER)
                .sDeath(S_DEATH)
                .syTotal(SY_TOTAL)
                .syKj(SY_KJ)
                .syKh(SY_KH)
                .tDt(T_DT)
                .tHj(T_HJ)
                .nHj(N_HJ)
                .tyCare(TY_CARE)
                .recover(RECOVER)
                .death(DEATH)
                .tyTotal(TY_TOTAL)
                .tyKj(TY_KJ)
                .tyKh(TY_KH)
                .jgkOverseasGs(JGK_OVERSEAS_GS)
                .jgkOverseasGh(JGK_OVERSEAS_GH)
                .jgkContGs(JGK_CONT_GS)
                .jgkContGh(JGK_CONT_GH)
                .checking(CHECKING)
                .build();
    }

}
