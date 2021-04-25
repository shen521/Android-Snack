package com.example.android_snack;

import java.security.PublicKey;

/**
 * The type Macro：宏的定义
 */
public class Macro {
    /**
     * The constant Up：定义小蛇头部方向向上
     */
    public static final int Up=0x11;
    /**
     * The constant Dwon：定义小蛇头部方向向下
     */
    public static final int Dwon=0x12;
    /**
     * The constant Left：定义小蛇头部方向向左
     */
    public static final int Left=0x13;
    /**
     * The constant Right：定义小蛇头部方向向右
     */
    public static final int Right=0x14;
    /**
     * The constant UNIT：定义小蛇移动的基本单位
     */
    public static final int UNIT=50;
    /**
     * The constant LEAST_SIZE：小蛇生活区最小单位
     */
    public static final int LEAST_SIZE=1;
    /**
     * The constant DELAY：定时器响应run延时
     */
    public static final int DELAY=100;
    /**
     * The constant PERIOD：定时器启动的间隔时间
     */
    public static final int PERIOD=500;
    /**
     * The constant INIT_SNACKX：小蛇初始头部的X坐标
     */
    public static final int INIT_SNACKX=600;
    /**
     * The constant INIT_SNACKY：小蛇初始头部的Y坐标
     */
    public static final int INIT_SNACKY=400;
    /**
     * The constant INIT_FOODX：食物初始的X坐标
     */
    public static final int INIT_FOODX=900;
    /**
     * The constant INIT_FOODY：食物初始的Y坐标
     */
    public static final int INIT_FOODY=400;
    /**
     * The constant INIT_LENGHT：小蛇初始长度
     */
    public static final int INIT_LENGHT=3;
    /**
     * The constant IMAGE_HEAD_SIZE：小蛇头图片缩小倍数
     */
    public static final int IMAGE_HEAD_SIZE=20;
    /**
     * The constant IMAGE_BODY_SIZE：小蛇身体图片缩小倍数
     */
    public static final int IMAGE_BODY_SIZE=46;
    /**
     * The constant SCORE_UNIT：每次加分
     */
    public static final int SCORE_UNIT=10;
    /**
     * The constant MAX_LENGHT：小蛇最大长度
     */
    public static final int MAX_LENGHT=900;
    /**
     * The constant MAX_LENGHT：小蛇吃到食物就会加速的基本单位
     */
    public static final int SPEED=30;
    /**
     * The constant MAX_LENGHT：小蛇吃到食物就会加速的基本单位
     */
    public static final int FOOD=30;
    /**
     * The constant MAX_LENGHT：小蛇吃到食物就会加速的基本单位
     */
    public static final int MAX_DSPEED=400;

    /**
     * The constant SCORE：此局的分数显示
     */
    public static final String SCORE="分数：";
    /**
     * The constant MOST_SCORE：历史最高分数显示
     */
    public static final String MOST_SCORE="最高分数：";
    /**
     * The constant H_MOST_SCORE：主界面查询分数显示
     */
    public static final String H_MOST_SCORE="最高分数(点击更新)：";
    /**
     * The constant Pname：分数存储文件名
     */
    public static final String Pname="scorefile";
}
