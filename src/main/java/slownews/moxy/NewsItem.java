package slownews.moxy;

public class NewsItem {

    private String title;

    private String description;

    private String link;

    private String pubDate;

    private String media;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }


    @Override
    public String toString() {

        return new StringBuilder()
                .append("\nNewsItem\n")
                .append("title: ").append(title).append("\n")
                .append("description: ").append(description).append("\n")
                .append("link: ").append(link).append("\n")
                .append("pubDate: ").append(pubDate).append("\n")
                .append("media: ").append(media)
                .toString();
    }
}
