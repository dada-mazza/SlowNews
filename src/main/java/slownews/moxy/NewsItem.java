
package slownews.moxy;

import org.eclipse.persistence.oxm.annotations.XmlPath;

import java.net.URL;
import java.util.List;

public class NewsItem {

    @XmlPath("title/text()")
    private String title;

    @XmlPath("description/text()")
    private String description;

    @XmlPath("link/text()")
    private String link;

    @XmlPath("pubDate/text()")
    private String pubDate;

    @XmlPath("media:thumbnail/@url")
    private List<URL> media;

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

    public List<URL> getMedia() {
        return media;
    }

    public void setMedia(List<URL> media) {
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
