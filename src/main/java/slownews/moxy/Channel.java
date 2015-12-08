package slownews.moxy;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Channel {

    @XmlElement
    private List<NewsItem> items;

    public List<NewsItem> getItem() {
        return items;
    }

    public void setItem(List<NewsItem> item) {
        this.items = item;
    }
}
