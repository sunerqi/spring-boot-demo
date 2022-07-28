package com.sunhl.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: sunhailong
 * @date: 2022/7/11 11:20
 * @desc:
 */
public class JDBCTest {

    private final Logger log = LoggerFactory.getLogger(JDBCTest.class);

    public List<Map> connect(String sql) throws SQLException {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Map> list = new ArrayList<>();
        try {
            //1. 加载驱动
            Class.forName("com.mysql.jdbc.Driver");//固定写法
            //2. 用户信息和url
            //useUnicode=true&characterEncoding=utf8&&useSSL=true
            String url = "jdbc:mysql://localhost:3306/springboot-demo?useUnicode=true&characterEncoding=utf8&&useSSL=false&serverTimezone=UTC&amp";
            String name = "root";
            String password = "moi123456";

            //3. 连接成功，返回数据库对象  connection代表数据库
            connection = DriverManager.getConnection(url, name, password);
            //4. 执行SQL的对象 statement 执行SQL的对象
            statement = connection.createStatement();

            //5. 执行SQL的对象 去执行SQL   可能存在结果，查看返回结果
            resultSet = statement.executeQuery(sql);//返回的结果集,结果集中封装了我们全部查询的结果
            while (resultSet.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", resultSet.getObject("id"));
                map.put("userName", resultSet.getObject("user_name"));
                map.put("birth", resultSet.getObject("date_of_birth"));

                list.add(map);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            //6. 释放连接
            release(connection, statement, resultSet);
        }

        return list;
    }


    public static void release(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (connection != null) {
            connection.close();
        }
        if (statement != null) {
            statement.close();
        }
    }
}
