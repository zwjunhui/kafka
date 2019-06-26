package com.springboot.kafka.constant;

/**
 * @Description: kafka的常量类
 * @Author:  wyjunhui
 * @UpdateDate: 2019/6/25 10:36
 * @Version: 1.0
 */
public class KafkaMesConstant {
    /*public static final String GROUP="spring.kafka.newGroup";
    public static final String SIMPLE="spring.kafka.simple";
    public static final String BEAN="spring.kafka.topic.Name";
*/
    public static final String SUCCESS_CODE = "00000";
    public static final String SUCCESS_MES = "成功";

    /*kakfa-code*/
    public static final String KAFKA_SEND_ERROR_CODE = "30001";
    public static final String KAFKA_NO_RESULT_CODE = "30002";
    public static final String KAFKA_NO_OFFSET_CODE = "30003";

    /*kakfa-mes*/
    public static final String KAFKA_SEND_ERROR_MES = "发送消息超时,联系相关技术人员";
    public static final String KAFKA_NO_RESULT_MES = "未查询到返回结果,联系相关技术人员";
    public static final String KAFKA_NO_OFFSET_MES = "未查到返回数据的offset,联系相关技术人员";
}
