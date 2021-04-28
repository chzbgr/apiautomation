package com.iteyes.apiautomation.domain;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
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

//    private String SAVE_TIME;
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
//                .saveTime()
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

//    private String corona19Id;
//    private String corona19Date;
//    private String corona19No;
//    private String corona19Country;
//    private String corona19Personal;
//    private String corona19Area;
//    private String corona19TravelHistory;
//    private String corona19ContactHistory;
//    private String corona19Corrective;
//    private String corona19LeaveStatus;
//    private String corona19MovingPath;
//    private String corona19Idate;
//    private String corona19Mdate;
//
//    public void jsonToDto(JsonObject jsonObject) {
//        this.corona19Id = convertJsonString(jsonObject, "CORONA19_ID");
//        this.corona19Date = convertJsonString(jsonObject, "CORONA19_DATE");
//        this.corona19No = convertJsonString(jsonObject, "CORONA19_NO");
//        this.corona19Country = convertJsonString(jsonObject, "CORONA19_COUNTRY");
//        this.corona19Personal = convertJsonString(jsonObject, "CORONA19_PERSONAL");
//        this.corona19Area = convertJsonString(jsonObject, "CORONA19_AREA");
//        this.corona19TravelHistory = convertJsonString(jsonObject, "CORONA19_TRAVEL_HISTORY");
//        this.corona19ContactHistory = convertJsonString(jsonObject, "CORONA19_CONTACT_HISTORY");
//        this.corona19Corrective = convertJsonString(jsonObject, "CORONA19_CORRECTIVE");
//        this.corona19LeaveStatus = convertJsonString(jsonObject, "CORONA19_LEAVE_STATUS");
//        this.corona19MovingPath = convertJsonString(jsonObject, "CORONA19_MOVING_PATH");
//        this.corona19Idate = convertJsonString(jsonObject, "CORONA19_IDATE");
//        this.corona19Mdate = convertJsonString(jsonObject, "CORONA19_MDATE");
//
//    }
//
//    private String convertJsonString(JsonObject jo, String itemName) {
//        JsonElement je = jo.get(itemName);
//        return je.getAsString();
//    }
}
