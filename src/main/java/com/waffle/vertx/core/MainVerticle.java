package com.waffle.vertx.core;

import io.vertx.core.AbstractVerticle;

/**
 * @author yixiaoshuang
 * @date 2019-09-06 00:12
 */
public class MainVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        vertx.deployVerticle(MyFirstVerticle.class.getName());
    }
}
