package slownews.moxy;

import org.eclipse.persistence.jaxb.JAXBContextFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.net.URL;
import java.util.List;

public class Moxy {

    public List<NewsItem> getNewsItems(URL url) {
        RSS rss = null;
        try {
            JAXBContext context = JAXBContextFactory.createContext(new Class[]{RSS.class}, null);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            rss = (RSS) unmarshaller.unmarshal(url);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return rss.getNewsItems();
    }
}