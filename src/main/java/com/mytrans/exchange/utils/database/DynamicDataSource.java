package com.mytrans.exchange.utils.database;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by LiRongJiang on 2017/8/21.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return  DbContextHolder.getDbType();
    }



}
