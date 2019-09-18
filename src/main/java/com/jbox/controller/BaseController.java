package com.jbox.controller;

import com.jbox.dao.BaseDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class BaseController<T> {

    private BaseDao<T> baseDao;

    public BaseController(BaseDao<T> baseDao) {
        this.baseDao = baseDao;
    }

    @GetMapping
    @ResponseBody
    public List<T> list(T t) {
        return baseDao.list(t);
    }

    @PostMapping
    @ResponseBody
    public int add(T t) {
        return baseDao.add(t);
    }


}
