package com.hsy.entity;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path framework/com.hsy.entity
 * @date 2017/7/15 下午5:54
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class GoodsSalesperson {
    private Long id ;
    private Long goodsId ;
    private Long salespersonId ;
    private Integer number ;

    public GoodsSalesperson() {}

    public GoodsSalesperson(Long id, Long goodsId, Long salespersonId) {
        this.id = id;
        this.goodsId = goodsId;
        this.salespersonId = salespersonId;
    }

    public GoodsSalesperson(Long id, Long salespersonId, Integer number) {
        this.id = id;
        this.salespersonId = salespersonId;
        this.number = number;
    }

    public GoodsSalesperson(Long id, Long goodsId, Long salespersonId, Integer number) {
        this.id = id;
        this.goodsId = goodsId;
        this.salespersonId = salespersonId;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getSalespersonId() {
        return salespersonId;
    }

    public void setSalespersonId(Long salespersonId) {
        this.salespersonId = salespersonId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
