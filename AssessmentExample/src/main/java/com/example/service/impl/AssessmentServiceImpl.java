package com.example.service.impl;


import com.example.entity.Assessment;
import com.example.entity.Record;
import com.example.entity.UserInfo;
import com.example.mapper.AssessmentMapper;
import com.example.mapper.RecordMapper;
import com.example.service.AssessmentService;

import com.example.spark.AssessmentAnalysis;
import com.example.spark.DataConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 2020/5/7 14:00
 * root
 */
@Service
public class AssessmentServiceImpl implements AssessmentService {

    @Autowired
    private AssessmentMapper assessmentMapper;

    @Autowired
    private RecordMapper recordMapper;

    /**
     * 数据处理
     * @param userInfo
     * @return
     */
    @Override
    public Assessment handler(UserInfo userInfo) {
        //数据处理
        DataConversion myTest = new DataConversion();
        Assessment assessment = myTest.dataAnaylize(userInfo);
        return assessment;
    }

    @Override
    public Assessment selectByNo(String no) {
        Assessment assessment = assessmentMapper.selectByNo(no);
        Record record = recordMapper.selectRecordByNo(no);
        if(record!=null){
            assessment.setRemarks("已被放贷，金额：￥" + record.getLoan());
        }
        return assessment;
    }



}
