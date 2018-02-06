package com.wind.entity;

import java.io.Serializable;
import java.util.Date;



/**
 *
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-01-17 15:46:54
 */
public class CoupletEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private String id;
    //
    private String number;
    //
    private String theme;
    //
    private String couplet;
    //
    private String name;
    //
    private String desc;
    //
    private String content;
    //
    private String according;
    //
    private String size1;
    //
    private String size2;
    //
    private String size3;
    //
    private String size4;
    //
    private String pakeType;

    /**
     * 设置：
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * 获取：
     */
    public String getId() {
        return id;
    }
    /**
     * 设置：
     */
    public void setNumber(String number) {
        this.number = number;
    }
    /**
     * 获取：
     */
    public String getNumber() {
        return number;
    }
    /**
     * 设置：
     */
    public void setTheme(String theme) {
        this.theme = theme;
    }
    /**
     * 获取：
     */
    public String getTheme() {
        return theme;
    }
    /**
     * 设置：
     */
    public void setCouplet(String couplet) {
        this.couplet = couplet;
    }
    /**
     * 获取：
     */
    public String getCouplet() {
        return couplet;
    }
    /**
     * 设置：
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 获取：
     */
    public String getName() {
        return name;
    }
    /**
     * 设置：
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }
    /**
     * 获取：
     */
    public String getDesc() {
        return desc;
    }
    /**
     * 设置：
     */
    public void setContent(String content) {
        this.content = content;
    }
    /**
     * 获取：
     */
    public String getContent() {
        return content;
    }
    /**
     * 设置：
     */
    public void setAccording(String according) {
        this.according = according;
    }
    /**
     * 获取：
     */
    public String getAccording() {
        return according;
    }
    /**
     * 设置：
     */
    public void setSize1(String size1) {
        this.size1 = size1;
    }
    /**
     * 获取：
     */
    public String getSize1() {
        return size1;
    }
    /**
     * 设置：
     */
    public void setSize2(String size2) {
        this.size2 = size2;
    }
    /**
     * 获取：
     */
    public String getSize2() {
        return size2;
    }
    /**
     * 设置：
     */
    public void setSize3(String size3) {
        this.size3 = size3;
    }
    /**
     * 获取：
     */
    public String getSize3() {
        return size3;
    }
    /**
     * 设置：
     */
    public void setSize4(String size4) {
        this.size4 = size4;
    }
    /**
     * 获取：
     */
    public String getSize4() {
        return size4;
    }
    /**
     * 设置：
     */
    public void setPakeType(String pakeType) {
        this.pakeType = pakeType;
    }
    /**
     * 获取：
     */
    public String getPakeType() {
        return pakeType;
    }
}
