package com.iteyes.apiautomation.service.logic;

import com.iteyes.apiautomation.dto.PreUrlDto;
import com.iteyes.apiautomation.service.urlCreateService;
import com.iteyes.apiautomation.store.entity.Covid19InfectionCount;
import com.iteyes.apiautomation.store.mainRepo;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;



@Service
public class UrlCreateServiceImpl implements urlCreateService {

    @Autowired
    private mainRepo mainrepo;

    // url 만들기
    public String getServiceKey(String apiId) {

        return mainrepo.findServiceKeyByApiId(apiId);
    }

    public String getUrl(String apiId) {

        return mainrepo.findUrlByApiId(apiId);
    }

    @Override
    public List<String> showPreview(String apiId, List<String> keyArr, List<String> valueArr) throws IOException, URISyntaxException, ParserConfigurationException, SAXException {
        String serviceKey = getServiceKey(apiId);
        String url = getUrl(apiId);

        List<PreUrlDto> preUrlDto = getPreUrlDto(keyArr, valueArr);
        URL requestUrl = urlMake(apiId, url, serviceKey, preUrlDto);
        System.out.println("드갈주소는:"+requestUrl);
        List<PreUrlDto> viewUrl =  domParser(apiId,requestUrl);
        return null;
    }


    // 키 밸류 분류 및 저장
    public List<PreUrlDto> getPreUrlDto(List<String> keyArr, List<String> valueArr) {
        // List<String> parameterName = mainrepo.findParameterNameByApiId(apiId);
        List<PreUrlDto> requestList = new ArrayList<>();

        for (int i = 0; i < keyArr.size(); i++) {
            PreUrlDto requestForm = new PreUrlDto();
            requestForm.setParameterKey(keyArr.get(i));
            requestForm.setParameterValue(valueArr.get(i));
            requestList.add(requestForm);
        }
        return requestList;
    }

    // url 생성
    private URL urlMake(String apiId, String url, String serviceKey, List<PreUrlDto> getPreUrlDto) throws URISyntaxException, ClientProtocolException, UnsupportedEncodingException, MalformedURLException {
        StringBuilder urlBuilder = new StringBuilder(url);
        URL requestUrl;

        if (apiId.equals("api1")) {
            urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey);
            for (int i = 0; i < getPreUrlDto.size(); i++) {
                urlBuilder.append("&" + URLEncoder.encode(getPreUrlDto.get(i).getParameterKey(), "UTF-8") + "=" + URLEncoder.encode(getPreUrlDto.get(i).getParameterValue(), "UTF-8"));
            }
            requestUrl = new URL(urlBuilder.toString());
        } else {
            return null;
        }
        return requestUrl;
    }


    //api 호출
//        public String callApi(String requestUrl) throws IOException {
//
//        StringBuffer result = new StringBuffer();
//
//        URL url = new URL(requestUrl);
//        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//        urlConnection.setRequestMethod("POST");
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
//
//        String returnLine;
//        result.append("<xmp>");
//        while((returnLine = br.readLine()) !=null){
//            result.append(returnLine+"\n");
//            }
//        urlConnection.disconnect();
//        return result+"</xmp>";
//    }

    // 아이템 값 출력
    public List<PreUrlDto> domParser(String apiId, URL requestUrl ) throws ParserConfigurationException, SAXException,IOException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder documentBuilder = factory.newDocumentBuilder();

        Document document = documentBuilder.parse(String.valueOf(requestUrl));
        //root 구하기
        Element root = document.getDocumentElement();


//dj 저는 코딩을 못해요 ㅠㅠㅠ
       return null;


        }
    }

