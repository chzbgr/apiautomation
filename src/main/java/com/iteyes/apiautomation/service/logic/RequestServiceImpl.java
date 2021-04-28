package com.iteyes.apiautomation.service.logic;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.iteyes.apiautomation.domain.Covid19SeoulPatientInfoDTO;
import com.iteyes.apiautomation.domain.RequestFormDTO;
import com.iteyes.apiautomation.service.RequestService;
import com.iteyes.apiautomation.store.ApiStore;
import com.iteyes.apiautomation.store.repository.Covid19SeoulPatientInfoRepository;
import lombok.extern.log4j.Log4j2;

import org.json.JSONException;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private ApiStore apiStore;

    @Autowired
    private Covid19SeoulPatientInfoRepository covid19SeoulPatientInfoRepository;


    @Override
    public List<String> showPreview(String apiId, List<String> parameterValue) throws IOException, JSONException {
        String serviceKey = getServiceKey(apiId);
        String url = getUrl(apiId);
        List<RequestFormDTO> requestForm = getRequestForm(apiId, parameterValue);
        URL requestUrl = getRequestUrl(apiId, url, serviceKey, requestForm);
        log.info(requestUrl);
        String resultCallString = onCallsApi(requestUrl);
        log.info(resultCallString);

        List<String> previewList = preParseJson(resultCallString, parameterValue.get(1));
        log.info("미리보기ㄱㄱ" + previewList.toString());


        AllParseJson(resultCallString, parameterValue.get(1));
        return previewList;
    }

    //    ********** URL 만들기 **************
    public String getServiceKey(String apiId) {
        return apiStore.findServiceKeyByApiId(apiId);
    }

    public String getUrl(String apiId) {
        return apiStore.findUrlByApiId(apiId);
    }

    public List<RequestFormDTO> getRequestForm(String apiId, List<String> parameterValue) {
        List<String> parameterName = apiStore.findParameterNameByApiId(apiId);
        List<RequestFormDTO> requestList = new ArrayList<>();
        for (int i = 0; i < parameterName.size(); i++) {
            RequestFormDTO requestForm = new RequestFormDTO();
            requestForm.setParameterKey(parameterName.get(i));
            requestForm.setParameterValue(parameterValue.get(i));
            requestList.add(requestForm);
        }
        return requestList;
    }

    public URL getRequestUrl(String apiId, String url, String serviceKey, List<RequestFormDTO> requestForm) throws IOException {
        StringBuilder urlBuilder = new StringBuilder(url);
        URL requestUrl;

        if (apiId.equals("api1")) {
            urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey);
            urlBuilder.append("&" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + URLEncoder.encode("-", "UTF-8"));
            for (int i = 0; i < requestForm.size(); i++) {
                urlBuilder.append("&" + URLEncoder.encode(requestForm.get(i).getParameterKey(), "UTF-8") + "=" + URLEncoder.encode(requestForm.get(i).getParameterValue(), "UTF-8"));
            }
            requestUrl = new URL(urlBuilder.toString());
            System.out.println("api의 url 합합합");
        } else {
            urlBuilder.append("/" + URLEncoder.encode(serviceKey, "UTF-8"));
            urlBuilder.append("/" + URLEncoder.encode(requestForm.get(3).getParameterValue(), "UTF-8"));
            urlBuilder.append("/" + URLEncoder.encode(requestForm.get(1).getParameterValue(), "UTF-8"));
            urlBuilder.append("/" + URLEncoder.encode(requestForm.get(2).getParameterValue(), "UTF-8"));
            urlBuilder.append("/" + URLEncoder.encode(requestForm.get(0).getParameterValue(), "UTF-8"));
            requestUrl = new URL(urlBuilder.toString());
            System.out.println("나머지 api url 합합합");
        }
        return requestUrl;
    }


//        ********** Api 호출하기 String**************

    public String onCallsApi(URL requestUrl) throws IOException, JSONException {
        HttpURLConnection conn = (HttpURLConnection) requestUrl.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");

//        responds Code 출력해서 결과 확인
        int responseCode = conn.getResponseCode();
        BufferedReader br;
        if (responseCode >= 200 && responseCode <= 300) {
            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        conn.disconnect();

//        JSON Object 에  담기
//        JSONObject responseJson;
//        responseJson = new JSONObject(sb.toString());
//        Data data = JSONtoData(responseJson);
        return sb.toString();
    }


//        ********** JSON 일부분 parsing **************
    public List<String> preParseJson(String resultCallString, String service) {
        JsonObject jsonObject = new Gson().fromJson(resultCallString, JsonObject.class);
        JsonObject data = jsonObject.getAsJsonObject(service);

        System.out.println("###########");
        System.out.println(service);


        JsonArray rowData = data.getAsJsonArray("row");
        String rowString = rowData.get(0).toString();
        log.info("첫 row 값 스뜨륑" + rowString);
//        PatientTestDTO patientTestDTO = new Gson().fromJson(rowString, PatientTestDTO.class);
        JsonObject resultData = data.getAsJsonObject("RESULT");

        String resultString = resultData.toString();
        log.info("result 값 스뜨륑" + resultString);
        List<String> previewList = new ArrayList<>();
        previewList.add(resultString);
        previewList.add(rowString);

        return previewList;
//        return resultData.getAsString();
    }

    public void AllParseJson(String resultCallString, String service) {
        JsonObject jsonObject = new Gson().fromJson(resultCallString, JsonObject.class);
        JsonObject data = jsonObject.getAsJsonObject(service);
        JsonArray rowData = data.getAsJsonArray("row");
        log.info("여기 까지 성공 row");

        for (int i=0; i<rowData.size(); i++) {
            String rowString = rowData.get(i).toString();
            Covid19SeoulPatientInfoDTO covid19SeoulPatientInfoDTO = new Gson().fromJson(rowString, Covid19SeoulPatientInfoDTO.class);
            covid19SeoulPatientInfoRepository.save(covid19SeoulPatientInfoDTO.toEntity());
            log.info(i+"번째 저장 성공~~~~~");
        }

    }
        //조회 결과
//        JsonArray itemList = data.getAsJsonArray("row");
////        for (int i = 0; i < itemList.size(); i++) {
////            JsonObject row = (JsonObject) itemList.get(i);
////            String value = row.toString();
////            System.out.println(value);
////        }
//
//        for (JsonElement jsonElement : itemList){
//            JsonObject item = jsonElement.getAsJsonObject();
//
////            Covid19InfectionCountDTO covid19InfectionCountDTO = new Covid19InfectionCountDTO();
////
////            covid19InfectionCountDTO.jsonToDto(item);
//
//        }




//        for (JsonElement jsonElement : itemList) {
//            JsonObject item = jsonElement.getAsJsonObject();
//            if (JsonUtils.canNotUseJsonElement(item)) {
//                continue;
//            }
//        }

//    public JSONObject 전체_파싱(JSONObject jsonObject) {
//
//        return jsonObject;
//    }




}