package com.waffle.vertx.core;

import io.vertx.core.AbstractVerticle;

/**
 * @author yixiaoshuang
 * @date 2019-09-05 23:07
 */
public class MyFirstVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        vertx.createHttpServer().requestHandler(req ->{
            req.response().putHeader("content-type","text/plain")
                    .end("hello world222");
        }).listen(8080);
    }
}
