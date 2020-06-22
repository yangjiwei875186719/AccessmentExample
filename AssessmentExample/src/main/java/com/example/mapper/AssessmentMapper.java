package com.example.mapper;

import com.example.entity.Assessment;

/**
 * 2020/5/7 13:11
 * root
 */
public interface AssessmentMapper {

    /**
     * 通过身份证号查询assessment表中的数据
     * @param no
     * @return
     */
    Assessment selectByNo(String no);

    /**
     * 保存数据到assessment表中
     * @param assessment
     * @return
     */
    Integer saveAssessment(Assessment assessment);

    /**
     * 更新数据
     * @param assessment
     * @return
     */
    Integer updateAssessment(Assessment assessment);

}
