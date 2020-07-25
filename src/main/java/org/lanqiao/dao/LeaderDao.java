package org.lanqiao.dao;

import org.apache.ibatis.annotations.Mapper;
import org.lanqiao.model.Leader;


import java.util.List;

@Mapper
public interface LeaderDao {
     //查询所有用户
     List<Leader> queryall();
}
