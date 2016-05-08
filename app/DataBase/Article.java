package DataBase;

public class Article {

    private String url;
    private String name;


    public Article(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

}
