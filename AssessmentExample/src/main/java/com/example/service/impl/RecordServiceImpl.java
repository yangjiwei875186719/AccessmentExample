package com.example.service.impl;

import com.example.entity.Record;
import com.example.entity.UserInfo;
import com.example.entity.UserSalesman;
import com.example.mapper.RecordMapper;
import com.example.mapper.UserInfoMapper;
import com.example.mapper.UserSalesmanMapper;
import com.example.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：root
 * @date ：Created in 2020/5/14 16:38
 * @description：
 * @modified By：
 */
@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private UserSalesmanMapper userSalesmanMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private RecordMapper recordMapper;

    @Override
    public Record queryRecord(String no) {
        //根据no查询record
        Record record = recordMapper.selectRecordByNo(no);

        //根据no查询userinfo
        UserInfo userInfo = userInfoMapper.selectByNo(no);
        if(record==null || record.getSalesmanId() == null){
            return null;
        }
        //根据salesman_id  查询salesman
        UserSalesman userSalesman = userSalesmanMapper.selectUserSalemanById(record.getSalesmanId());
        if(userInfo==null || userInfo.getName() == null || userSalesman == null || userSalesman.getName() == null){
            return null;
        }
        //存入业务员name
        record.setSalesmanName(userSalesman.getName());
        record.setPhoto(userInfo.getUserPhotos());
        //存入username
        record.setUserName(userInfo.getName());
        return record;
    }

    /**
     * 保存数据
     *
     * @param record
     * @return
     */
    @Override
    public Integer lending(Record record) {
        Integer integer = recordMapper.saveRecord(record);
        return integer;
    }
}
