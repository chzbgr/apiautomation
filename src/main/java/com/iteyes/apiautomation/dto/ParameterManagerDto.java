package com.iteyes.apiautomation.dto;

import com.iteyes.apiautomation.store.entity.ApiManager;
import com.iteyes.apiautomation.store.entity.ParameterManager;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ParameterManagerDto {

    private String apiId;
    private String parameterName;
    private String paramterDes;
    private String paramterType;
    private String valueDes;

    public ParameterManagerDto(ParameterManager parameterManager) {
        this.apiId =getApiId();
        this.parameterName=getParameterName();
        this.paramterDes=getParamterDes();
        this.paramterType=getParamterType();
        this.valueDes=getValueDes();

    }

    @Builder
    private ParameterManager toEntity(){
        return ParameterManager.builder()
                .apiId(apiId)
                .parameterName(parameterName)
                .parameterDes(paramterDes)
                .parameterType(paramterType)
                .valueDes(valueDes)
                .build();

    }
}
