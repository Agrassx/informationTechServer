package controllers;

import DataBase.DataBaseHandler;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.sql.SQLException;

public class Api extends Controller {

    public Result getList(int offset) throws SQLException {
        ObjectNode answerObject = Json.newObject();
        answerObject.put("result", "ok");
        answerObject.put("offset", DataBaseHandler.getLastOffset());
        answerObject.put("articleList", DataBaseHandler.getUpdates(offset));
        return ok(answerObject);
    }
}
