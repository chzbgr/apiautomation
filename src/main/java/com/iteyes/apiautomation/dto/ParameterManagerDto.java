package com.iteyes.apiautomation.dto;

import com.iteyes.apiautomation.store.entity.ParameterManager;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ParameterManagerDto {

    private String apiId;
    private String parameterName;
    private String parameterDes;
    private String parameterType;
    private String valueDes;

    public ParameterManagerDto(ParameterManager parameterManager) {
        this.apiId =parameterManager.getApiId();
        this.parameterName=parameterManager.getParameterName();
        this.parameterDes=parameterManager.getParameterDes();
        this.parameterType=parameterManager.getParameterType();
        this.valueDes=parameterManager.getValueDes();

    }

    private ParameterManagerDto toEntity(){
        return ParameterManagerDto.builder()
                .apiId(apiId)
                .parameterName(parameterName)
                .parameterDes(parameterDes)
                .parameterType(parameterType)
                .valueDes(valueDes)
                .build();

    }
}
