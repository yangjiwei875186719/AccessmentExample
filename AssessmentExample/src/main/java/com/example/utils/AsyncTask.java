package com.example.utils;

import com.example.spark.AssessmentAnalysis;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author ：root
 * @date ：Created in 2020/5/15 8:01
 * @description：
 * @modified By：
 */
@Component
public class AsyncTask {

    @Async
    public void doTask(){
        AssessmentAnalysis.main(null);
    }
}
