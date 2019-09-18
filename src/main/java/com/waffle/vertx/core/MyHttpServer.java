package com.waffle.vertx.core;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;

/**
 * @author yixiaoshuang
 * @date 2019-09-18 09:02
 */
public class MyHttpServer extends AbstractVerticle {
    public static void main(String[] args) {
        // 创建服务
        MyHttpServer verticle = new MyHttpServer();
        Vertx vertx = Vertx.vertx();

        // 部署服务，会执行MyHttpServer的start方法
        vertx.deployVerticle(verticle);
    }

    @Override
    public void start() throws Exception {
        // 在这里可以通过this.vertx获取到当前的Vertx
        Vertx vertx = this.vertx;

        System.out.println("2222");
        // 创建一个HttpServer
        HttpServer server = vertx.createHttpServer();

        server.requestHandler(request -> {
            System.out.println("333");
            // 获取到response对象
            HttpServerResponse response = request.response();

            // 设置响应头
            response.putHeader("Content-type", "text/html;charset=utf-8");

            // 响应数据
            response.end("SUCCESS");

        });

        // 指定监听80端口
        server.listen(8800);
    }
}
