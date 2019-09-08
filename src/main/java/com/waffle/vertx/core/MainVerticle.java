package com.waffle.vertx.core;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yixiaoshuang
 * @date 2019-09-06 00:12
 */
@Slf4j
public class MainVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        vertx.deployVerticle(MyFirstVerticle.class.getName());
    }

    /**
     * 异步版本:不要在start方法中,阻塞等待其它的Verticle创建完成
     *
     * @param startFuture Future
     */
    @Override
    public void start(Future<Void> startFuture) throws Exception {
        //部署其它verticle
        vertx.deployVerticle("com.waffle.vertx.core.MyFirstVerticle", res -> {
            if (res.succeeded()) {
                System.out.println("success");
            } else {
                System.out.println("failed");
            }
        });
    }
}
