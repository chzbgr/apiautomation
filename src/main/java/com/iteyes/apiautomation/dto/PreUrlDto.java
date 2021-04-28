package com.iteyes.apiautomation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreUrlDto {

    private String parameterKey;
    private String parameterValue;

    public PreUrlDto(PreUrlDto preUrlDto) {
        this.parameterKey = parameterKey;
        this.parameterValue = parameterValue;
    }
}
