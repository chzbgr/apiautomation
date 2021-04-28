package com.iteyes.apiautomation.store.entity;

import com.iteyes.apiautomation.store.entity.key.Covid19SeoulPatientInfoKey;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "COVID19_SEOUL_PATIENT_INFO")
@IdClass(Covid19SeoulPatientInfoKey.class)
public class Covid19SeoulPatientInfo {

    @Id
    @Column(name = "CORONA19_ID")
    private String corona19Id;

    @Id
    @Column(name = "CORONA19_DATE")
    private String corona19Date;

    @Id
    @Column(name = "CORONA19_NO")
    private String corona19No;

    @Column(name = "CORONA19_COUNTRY")
    private String corona19Country;

    @Column(name = "CORONA19_PERSONAL")
    private String corona19Personal;

    @Column(name = "CORONA19_AREA")
    private String corona19Area;

    @Column(name = "CORONA19_TRAVEL_HISTORY")
    private String corona19TravelHistory;

    @Column(name = "CORONA19_CONTACT_HISTORY")
    private String corona19ContactHistory;

    @Column(name = "CORONA19_CORRECTIVE")
    private String corona19Corrective;

    @Column(name = "CORONA19_LEAVE_STATUS")
    private String corona19LeaveStatus;

    @Column(name = "CORONA19_MOVING_PATH")
    private String corona19MovingPath;

    @Column(name = "CORONA19_IDATE")
    private String corona19Idate;

    @Id
    @Column(name = "CORONA19_MDATE")
    private String corona19Mdate;

}
