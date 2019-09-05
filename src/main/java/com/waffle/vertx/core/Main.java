package com.waffle.vertx.core;

import io.vertx.core.Vertx;

/**
 * @author yixiaoshuang
 * @date 2019-09-05 23:06
 */
public class Main {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(MyFirstVerticle.class.getName());
    }
}
