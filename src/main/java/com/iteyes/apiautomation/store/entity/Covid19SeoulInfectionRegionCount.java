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
@Table(name = "COVID19_SEOUL_INFECTION_REGION_COUNT")
public class Covid19SeoulInfectionRegionCount {

    @Id
    @Column(name = "JCG_DT")
    private String jcgDt;

    @Column(name = "JONGNO")
    private String jongno;

    @Column(name = "JONGNOADD")
    private String jongnoAdd;

    @Column(name = "JUNGGU")
    private String junggu;

    @Column(name = "JUNGGUADD")
    private String jungguAdd;

    @Column(name = "YONGSAN")
    private String yongsan;

    @Column(name = "YONGSANADD")
    private String yongsanAdd;

}
