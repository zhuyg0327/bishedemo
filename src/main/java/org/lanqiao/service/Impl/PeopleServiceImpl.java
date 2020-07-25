package org.lanqiao.service.Impl;

import org.lanqiao.dao.PeopleDao;
import org.lanqiao.model.People;
import org.lanqiao.model.User;
import org.lanqiao.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Primary
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    PeopleDao dao;

    //查询所有
    @Override
    public List<People> queryAll() {
            List<People> people=dao.queryall();
            return people;
    }
}
