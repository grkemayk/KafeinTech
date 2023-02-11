package com.storageService.configuration;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.commonModule.entity.HistoryEntity;
import org.commonModule.helper.Logable;
import org.commonModule.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Configuration
@Component
public class AspectConfiguration {
    @Autowired
    HistoryRepository historyRepository;

    @AfterReturning("execution(* com.storageService.controller.StorageController.*(..)) && @annotation(logable)")
    public void afterReturningStorage(JoinPoint jp, Logable logable) throws Throwable {
        HistoryEntity historyEntity = new HistoryEntity();
        historyEntity.setMessage(logable.message());
        historyEntity.setDate(System.currentTimeMillis());
        historyEntity.setHistory(jp.getArgs()[0].toString());
        historyRepository.save(historyEntity);
    }

}
