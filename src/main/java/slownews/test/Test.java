package slownews.test;

import slownews.moxy.Moxy;

import java.net.MalformedURLException;
import java.net.URL;

public class Test {
    public static void main(String[] args) throws MalformedURLException {

        URL url = new URL("http://feeds.bbci.co.uk/news/technology/rss.xml");
        System.out.println(new Moxy().getNewsItems(url));
    }
}
