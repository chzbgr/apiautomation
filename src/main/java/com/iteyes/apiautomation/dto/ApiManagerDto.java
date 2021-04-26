package com.iteyes.apiautomation.dto;


import com.iteyes.apiautomation.store.entity.ApiManager;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ApiManagerDto {

    private String apiId;
    private String apiUrl;
    private String serviceKey;
    private String apiName;

    public ApiManagerDto(ApiManager apiManager) {
        this.apiId=apiManager.getApiId();
        this.apiName=apiManager.getApiName();
        this.apiUrl=apiManager.getApiUrl();
    }

    public ApiManagerDto toEntity(){
        return ApiManagerDto.builder()
            .apiId(apiId)
            .apiUrl(apiUrl)
            .serviceKey(serviceKey)
            .apiName(apiName)
            .build();
    }
}
