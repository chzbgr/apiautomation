package com.iteyes.apiautomation.service.logic;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.iteyes.apiautomation.domain.*;
import com.iteyes.apiautomation.service.ApiService;
import com.iteyes.apiautomation.store.ApiStore;
import com.iteyes.apiautomation.store.repository.Covid19SeoulInfectionCountRepository;
import com.iteyes.apiautomation.store.repository.Covid19SeoulInfectionRegionCountRepository;
import com.iteyes.apiautomation.store.repository.Covid19SeoulPatientInfoRepository;
import com.iteyes.apiautomation.store.repository.Covid19SeoulVaccinationStatusRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class ApiServiceImpl implements ApiService {

    @Autowired
    private ApiStore apiStore;

    @Autowired
    private Covid19SeoulPatientInfoRepository covid19SeoulPatientInfoRepository;

    @Autowired
    private Covid19SeoulInfectionCountRepository covid19SeoulInfectionCountRepository;

    @Autowired
    private Covid19SeoulVaccinationStatusRepository covid19SeoulVaccinationStatusRepository;

    @Autowired
    private Covid19SeoulInfectionRegionCountRepository covid19SeoulInfectionRegionCountRepository;

    @Override
    public List<ApiManagerDTO> getApiList() {
        return apiStore.findAllApiList();
    }

    @Override
    public List<ParameterManagerDTO> getParameterList(String apiId) {
        return apiStore.findAllParameterList(apiId);
    }

    @Override
    public List<String> previewJson(String apiId, List<String> parameterValue) throws Exception {
        String serviceKey = apiStore.findServiceKeyByApiId(apiId);
        String url = apiStore.findUrlByApiId(apiId);
        String service = parameterValue.get(1);

        List<RequestFormDTO> requestForm = getRequestForm(apiId, parameterValue);
        URL requestUrl = createRequestUrl(apiId, url, serviceKey, requestForm);

        String resultApiCall = callApi(requestUrl);
        List<String> previewList = previewParseJson(resultApiCall, service);

        return previewList;
    }

    @Override
    public String saveJson(String apiId, List<String> parameterValue) throws Exception {
        try {
            String serviceKey = apiStore.findServiceKeyByApiId(apiId);
            String url = apiStore.findUrlByApiId(apiId);
            String service = parameterValue.get(1);

            List<RequestFormDTO> requestForm = getRequestForm(apiId, parameterValue);
            URL requestUrl = createRequestUrl(apiId, url, serviceKey, requestForm);

            String resultCall = callApi(requestUrl);

            return saveParseJson(resultCall, service);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    //    ********** URL 만들기 **************
    private List<RequestFormDTO> getRequestForm(String apiId, List<String> parameterValue) {
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

    private URL createRequestUrl(String apiId, String url, String serviceKey, List<RequestFormDTO> requestForm) throws IOException {
        StringBuilder urlBuilder = new StringBuilder(url);
        URL requestUrl;

        if (apiId.equals("api1")) {
            urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey);
            urlBuilder.append("&" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + URLEncoder.encode("-", "UTF-8"));
            for (int i = 0; i < requestForm.size(); i++) {
                urlBuilder.append("&" + URLEncoder.encode(requestForm.get(i).getParameterKey(), "UTF-8") + "=" + URLEncoder.encode(requestForm.get(i).getParameterValue(), "UTF-8"));
            }
            requestUrl = new URL(urlBuilder.toString());
        } else {
            urlBuilder.append("/" + URLEncoder.encode(serviceKey, "UTF-8"));
            urlBuilder.append("/" + URLEncoder.encode(requestForm.get(3).getParameterValue(), "UTF-8"));
            urlBuilder.append("/" + URLEncoder.encode(requestForm.get(1).getParameterValue(), "UTF-8"));
            urlBuilder.append("/" + URLEncoder.encode(requestForm.get(2).getParameterValue(), "UTF-8"));
            urlBuilder.append("/" + URLEncoder.encode(requestForm.get(0).getParameterValue(), "UTF-8"));
            requestUrl = new URL(urlBuilder.toString());
        }
        return requestUrl;
    }

    private String callApi(URL requestUrl) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) requestUrl.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");

        int responseCode = conn.getResponseCode();

        BufferedReader br;
        if (responseCode >= 200 && responseCode <= 300) {
            System.out.println(responseCode);
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


        return sb.toString();
    }

    private List<String> previewParseJson(String resultApiCall, String service) throws Exception {
        String code;
        String message;
        List<String> previewResult = new ArrayList<>();

        try {
            if (resultApiCall.endsWith("}")) {
                JsonObject jsonObject = new Gson().fromJson(resultApiCall, JsonObject.class);
                JsonObject data = jsonObject.getAsJsonObject(service);
                JsonObject result = data.getAsJsonObject("RESULT");
                code = result.get("CODE").getAsString();
                message = result.get("MESSAGE").getAsString();
                previewResult.add(code);
                previewResult.add(message);
            } else {
                InputSource is = new InputSource(new StringReader(resultApiCall));
                DocumentBuilder builder;
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                builder = factory.newDocumentBuilder();
                Document doc = builder.parse(is);
                XPathFactory xpathFactory = XPathFactory.newInstance();
                XPath xpath = xpathFactory.newXPath();
                XPathExpression expr = xpath.compile("/RESULT");
                NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
                code = nodeList.item(0).getChildNodes().item(0).getTextContent();
                message = nodeList.item(0).getChildNodes().item(1).getTextContent();
                previewResult.add(code);
                previewResult.add(message);
            }
            return previewResult;

        } catch (NullPointerException e) {
            JsonObject jsonObject = new Gson().fromJson(resultApiCall, JsonObject.class);
            JsonObject result = jsonObject.getAsJsonObject("RESULT");
            code = result.get("CODE").getAsString();
            message = result.get("MESSAGE").getAsString();
            previewResult.add(code);
            previewResult.add(message);
            return previewResult;
        }
    }

    //        ********** JSON 전체 parsing @ save **************
    private String saveParseJson(String resultCall, String service) throws Exception {
        try {
            JsonObject jsonObject = new Gson().fromJson(resultCall, JsonObject.class);
            JsonObject data = jsonObject.getAsJsonObject(service);
            JsonArray rowData = data.getAsJsonArray("row");
            for (int i = 0; i < rowData.size(); i++) {
                String rowString = rowData.get(i).toString();

                if (service.equals("Corona19Status")) {
                    Covid19SeoulPatientInfoDTO covid19SeoulPatientInfoDTO
                            = new Gson().fromJson(rowString, Covid19SeoulPatientInfoDTO.class);
                    covid19SeoulPatientInfoRepository.save(covid19SeoulPatientInfoDTO.toEntity());
                } else if (service.equals("TbCorona19CountStatus")) {
                    Covid19SeoulInfectionCountDTO covid19SeoulInfectionCountDTO
                            = new Gson().fromJson(rowString, Covid19SeoulInfectionCountDTO.class);
                    covid19SeoulInfectionCountRepository.save(covid19SeoulInfectionCountDTO.toEntity());
                } else if (service.equals("TbCorona19Vaccinestat")) {
                    Covid19SeoulVaccinationStatusDTO covid19SeoulVaccinationStatusDTO
                            = new Gson().fromJson(rowString, Covid19SeoulVaccinationStatusDTO.class);
                    covid19SeoulVaccinationStatusRepository.save(covid19SeoulVaccinationStatusDTO.toEntity());
                } else if (service.equals("TbCorona19CountStatusJCG")) {
                    Covid19SeoulInfectionRegionCountDTO covid19SeoulInfectionRegionCountDTO
                            = new Gson().fromJson(rowString, Covid19SeoulInfectionRegionCountDTO.class);
                    covid19SeoulInfectionRegionCountRepository.save(covid19SeoulInfectionRegionCountDTO.toEntity());
                }
            }

            return "적재 성공";
        } catch (Exception e) {
            throw new Exception("적재 실패");
        }
    }


    //        ********** JSON 일부분 parsing **************
//    public List<String> preParseJson(String resultCallString, String service) throws Exception {
//        try {
//            JsonObject jsonObject = new Gson().fromJson(resultCallString, JsonObject.class);
//            JsonObject data = jsonObject.getAsJsonObject(service);
//
//            JsonArray rowData = data.getAsJsonArray("row");
//            String firstRowString = rowData.get(0).toString();
//            log.info("첫 row 값 스뜨륑" + firstRowString);
//            JsonObject resultData = data.getAsJsonObject("RESULT");
//
//            String resultString = resultData.toString();
//            log.info("result 값 스뜨륑" + resultString);
//            List<String> previewList = new ArrayList<>();
//            previewList.add(resultString);
//            previewList.add(firstRowString);
//            previewList.add(rowData.toString());
//            log.info("previewList 2번째가 rowdata 맞나 쳌" + previewList.get(2));
//            return previewList;
//        } catch (Exception e) {
//            throw new Exception(e);
//        }
//    }

}

