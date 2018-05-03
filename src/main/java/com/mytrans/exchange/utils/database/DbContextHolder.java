package com.mytrans.exchange.utils.database;

/**
 * Created by LiRongJiang on 2017/8/21.
 */
public class DbContextHolder {
    private static final ThreadLocal contextHolder = new ThreadLocal<>();

    /**
     * 设置数据源
     * @param dbTypeEnum
     */
    public static void setDbType(DBTypeEnum dbTypeEnum) {
        contextHolder.set(dbTypeEnum.getValue());
    }

    /**
     * 取得当前数据源
     * @return
     */
    public static Object getDbType() {
        return contextHolder.get();
    }

    /**
     * 清除上下文数据
     */
    public static void clearDbType() {
        contextHolder.remove();
    }
}
