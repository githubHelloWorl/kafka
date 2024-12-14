package com.cmd.kafka.service.impl;

import com.cmd.kafka.mapper.TestMapper;
import com.cmd.kafka.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class TestServiceImpl implements TestService{
    @Autowired
    private TestMapper testMapper;

    @Transactional(rollbackFor = Exception.class)
    public Integer a(Integer a){
        TestServiceImpl testServiceProxy = (TestServiceImpl) AopContext.currentProxy();
        testServiceProxy.b(a);
        testServiceProxy.c(a);
        return a;
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public Integer b(Integer b){
        //...
        return b;
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public Integer c(Integer c){
        //...
        return c;
    }
}
