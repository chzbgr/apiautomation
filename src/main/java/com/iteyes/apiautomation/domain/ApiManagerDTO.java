package com.iteyes.apiautomation.domain;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiManagerDTO {

    private String apiId;
    private String apiUrl;
    private String serviceKey;
    private String apiName;
}
