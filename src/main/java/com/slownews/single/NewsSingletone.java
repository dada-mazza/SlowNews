package com.slownews.single;

import com.slownews.model.ArchiveNews;

import java.util.ArrayList;
import java.util.List;


public class NewsSingletone {

    private static NewsSingletone instance;

    private List<ArchiveNews> archiveNewses;

    private NewsSingletone() {
        archiveNewses = new ArrayList<ArchiveNews>();

        ArchiveNews archiveNews1 = new ArchiveNews();
        archiveNews1.setTitle("Alibaba in Singles Day sales clash");
        archiveNews1.setImage("../img/news.xml/alibaba.jpg");
        archiveNews1.setFirstParagraph("China's two largest internet retailers have clashed in the run-up to Singles Day," +
                " the world's biggest online sales day, on 11 November.");
        archiveNews1.setBody("China's two largest internet retailers have clashed in the run-up to Singles Day," +
                " the world's biggest online sales day, on 11 November.");
        archiveNews1.setRibbon("★★★★★");


        ArchiveNews archiveNews2 = new ArchiveNews();
        archiveNews2.setTitle("Anonymous posts Ku Klux Klan alleged sympathisers list");
        archiveNews2.setImage("../img/news.xml/anonimus.jpg");
        archiveNews2.setFirstParagraph("The hackers' collective Anonymous has shared details of hundreds of alleged" +
                " sympathisers of the white supremacist Ku Klux Klan (KKK) on the internet.");
        archiveNews2.setBody("The hackers' collective Anonymous has shared details of hundreds of alleged" +
                " sympathisers of the white supremacist Ku Klux Klan (KKK) on the internet.");
        archiveNews2.setRibbon("★★");

        ArchiveNews archiveNews3 = new ArchiveNews();
        archiveNews3.setTitle("Greenpeace loses Indian registration");
        archiveNews3.setImage("../img/news.xml/greenpeace.jpg");
        archiveNews3.setFirstParagraph("Greenpeace says its charitable registration to operate in India has been revoked.");
        archiveNews3.setBody("Greenpeace says its charitable registration to operate in India has been revoked.");
        archiveNews3.setRibbon("★★★★");

        archiveNewses.add(archiveNews1);
        archiveNewses.add(archiveNews2);
        archiveNewses.add(archiveNews3);

    }

    public synchronized static NewsSingletone getInstance() {
        if (instance == null) {
            instance = new NewsSingletone();
        }
        return instance;

    }

    public synchronized List<ArchiveNews> getArchiveNewses() {
        return archiveNewses;
    }

}
