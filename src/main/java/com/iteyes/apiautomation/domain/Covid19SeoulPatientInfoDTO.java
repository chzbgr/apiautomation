package com.iteyes.apiautomation.domain;

import com.iteyes.apiautomation.store.entity.Covid19SeoulPatientInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Covid19SeoulPatientInfoDTO {

    private String CORONA19_ID;
    private String CORONA19_DATE;
    private String CORONA19_NO;
    private String CORONA19_COUNTRY;
    private String CORONA19_PERSONAL;
    private String CORONA19_AREA;
    private String CORONA19_TRAVEL_HISTORY;
    private String CORONA19_CONTACT_HISTORY;
    private String CORONA19_CORRECTIVE;
    private String CORONA19_LEAVE_STATUS;
    private String CORONA19_MOVING_PATH;
    private String CORONA19_IDATE;
    private String CORONA19_MDATE;

    @Builder
    public Covid19SeoulPatientInfo toEntity() {
        return Covid19SeoulPatientInfo.builder()
                .corona19Id(CORONA19_ID)
                .corona19Date(CORONA19_DATE)
                .corona19No(CORONA19_NO)
                .corona19Country(CORONA19_COUNTRY)
                .corona19Personal(CORONA19_PERSONAL)
                .corona19Area(CORONA19_AREA)
                .corona19TravelHistory(CORONA19_TRAVEL_HISTORY)
                .corona19ContactHistory(CORONA19_CONTACT_HISTORY)
                .corona19Corrective(CORONA19_CORRECTIVE)
                .corona19LeaveStatus(CORONA19_LEAVE_STATUS)
                .corona19MovingPath(CORONA19_MOVING_PATH)
                .corona19Idate(CORONA19_IDATE)
                .corona19Mdate(CORONA19_MDATE)
                .build();
    }

}
