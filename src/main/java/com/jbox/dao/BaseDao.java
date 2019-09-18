package com.jbox.dao;


import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BaseDao<T> {

    int add(T t);

    List<T> list(T t);


}
