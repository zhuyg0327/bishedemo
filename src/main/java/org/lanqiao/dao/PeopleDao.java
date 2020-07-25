package org.lanqiao.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.model.People;

import java.util.List;
import java.util.Map;

@Mapper
public interface PeopleDao {
     //查询所有用户
     List<People> queryall();
}
