package com.waffle.vertx.core;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.mongo.MongoClient;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yixiaoshuang
 * @date 2019-09-05 23:07
 */
@Slf4j
public class MyFirstVerticle extends AbstractVerticle {

    @Override
    public void start() {
        vertx.createHttpServer().requestHandler(req -> {

            HttpServerResponse response = req.response();

            JsonObject jsonObject = Vertx.currentContext().config();
            String url = jsonObject.getString("mongo_uri");
            System.out.println("mongo url:" + url);

            JsonObject mongoConfig = new JsonObject().put("connection_string", "mongodb://127.0.0.1:27017")
                    .put("db_name", "seed");
            MongoClient mongoClient = MongoClient.createShared(vertx, mongoConfig, "seed");
            JsonObject product1 = new JsonObject().put("itemId", "12345").put("name", "Cooler").put("price", "100.0");

            mongoClient.save("products", product1, id -> {
                System.out.println("id------------" + id);
                response.putHeader("Content-Type", "text/plain");
                response.end("ok");
            });


        }).listen(8080);
    }
}
