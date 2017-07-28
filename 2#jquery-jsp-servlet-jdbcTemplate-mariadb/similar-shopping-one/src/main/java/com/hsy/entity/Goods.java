package com.hsy.entity;

import java.util.Date;

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
    private Date groundingTime ;//上架时间
    private Date undercarriageTime ;//下架时间
    private Integer state ;// 0-初始状态 1-上架 2-下架
    private Date createTime ;
    private Date createUser ;
    private Date updateTime ;
    private Date updateUser ;

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

    public Date getGroundingTime() {
        return groundingTime;
    }

    public void setGroundingTime(Date groundingTime) {
        this.groundingTime = groundingTime;
    }

    public Date getUndercarriageTime() {
        return undercarriageTime;
    }

    public void setUndercarriageTime(Date undercarriageTime) {
        this.undercarriageTime = undercarriageTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Date createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Date updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", number=" + number +
                '}';
    }
}
