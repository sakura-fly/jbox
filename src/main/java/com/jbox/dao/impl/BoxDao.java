package com.jbox.dao.impl;

import com.jbox.model.Box;
import org.springframework.stereotype.Repository;

@Repository
public class BoxDao extends BaseDaoImpl<Box> {
    public BoxDao() {
        super.table = "Box";
    }
}
