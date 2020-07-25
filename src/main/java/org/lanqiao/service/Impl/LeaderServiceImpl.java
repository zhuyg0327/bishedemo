package org.lanqiao.service.Impl;

import org.lanqiao.dao.LeaderDao;
import org.lanqiao.dao.PeopleDao;
import org.lanqiao.model.Leader;
import org.lanqiao.model.People;
import org.lanqiao.service.LeaderService;
import org.lanqiao.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class LeaderServiceImpl implements LeaderService {
    @Autowired
    LeaderDao dao;

    //查询所有
    @Override
    public List<Leader> queryAll() {
            List<Leader> leader=dao.queryall();
            return leader;
    }
}
