package org.hsy.entity;
import java.util.Date;
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
    private Integer id ;
    private Integer goodsId ;
    private Integer salespersonId ;
    private Integer number ;
    private Date salesTime ;

    public GoodsSalesperson() {}

    public GoodsSalesperson(Integer id, Integer goodsId, Integer salespersonId) {
        this.id = id;
        this.goodsId = goodsId;
        this.salespersonId = salespersonId;
    }
    public GoodsSalesperson(Integer id, Integer goodsId, Integer salespersonId, Integer number) {
        this.id = id;
        this.goodsId = goodsId;
        this.salespersonId = salespersonId;
        this.number = number;
    }

    public GoodsSalesperson(Integer id, Integer goodsId, Integer salespersonId, Integer number, Date salesTime) {
        this.id = id;
        this.goodsId = goodsId;
        this.salespersonId = salespersonId;
        this.number = number;
        this.salesTime = salesTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getSalespersonId() {
        return salespersonId;
    }

    public void setSalespersonId(Integer salespersonId) {
        this.salespersonId = salespersonId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Date getSalesTime() {
        return salesTime;
    }

    public void setSalesTime(Date salesTime) {
        this.salesTime = salesTime;
    }
}
