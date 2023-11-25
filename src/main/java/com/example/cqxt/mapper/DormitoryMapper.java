package com.example.cqxt.mapper;

import com.example.cqxt.beans.Dormitory;

public interface DormitoryMapper {
    int deleteByPrimaryKey(Integer dormitoryId);

    int insert(Dormitory record);

    int insertSelective(Dormitory record);

    Dormitory selectByPrimaryKey(Integer dormitoryId);

    int updateByPrimaryKeySelective(Dormitory record);

    int updateByPrimaryKey(Dormitory record);
}