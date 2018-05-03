package com.mytrans.exchange.utils.database;

/**
 * Created by LiRongJiang on 2017/8/21.
 */
public enum  DBTypeEnum {
    main_datasource("main_dataSource"),                   //主数据库
    his_datasource("his_dataSource");                   //历史数据库
    private String value;

    DBTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
