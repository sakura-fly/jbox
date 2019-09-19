package com.jbox.controller;

import com.jbox.dao.BaseDao;
import com.jbox.dao.impl.ElementMsgDao;
import com.jbox.model.ElementMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/msg")
public class MsgController extends BaseController<ElementMsg> {


    public MsgController(ElementMsgDao dao) {
        super(dao);
    }
}
