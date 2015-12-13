package slownews.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import slownews.moxy.Moxy;

import java.net.MalformedURLException;
import java.net.URL;

public class Test {

    private static Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) throws MalformedURLException {

        URL url = new URL("http://feeds.bbci.co.uk/news/technology/rss.xml");
        logger.info(new Moxy().getNewsItems(url).toString());
    }
}
