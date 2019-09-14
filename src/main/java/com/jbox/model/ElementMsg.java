package com.jbox.model;

import javax.persistence.*;

@Entity
@Table
public class ElementMsg {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String eluid;
    private String msg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEluid() {
        return eluid;
    }

    public void setEluid(String eluid) {
        this.eluid = eluid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
