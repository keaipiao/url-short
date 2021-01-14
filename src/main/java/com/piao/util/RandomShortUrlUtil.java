package com.piao.util;

import java.util.Random;

/**
 * @PROJECT_NAME: url-short
 * @USER: Leishen
 * @DATE: 2021/1/8 下午 8:16
 * @DESCRIPTION: 生成随机短链类
 */
public class RandomShortUrlUtil {
    private static final Character [] chars = {
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
            '1','2','3','4','5','6','7','8','9','0'
    };
    private static final Integer charsLength = chars.length;

    public static String getRandomStr(Integer length){
        //创建随机类
        Random random = new Random();
        //创建可变的字符串类
        StringBuilder randomStr = new StringBuilder();
        for(int i = 0;i < length;i++ ){
            //生成随机数
            int index = random.nextInt(charsLength);
            //添加到StringBuilder中
            randomStr.append(chars[index].charValue());
        }
        return randomStr.toString();
    }

}
