package com.iteyes.apiautomation.domain;

import com.iteyes.apiautomation.store.entity.Covid19SeoulInfectionRegionCount;
import com.iteyes.apiautomation.store.entity.Covid19SeoulPatientInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Covid19SeoulInfectionRegionCountDTO {

    private String JCG_DT;
    private String JONGNO;
    private String JONGNOADD;
    private String JUNGGU;
    private String JUNGGUADD;
    private String YONGSAN;
    private String YONGSANADD;

    @Builder
    public Covid19SeoulInfectionRegionCount toEntity() {
        return Covid19SeoulInfectionRegionCount.builder()
                .jcgDt(JCG_DT)
                .jongno(JONGNO)
                .jongnoAdd(JONGNOADD)
                .junggu(JUNGGU)
                .jungguAdd(JUNGGUADD)
                .yongsan(YONGSAN)
                .yongsanAdd(YONGSANADD)
                .build();
    }
}
