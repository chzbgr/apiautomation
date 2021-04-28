package com.iteyes.apiautomation.service;

import com.iteyes.apiautomation.domain.RequestFormDTO;
import org.json.JSONException;
import org.json.simple.parser.ParseException;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.URL;
import java.util.List;


public interface RequestService {

    List<String> showPreview(String apiId, List<String> parameterValue) throws IOException, JSONException;
}
