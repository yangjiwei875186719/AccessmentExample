package com.example.mapper;

import com.example.entity.Record;
import org.apache.ibatis.annotations.Param;

/**
 * @author ：root
 * @date ：Created in 2020/5/14 16:17
 * @description：
 * @modified By：
 */
public interface RecordMapper {

    /**
     * 通过身份证号查数据
     * @param no
     * @return
     */
    Record selectRecordByNo(@Param("no") String no);

    /**
     * 保存数据
     * @param record
     * @return
     */
    Integer saveRecord(@Param("record") Record record);
}
