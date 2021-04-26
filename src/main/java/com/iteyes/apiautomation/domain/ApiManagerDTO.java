package com.iteyes.apiautomation.domain;

import com.iteyes.apiautomation.store.entity.ApiManager;
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

    public ApiManagerDTO(ApiManager apiManager) {
        this.apiId = apiManager.getApiId();
        this.apiName = apiManager.getApiName();
        this.apiUrl = apiManager.getApiUrl();
    }
}
