package com.iteyes.apiautomation.service;

import com.iteyes.apiautomation.domain.ApiManagerDTO;
import com.iteyes.apiautomation.domain.ParameterManagerDTO;
import org.json.JSONException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.List;

public interface ApiService {

    List<ApiManagerDTO> getApiList();

    List<ParameterManagerDTO> getParameterList(String apiId);

    List<String> previewJson(String apiId, List<String> parameterValue) throws Exception;

    String saveJson(String apiId, List<String> parameterValue) throws Exception;


}
