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

/**
 * api 출력, 요청, 호출, 적재를 수행하는 로직
 */
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

    /**
     * Api 목록 제공
     * @return apiList
     */
    @Override
    public List<ApiManagerDTO> getApiList() {
        return apiStore.findAllApiList();
    }

    /**
     * api 별 요청 변수 제공
     * @param apiId
     * @return parameterList
     */
    @Override
    public List<ParameterManagerDTO> getParameterList(String apiId) {
        return apiStore.findAllParameterList(apiId);
    }

    /**
     * api 호출 결과 일부분 파싱 후
     * 미리보기 결과 code, message 출력
     * @param apiId
     * @param parameterValue 요청 변수 입력 값
     * @return previewList
     * @throws Exception
     */
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

    /**
     * api 호출 결과 전체 파싱 후
     * DB에 저장
     * @param apiId
     * @param parameterValue
     * @return "성공"/"실패"
     * @throws Exception
     */
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

    /**
     * 요청 변수 입력값과 변수 명을 DTO 형태로 변환
     * @param apiId
     * @param parameterValue
     * @return requestList requestFormDTO 리스트
     */
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

    /**
     * 요청 변수를 url 형식으로 변환
     * @param apiId
     * @param url
     * @param serviceKey
     * @param requestForm
     * @return requestUrl
     * @throws IOException
     */
    private URL createRequestUrl(String apiId, String url, String serviceKey,
                                 List<RequestFormDTO> requestForm) throws IOException {

        StringBuilder urlBuilder = new StringBuilder(url);
        URL requestUrl;

        if (apiId.equals("api1")) {
            urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey);
            urlBuilder.append("&" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" +
                    URLEncoder.encode("-", "UTF-8"));

            for (int i = 0; i < requestForm.size(); i++) {
                urlBuilder.append("&" + URLEncoder.encode(requestForm.get(i).getParameterKey(), "UTF-8") + "=" +
                        URLEncoder.encode(requestForm.get(i).getParameterValue(), "UTF-8"));
            }
        } else {
            urlBuilder.append("/" + URLEncoder.encode(serviceKey, "UTF-8"));
            urlBuilder.append("/" + URLEncoder.encode(requestForm.get(3).getParameterValue(), "UTF-8"));
            urlBuilder.append("/" + URLEncoder.encode(requestForm.get(1).getParameterValue(), "UTF-8"));
            urlBuilder.append("/" + URLEncoder.encode(requestForm.get(2).getParameterValue(), "UTF-8"));
            urlBuilder.append("/" + URLEncoder.encode(requestForm.get(0).getParameterValue(), "UTF-8"));
        }

        requestUrl = new URL(urlBuilder.toString());
        return requestUrl;
    }

    /**
     * api 호출 후
     * 결과 String으로 반환
     * @param requestUrl
     * @return sb.toString
     * @throws IOException
     */
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

    /**
     * api 호출 결과를 일부분 파싱하여 code, message 반환
     * 요청이 정상 처리일 경우 json 형식으로 파싱
     * 비정상 처리일 경우 xml 형식으로 파싱
     * @param resultApiCall api 호출 결과 문자열
     * @param service api를 구별하기 위한 service 변수
     * @return previewResult 결과 code, message 반환
     * @throws Exception
     */
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
            previewResult.add(code);
            previewResult.add(message);
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

    /**
     * json 객체를 전부 파싱하여 DTO 객체로 변환 후
     * Entity 로 변환하여 Repository 에 저장
     * @param resultCall api 호출 결과 String
     * @param service api를 구별하기 파싱 위한 service 변수
     * @return "성공"/"실패" 적재 결과 반환
     * @throws Exception
     */
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

}

