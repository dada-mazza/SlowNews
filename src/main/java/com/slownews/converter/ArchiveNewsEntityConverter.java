package com.slownews.converter;

import com.slownews.entity.ArchiveNewsEntity;
import com.slownews.entity.UserEntity;
import com.slownews.moxy.model.NewsItem;

import java.util.HashSet;

public class ArchiveNewsEntityConverter {

    public ArchiveNewsEntity covertNewsItemToArchiveNewsEntity(NewsItem newsItem) {

        ArchiveNewsEntity archiveNewsEntity = new ArchiveNewsEntity();
        archiveNewsEntity.setTitle(newsItem.getTitle());
        archiveNewsEntity.setDescription(newsItem.getDescription());
        archiveNewsEntity.setLink(newsItem.getLink());
        archiveNewsEntity.setPubDate(newsItem.getPubDate());

        if (newsItem.getMedia() != null) {
            if (newsItem.getMedia().size() > 1) {
                archiveNewsEntity.setImage(newsItem.getMedia().get(1));
            } else {
                archiveNewsEntity.setImage(newsItem.getMedia().get(0));
            }
        }
        archiveNewsEntity.setRibbon("★★★★★");
        archiveNewsEntity.setUserEntities(new HashSet<UserEntity>());
        return archiveNewsEntity;
    }
}
