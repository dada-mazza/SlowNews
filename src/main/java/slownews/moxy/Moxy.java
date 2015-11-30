package slownews.moxy;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.net.URL;
import java.util.List;

public class Moxy {

    public List<NewsItem> getNewsItems(URL url) {
        RSS rss = null;
        try {
            JAXBContext context = JAXBContext.newInstance(RSS.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            rss = (RSS) unmarshaller.unmarshal(url);
            System.out.println(rss);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return rss.getChannel().getItem();
    }
}