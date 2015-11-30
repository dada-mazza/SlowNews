package slownews.moxy;

import java.util.List;

public class Channel {

    private List<NewsItem> items;

    public List<NewsItem> getItem() {
        return items;
    }

    public void setItem(List<NewsItem> item) {
        this.items = item;
    }
}
