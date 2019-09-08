package com.waffle.vertx.core;

import io.vertx.core.AbstractVerticle;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yixiaoshuang
 * @date 2019-09-05 23:07
 */
@Slf4j
public class MyFirstVerticle extends AbstractVerticle {

    @Override
    public void start() {
        vertx.createHttpServer().requestHandler(req ->
                req.response().putHeader("content-type", "text/plain")
                        .end("hello world222")).listen(8080);
    }
}
