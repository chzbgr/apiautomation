package com.iteyes.apiautomation.domain;

import com.iteyes.apiautomation.store.entity.ParameterManager;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 요청 변수 정보 DTO
 */
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

    /**
     * DTO 객체를 Entity 형태로 변환
     * @return entity
     */
    public ParameterManagerDTO(ParameterManager parameterManager) {
        this.apiId = parameterManager.getApiId();
        this.parameterDes = parameterManager.getParameterDes();
        this.parameterName = parameterManager.getParameterName();
        this.parameterType = parameterManager.getParameterType();
        this.valueDes = parameterManager.getValueDes();
    }

}
