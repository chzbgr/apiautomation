package com.iteyes.apiautomation.store.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name="API_MANAGER",schema = "API_TEST_DB")
public class ApiManager {

    @Id
    @Column(name = "API_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String apiId;

    @Column(name="API_URL")
    private String apiUrl;

    @Column(name="SERVICE_KEY")
    private String serviceKey;

    @Column(name="API_NAME")
    private String apiName;

    @Builder
    public ApiManager(String apiId,String apiUrl,String serviceKey,String apiName){
        this.apiId=apiId;
        this.apiUrl=apiUrl;
        this.serviceKey=serviceKey;
        this.apiName=apiName;
    }

}
