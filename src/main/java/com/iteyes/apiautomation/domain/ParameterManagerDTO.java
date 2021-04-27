package com.iteyes.apiautomation.domain;

import com.iteyes.apiautomation.store.entity.ParameterManager;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParameterManagerDTO {

    private String apiId;
    private String parameterName;
    private String parameterDes;
    private String parameterType;
    private String valueDes;


    public ParameterManagerDTO(ParameterManager parameterManager) {
        this.apiId = parameterManager.getApiId();
        this.parameterDes = parameterManager.getParameterDes();
        this.parameterName = parameterManager.getParameterName();
        this.parameterType = parameterManager.getParameterType();
        this.valueDes = parameterManager.getValueDes();
    }

}
