package com.iteyes.apiautomation.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestFormDTO {

    private String parameterKey;
    private String parameterValue;

}
