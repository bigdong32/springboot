package com.linesum.example.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 宾馆实体
 * @author wdongsen@linesum.com
 * @data 2017-07-10 14:39
 */
@Setter
@Getter
public class Hotel implements Serializable{

    private static final long serialVersionUID = -3116285258216770541L;

    // id
    private Integer id;

    // namew
    private String name;

    public Hotel(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
