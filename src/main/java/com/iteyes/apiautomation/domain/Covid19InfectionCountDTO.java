//package com.iteyes.apiautomation.domain;
//
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//
//public class Covid19InfectionCountDTO {
//
//    private String covid19Id;
//    private String covid19Date;
//
//    public void jsonToDto(JsonObject jsonObject) {
//        covid19Id = convertJsonString(jsonObject, "CORONA19_ID");
//        covid19Date = convertJsonString(jsonObject, "CORONA19_DATE");
//
//    }
//
//    private String convertJsonString(JsonObject jo, String itemName) {
//        JsonElement je = jo.get(itemName);
//        return je.getAsString();
//    }
//
//
//}
