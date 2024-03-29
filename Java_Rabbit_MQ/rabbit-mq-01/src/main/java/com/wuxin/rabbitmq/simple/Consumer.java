package com.wuxin.rabbitmq.simple;

import com.rabbitmq.client.*;
import com.wuxin.rabbitmq.util.RabbitMQUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Author: wuxin001
 * @Description:
 */
public class Consumer {

    public static void main(String[] args) {
        // ip port
        // 1、创建连接工程
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 2、创建连接connection
        connectionFactory.setHost("192.168.56.40");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setVirtualHost("/");
        // 3、获取连接通道
        Connection connection = null;
        Channel channel = null;
        try {
            // 创建连接 connection
            connection = connectionFactory.newConnection("消费者");
            // 创建channel连接通道
            channel = connection.createChannel();
            String queueName = "fanout_queue1";
            /**
             * 参数说明
             * @params1 队列名称
             * @params2 是否持久化
             * @params3 排他性，是否独立（是否是一个独占队列）
             * @params4 是否自动删除，随着最后一个消费者消息完毕以后是否自动把队列自动删除
             * @params5 携带附带参数
             */
            channel.queueDeclare(queueName, false, false, false, null);
            // 准备发送消息内容
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(RabbitMQUtil.date() + " 接受消息: '" + message + "'");
            };
            channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
            });


            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 7、关闭通道
            RabbitMQUtil.close(channel);
            // 8、关闭连接
            RabbitMQUtil.close(connection);
        }

    }

}
