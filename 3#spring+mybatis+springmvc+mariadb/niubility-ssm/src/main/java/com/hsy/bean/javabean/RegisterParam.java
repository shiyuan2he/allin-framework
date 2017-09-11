package com.hsy.bean.javabean;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p></p>
 * @path framework/com.hsy.bean.javabean
 * @date 2017/8/21 21:18
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class RegisterParam extends RequestParamGenericityBean{
    private String name ;
    private String password ;//登陆密码
    private Long tel ;//登陆手机号
    private String sex ;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
