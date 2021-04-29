package com.iteyes.apiautomation.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 요청 변수 입력 값과 변수 정보 DTO
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestFormDTO {

    private String parameterKey;
    private String parameterValue;

}
