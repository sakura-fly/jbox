package com.jbox.model;

import com.google.gson.Gson;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
public class Box {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @Column(columnDefinition="TEXT")
    private String boxElementStr;
    @Transient
    private BoxElement[][] box;

    public Box() {
        box = new BoxElement[9][9];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBoxElementStr() {
        return boxElementStr;
    }

    public void setBoxElementStr(String boxElementStr) {
        System.out.println(boxElementStr);
        this.boxElementStr = boxElementStr;
    }

    public BoxElement[][] getBox() {
        return box;
    }

    public void setBox(BoxElement[][] box) {
        this.box = box;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void init() {
        if (box != null) {
            for (BoxElement[] bes : box) {
                for (BoxElement be : bes) {
                    be.setUid(UUID.randomUUID().toString());
                }
            }
            boxElementStr = new Gson().toJson(box);
        }
    }
}
