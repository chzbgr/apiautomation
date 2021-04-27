package com.iteyes.apiautomation.dto;

public class ParamCreateDto {

    private String apiId;
    private String keyArr;
    private String valArr;

    public ParamCreateDto(String apiId, String keyArr, String valArr) {
        this.apiId = apiId;
        this.keyArr = keyArr;
        this.valArr = valArr;
    }

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public String getKeyArr() {
        return keyArr;
    }

    public void setKeyArr(String keyArr) {
        this.keyArr = keyArr;
    }

    public String getValArr() {
        return valArr;
    }

    public void setValArr(String valArr) {
        this.valArr = valArr;
    }
}
