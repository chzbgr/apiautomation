package com.iteyes.apiautomation.service;

import org.apache.http.client.ClientProtocolException;
import org.springframework.stereotype.Repository;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

@Repository("mainRepo")
public interface urlCreateService {

    List<String> showPreview(String apiId,List<String> keyArr,List<String> valueArr) throws IOException, URISyntaxException, ParserConfigurationException, SAXException;

}


