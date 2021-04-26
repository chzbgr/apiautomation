//package com.iteyes.apiautomation.store.jpa;
//
//import com.iteyes.apiautomation.store.repository.ApiManagerRepository;
//import com.iteyes.apiautomation.store.entity.ApiManager;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Repository;
//
//import java.util.*;
//
//@Repository
//public class ApiManagerRepositoryImpl implements ApiManagerRepository {
//
//
//    private static Map<String,ApiManager> store = new HashMap<>();
//
//
//    @Override
//    public List<ApiManager> findAll() {
//        return null;
//    }
//
//    @Override
//    public List<ApiManager> findAll(Sort sort) {
//        return null;
//    }
//
//    @Override
//    public Page<ApiManager> findAll(Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public List<ApiManager> findAllById(Iterable<String> strings) {
//        return null;
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
//
//    @Override
//    public void deleteById(String s) {
//
//    }
//
//    @Override
//    public void delete(ApiManager entity) {
//
//    }
//
//    @Override
//    public void deleteAll(Iterable<? extends ApiManager> entities) {
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
//
//    @Override
//    public <S extends ApiManager> S save(S entity) {
//        return null;
//    }
//
//    @Override
//    public <S extends ApiManager> List<S> saveAll(Iterable<S> entities) {
//        return null;
//    }
//
//    @Override
//    public Optional<ApiManager> findById(String s) {
//        return Optional.empty();
//    }
//
//    @Override
//    public boolean existsById(String s) {
//        return false;
//    }
//
//    @Override
//    public void flush() {
//
//    }
//
//    @Override
//    public <S extends ApiManager> S saveAndFlush(S entity) {
//        return null;
//    }
//
//    @Override
//    public void deleteInBatch(Iterable<ApiManager> entities) {
//
//    }
//
//    @Override
//    public void deleteAllInBatch() {
//
//    }
//
//    @Override
//    public ApiManager getOne(String s) {
//        return null;
//    }
//
//    @Override
//    public <S extends ApiManager> Optional<S> findOne(Example<S> example) {
//        return Optional.empty();
//    }
//
//    @Override
//    public <S extends ApiManager> List<S> findAll(Example<S> example) {
//        return null;
//    }
//
//    @Override
//    public <S extends ApiManager> List<S> findAll(Example<S> example, Sort sort) {
//        return null;
//    }
//
//    @Override
//    public <S extends ApiManager> Page<S> findAll(Example<S> example, Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public <S extends ApiManager> long count(Example<S> example) {
//        return 0;
//    }
//
//    @Override
//    public <S extends ApiManager> boolean exists(Example<S> example) {
//        return false;
//    }
//}
