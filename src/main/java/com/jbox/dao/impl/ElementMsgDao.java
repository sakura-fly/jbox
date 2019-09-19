package com.jbox.dao.impl;

import com.jbox.model.ElementMsg;
import org.springframework.stereotype.Repository;

@Repository
public class ElementMsgDao extends BaseDaoImpl<ElementMsg> {
    public ElementMsgDao() {
        super.table = "ElementMsg";
    }
}
