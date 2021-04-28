package com.iteyes.apiautomation.service;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mainRepo")
public interface urlCreateService {

    public List<String> showPreview(String apiId,List<String> keyArr,List<String> valueArr);

}
