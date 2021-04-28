package com.iteyes.apiautomation.service.logic;

import com.iteyes.apiautomation.dto.PreUrlDto;
import com.iteyes.apiautomation.service.urlCreateService;
import com.iteyes.apiautomation.store.entity.Covid19InfectionCount;
import com.iteyes.apiautomation.store.mainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
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
    public List<String> showPreview(String apiId, List<String> keyArr, List<String> valueArr) {
        String serviceKey = getServiceKey(apiId);
        String url = getUrl(apiId);
        System.out.println(apiId);
        System.out.println(keyArr);
        System.out.println(valueArr);
        List<PreUrlDto> preUrlDto = getPreUrlDto(apiId, keyArr, valueArr);

        return null;

    }
    public List<PreUrlDto> getPreUrlDto(String apiId, List<String> keyArr, List<String> valueArr) {
        List<String> parameterName = mainrepo.findParameterNameByApiId(apiId);
        List<PreUrlDto> requestList = new ArrayList<>();

        for (int i = 0; i < parameterName.size(); i++) {
            PreUrlDto requestForm = new PreUrlDto();
            requestForm.setParameterKey(keyArr.get(i));
            requestForm.setParameterValue(valueArr.get(i));
            requestList.add(requestForm);
        }

        return requestList;
    }
}


























   /* // 아이템 값 출력
    public String pickKey(String apiId, List<String> abc){
        List<String> aList = new ArrayList<>();

        try {
            DocumentBuilderFactory Apreview = DocumentBuilderFactory.newInstance();
            DocumentBuilder previewBuilder = Apreview.newDocumentBuilder();
            Document doc = previewBuilder.parse("null");
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("item");
            //이 부분은 list에 담긴 데이터를 출력하는 부분
            //위에 담긴 list를 반복문을 통해서 출력한다.
            //getTextContent()는 전체 정보 의미
            //getTagValue("tag",element) : 입력한 tag정보를 의미
            //getTagValue("tag" <- 실질적인 tag의 변수값을 넣어줘야 함)
            //getTagValue는 따로 메소드를 만들어 준 것
            for (int temp = 0; temp < nList.getLength(); temp++) {
                //for문을 통해 모든 데이터를 출력한다
                List<String> pList = new ArrayList<>();
                Node nNode = nList.item(temp);

                Element params = (Element) nNode;

                pList.add(getValue("accDefRate", params));
                pList.add(getValue("accExamCnt", params));
                pList.add(getValue("accExamCompCnt", params));
                pList.add(getValue("careCnt", params));
                pList.add(getValue("clearCnt", params));
                pList.add(getValue("createDt", params));
                pList.add(getValue("deathCnt", params));
                pList.add(getValue("decideCnt", params));
                pList.add(getValue("resutlNegCnt", params));
                pList.add(getValue("seq", params));
                pList.add(getValue("stateDt", params));
                pList.add(getValue("stateTime", params));
                pList.add(getValue("updateDt", params));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
       return null;
    }
    //getValue 만들기
    private String getValue(String tag,Element params) {
        NodeList nList = params.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = (Node) nList.item(0);
        if (nValue == null) {
            return null;
        }
        return nValue.getNodeValue();
    }*/



