package com.iteyes.apiautomation.domain;

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
}
