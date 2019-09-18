package com.jbox.controller;

import com.jbox.dao.BaseDao;
import com.jbox.model.Box;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/box")
public class BoxController extends BaseController<Box> {


    public BoxController(BaseDao<Box> baseDao) {
        super(baseDao);
    }

    @Override
    public int add(@RequestBody Box box) {
        box.init();
        return super.add(box);
    }

    @Override
    public List<Box> list(Box box) {

        return super.list(box);
    }
}
