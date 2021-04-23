package com.iteyes.apiautomation.store.jpa;

import com.iteyes.apiautomation.store.StoreExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StoreExampleImpl implements StoreExample {

    @Autowired
    private ApiRepository apiRepository;

    @Override
    public List<String> findAll(String data) {

        return null;
    }
}
