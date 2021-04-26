package com.iteyes.apiautomation.store.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@ToString
@Table(name = "API_MANAGER")
public class ApiManager {

    @Id
    @Column(name = "API_ID")
    private String apiId;

    @Column(name = "API_URL")
    private String apiUrl;

    @Column(name = "SERVICE_KEY")
    private String serviceKey;

    @Column(name = "API_NAME")
    private String apiName;
}
