package DataBase;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static play.db.DB.getConnection;

public class DataBaseHandler {


    public static void putArticle(Article article) throws SQLException {
        Connection connection = getConnection("default", true);
        String sqlInsert = "INSERT INTO Articles (name, url) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
        preparedStatement.setString(1, article.getName());
        preparedStatement.setString(2, article.getUrl());
        connection.close();
    }

    public static ArrayNode getUpdates(int offset) throws SQLException {
        ArrayNode arrayArticleList = Json.newArray();
        Connection connection = getConnection("default", true);

        String sqlQuery = "SELECT name, url, offset FROM Articles WHERE offset > ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setInt(1, offset);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            ObjectNode article = Json.newObject();
            article.put("name", resultSet.getString("name"));
            article.put("url", resultSet.getString("url"));
            arrayArticleList.add(article);
        }
        resultSet.close();
        connection.close();
        return arrayArticleList;
    }

    public static int getLastOffset() throws SQLException {
        Connection connection = getConnection("default", true);
        String sqlQuery = "SELECT MAX(offset) AS offset FROM Articles";
        ResultSet resultSet = connection.prepareStatement(sqlQuery).executeQuery();
        int offset = 0;
        while (resultSet.next()) {
            offset = resultSet.getInt("offset");
        }
        connection.close();
        return offset;
    }
}
