package com.slownews.entity;

import javax.persistence.*;
import java.net.URL;
import java.util.Set;

@Entity
@Table(name = "archive")

@NamedQueries({
        @NamedQuery(name = "ArchiveNewsEntity.getAll",
                query = "select archiveNews from ArchiveNewsEntity archiveNews"),
        @NamedQuery(name = "ArchiveNewsEntity.getArchiveNewsEntityByTitle",
                query = "select archiveNews from ArchiveNewsEntity archiveNews" +
                        " where archiveNews.title = :title"),
        @NamedQuery(name = "ArchiveNewsEntity.getAllArchiveNewsesForUser",
                query = "select archiveNews from ArchiveNewsEntity archiveNews" +
                        " inner join archiveNews.userEntities user" +
                        " where user.Id = :userId")
})

public class ArchiveNewsEntity implements SlowNewsEntity {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "archive_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "id")
    private Long Id;

    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @Column(name = "description", unique = true, nullable = false)
    private String description;

    @Column(name = "link")
    private URL link;

    @Column(name = "pubDate")
    private String pubDate;

    @Column(name = "image")
    private URL image;

    @Column(name = "body")
    private String body;

    @Column(name = "ribbon")
    private String ribbon;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<UserEntity> userEntities;

    public ArchiveNewsEntity() {
    }

    @Override
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

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

    public URL getLink() {
        return link;
    }

    public void setLink(URL link) {
        this.link = link;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public URL getImage() {
        return image;
    }

    public void setImage(URL image) {
        this.image = image;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getRibbon() {
        return ribbon;
    }

    public void setRibbon(String ribbon) {
        this.ribbon = ribbon;
    }

    public Set<UserEntity> getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(Set<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }

    @Override
    public String toString() {
        return "ArchiveNewsEntity{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                ", pubDate='" + pubDate + '\'' +
                ", image=" + image +
                ", body='" + body + '\'' +
                ", ribbon='" + ribbon + '\'' +
                ", userEntities=" + userEntities +
                '}';
    }
}
