package com.example.cqxt.mapper;

import java.util.List;

import com.example.cqxt.beans.DailyCheck;

public interface DailyCheckMapper {
    int deleteByPrimaryKey(Integer checkId);

    int insert(DailyCheck record);

    int insertSelective(DailyCheck record);

    DailyCheck selectByPrimaryKey(Integer checkId);

    int updateByPrimaryKeySelective(DailyCheck record);

    int updateByPrimaryKey(DailyCheck record);

    List<DailyCheck> selectByStudentId(Integer studentId);
}