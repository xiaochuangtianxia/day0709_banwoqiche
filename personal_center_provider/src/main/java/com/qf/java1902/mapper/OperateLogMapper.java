package com.qf.java1902.mapper;

import com.qf.java1902.pojo.OperateLog;
import com.qf.java1902.pojo.OperateLogExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface OperateLogMapper {
    int countByExample(OperateLogExample example);

    int deleteByExample(OperateLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OperateLog record);

    int insertSelective(OperateLog record);

    List<OperateLog> selectByExample(OperateLogExample example);

    OperateLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OperateLog record, @Param("example") OperateLogExample example);

    int updateByExample(@Param("record") OperateLog record, @Param("example") OperateLogExample example);

    int updateByPrimaryKeySelective(OperateLog record);

    int updateByPrimaryKey(OperateLog record);
}