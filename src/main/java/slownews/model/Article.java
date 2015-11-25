package slownews.model;

public class Article {

    private String title;
    private String firstParagraph;
    private String body;
    private String image;
    private String ribbon;

    public Article() {
    }

    public Article(String title, String firstParagraph, String body, String image, String ribbon) {
        this.title = title;
        this.firstParagraph = firstParagraph;
        this.body = body;
        this.image = image;
        this.ribbon = ribbon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstParagraph() {
        return firstParagraph;
    }

    public void setFirstParagraph(String firstParagraph) {
        this.firstParagraph = firstParagraph;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRibbon() {
        return ribbon;
    }

    public void setRibbon(String ribbon) {
        this.ribbon = ribbon;
    }
}
