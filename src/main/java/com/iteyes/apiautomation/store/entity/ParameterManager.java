package com.iteyes.apiautomation.store.entity;


import com.iteyes.apiautomation.store.entity.key.ParameterEntityKey;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="PARAMETER_MANAGER",schema = "API_TEST_DB")

@IdClass(ParameterEntityKey.class)

public class ParameterManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="API_ID")
    private String apiId;

    @Id
    @Column(name="PARAMETER_NAME")
    private String parameterName;

    @Column(name="PARAMETER_DES")
    private String parameterDes;

    @Column(name="PARAMETER_TYPE")
    private String parameterType;

    @Column(name="VALUE_DES")
    private String valueDes;


    @Builder
    public ParameterManager(String apiId , String parameterName,String parameterDes,String parameterType,String valueDes){
        this.apiId=apiId;
        this.parameterName=parameterName;
        this.parameterDes=parameterDes;
        this.parameterType=parameterType;
        this.valueDes=valueDes;
    }
}
