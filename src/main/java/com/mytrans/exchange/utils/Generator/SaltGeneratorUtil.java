package com.mywind.windfarmplan.utils.Generator;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by LiRongJiang on 2017/4/21.
 */
public class SaltGeneratorUtil {

    public static String generator(int length) {
        String result = RandomStringUtils.random(length, Boolean.TRUE, Boolean.TRUE);

        return result;
    }
}
