package com.slownews.moxy;

import com.slownews.moxy.model.NewsItem;
import org.eclipse.persistence.jaxb.JAXBContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URL;
import java.util.List;

public class Moxy {

    private static Logger logger = LoggerFactory.getLogger(Moxy.class);

    public List<NewsItem> getNewsItems(URL url) throws JAXBException {
        JAXBContext context = JAXBContextFactory.createContext(new Class[]{RSS.class}, null);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        RSS rss = (RSS) unmarshaller.unmarshal(url);
        return rss.getNewsItems();
    }

    public List<NewsItem> getNewsItems(File file) {
        RSS rss = null;
        try {
            JAXBContext context = JAXBContextFactory.createContext(new Class[]{RSS.class}, null);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            rss = (RSS) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            logger.error(e.getMessage());
        }
        return rss.getNewsItems();
    }

    public String getLastNewsTitle(URL url) throws JAXBException {
        return getNewsItems(url).get(0).getTitle();
    }

    public String getLastNewsTitle(File file) {
        return getNewsItems(file).get(0).getTitle();
    }
}