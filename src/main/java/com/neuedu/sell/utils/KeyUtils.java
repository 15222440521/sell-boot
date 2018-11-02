package com.neuedu.sell.utils;


import java.util.Random;

//生成订单详情id
public class KeyUtils {

    /**
     * 通过随机数（6位）+ 日期的
     * @return
     */
    //定义一个静态方法  优先加载 并通过调用类名调用  此id必须唯一
    //加个多线程的锁 synchronized 避免同时执行  生成重复的数
    public static synchronized String generateUniqueKey(){
     System.currentTimeMillis();  //获取当前时间
        Random random = new Random();
        int numder = random.nextInt(900000)+100000;
        return String.valueOf(System.currentTimeMillis())+numder;
    }
}
