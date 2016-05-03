package controllers;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class Api extends Controller {

    public Result getList(int offset) {

        ObjectNode answerObject = Json.newObject();
        answerObject.put("result", "ok");
        answerObject.put("offset","0");

        ArrayNode arrayArticleList = Json.newArray();

        ObjectNode article = Json.newObject();
        article.put("Android", "www.exampleAndroid.com");
        arrayArticleList.add(article);

        article = Json.newObject();
        article.put("iPhone", "www.exampleAndroid.com");
        arrayArticleList.add(article);

        article = Json.newObject();
        article.put("WindowsMobile", "www.exampleAndroid.com");
        arrayArticleList.add(article);

        article = Json.newObject();
        article.put("Blackberry", "www.exampleAndroid.com");
        arrayArticleList.add(article);

        article = Json.newObject();
        article.put("WebOS", "www.exampleAndroid.com");
        arrayArticleList.add(article);

        article = Json.newObject();
        article.put("Ubuntu", "www.exampleAndroid.com");
        arrayArticleList.add(article);

        article = Json.newObject();
        article.put("Windows7", "www.exampleAndroid.com");
        arrayArticleList.add(article);

        article = Json.newObject();
        article.put("Max OS X", "www.exampleAndroid.com");
        arrayArticleList.add(article);

        article = Json.newObject();
        article.put("Linux", "www.exampleAndroid.com");
        arrayArticleList.add(article);

        article = Json.newObject();
        article.put("OS/2", "www.exampleAndroid.com");
        arrayArticleList.add(article);

        answerObject.put("articleList", arrayArticleList);

        return ok(answerObject);
    }
}
