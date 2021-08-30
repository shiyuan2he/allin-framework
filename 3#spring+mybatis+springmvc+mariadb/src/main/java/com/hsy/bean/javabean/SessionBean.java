package com.hsy.bean.javabean;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path framework/com.hsy.bean.javabean
 * @date 18/08/2017 11:37 AM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class SessionBean {

    private Long id;
    private String name ;//
    private Long tel ;

    public SessionBean(Long id, String name, Long tel) {
        this.id = id;
        this.name = name;
        this.tel = tel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "SessionBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
