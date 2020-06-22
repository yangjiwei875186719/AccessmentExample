package com.example.service;

import com.example.entity.Record;

/**
 * @author ：root
 * @date ：Created in 2020/5/14 16:37
 * @description：
 * @modified By：
 */
public interface RecordService {

    /**
     * 查询数据
     * @param no
     * @return
     */
    Record queryRecord(String no);

    /**
     * 保存数据
     * @param record
     * @return
     */
    Integer lending(Record record);
}
