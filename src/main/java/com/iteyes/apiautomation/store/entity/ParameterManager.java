package com.iteyes.apiautomation.store.entity;

import com.iteyes.apiautomation.store.entity.key.ParameterManagerKey;
import lombok.*;

import javax.persistence.*;


@Entity
@Builder
@ToString
@Getter
@Table(name = "PARAMETER_MANAGER")
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ParameterManagerKey.class)
public class ParameterManager {

    @Id
    @Column(name = "API_ID")
    private String apiId;
    @Id
    @Column(name = "PARAMETER_NAME")
    private String parameterName;


    @Column(name = "PARAMETER_DES")
    private String parameterDes;

    @Column(name = "PARAMETER_TYPE")
    private String parameterType;

    @Column(name = "VALUE_DES")
    private String valueDes;
}
