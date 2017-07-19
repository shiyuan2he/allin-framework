package com.hsy.entity;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path framework/com.hsy.entity
 * @date 2017/7/15 下午5:51
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class Goods {
    private Integer id ;
    private String name ;
    private Double price ;
    private Integer number ;

    public Goods() {}

    public Goods(Integer id, Integer number) {
        this.id = id;
        this.number = number;
    }

    public Goods(Integer id, Double price) {
        this.id = id;
        this.price = price;
    }

    public Goods(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Goods(String name, Double price, Integer number) {
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public Goods(Integer id, String name, Double price, Integer number) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
