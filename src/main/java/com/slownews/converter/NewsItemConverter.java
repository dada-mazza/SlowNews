package com.slownews.converter;

import com.slownews.entity.ArchiveNewsEntity;
import com.slownews.moxy.model.NewsItem;

public class NewsItemConverter {

    public ArchiveNewsEntity covertNewsItemToArchiveNewsEntity(NewsItem newsItem) {

        ArchiveNewsEntity archiveNewsEntity = new ArchiveNewsEntity();
        archiveNewsEntity.setTitle(newsItem.getTitle());
        if (newsItem.getMedia() != null) {
            if (newsItem.getMedia().size() > 1) {
                archiveNewsEntity.setImage(newsItem.getMedia().get(1));
            } else {
                archiveNewsEntity.setImage(newsItem.getMedia().get(0));
            }
        }
        archiveNewsEntity.setFirstParagraph(newsItem.getDescription());
        archiveNewsEntity.setBody(newsItem.getDescription());
        archiveNewsEntity.setPubDate(newsItem.getPubDate());
        archiveNewsEntity.setRibbon("★★★★★");
        return archiveNewsEntity;
    }
}
