package com.jbox.model;

import javax.persistence.*;

@Entity
@Table
public class Box {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String boxElementStr;
    @Transient
    private BoxElement[][] boxElements;

    public Box() {
        boxElements = new BoxElement[9][9];
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

    public BoxElement[][] getBoxElements() {
        return boxElements;
    }

    public void setBoxElements(BoxElement[][] boxElements) {
        this.boxElements = boxElements;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
