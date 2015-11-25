package slownews.single;

import slownews.model.Article;

import java.util.ArrayList;
import java.util.List;


public class NewsSingletone {

    private static NewsSingletone instance;

    private List<Article> articles;

    private NewsSingletone() {
        articles = new ArrayList<Article>();

        Article article1 = new Article();
        article1.setTitle("Alibaba in Singles Day sales clash");
        article1.setImage("../img/news/alibaba.jpg");
        article1.setFirstParagraph("China's two largest internet retailers have clashed in the run-up to Singles Day," +
                " the world's biggest online sales day, on 11 November.");
        article1.setBody("Alibaba has been accused by its smaller rival JD.com of \"forcing retailers\" to promote" +
                " their sales exclusively with its own outlet, Tmall. JD.com has lodged a complaint with the Chinese" +
                " industry and commerce watchdog but Alibaba denies the allegation. The retail giant claims its rival" +
                " is \"panicking because they're losing\". \"They simply can't match our customer and merchant" +
                " experience and logistical scale because Alibaba wins with customers and merchants as we provide" +
                " a superior experience for users on our platforms,\" said Jim Wilkinson, Alibaba's senior vice " +
                "president of international corporate affairs. The Wall Street Journal reported that a shoe retailer" +
                " called Mulinsen had declined to promote JD's Singles Day event. Singles Day began in the early 1990s" +
                " as a day for people not in relationships to treat themselves, in the spirit of Valentines Day." +
                " The Chinese State Administration for Industry and Commerce (SAIC) has accepted the complaint" +
                " and warned retailers \"not to use malicious marketing methods to engage in competition\"" +
                " ahead of the event, according to the Xinhua news agency. A recent change in legislation bans online" +
                " retailers limiting promotional activity by their merchants on other platforms." +
                " Last year, Alibaba recorded $9.3bn (£5.9bn) sales during the annual event, which it adopted in 2009.");
        article1.setRibbon("★★★★★");


        Article article2 = new Article();
        article2.setTitle("Anonymous posts Ku Klux Klan alleged sympathisers list");
        article2.setImage("../img/news/anonimus.jpg");
        article2.setFirstParagraph("The hackers' collective Anonymous has shared details of hundreds of alleged" +
                " sympathisers of the white supremacist Ku Klux Klan (KKK) on the internet.");
        article2.setBody("Anonymous said the data was \"a form of resistance\" against racial violence." +
                " The KKK last year threatened to use \"deadly force\" against those protesting over the killing" +
                " of a black youth in Ferguson, Missouri. A list of alleged KKK members published earlier in" +
                " the week appears to have been fake. That list had incorrectly outed several US politicians" +
                " as KKK members and was quickly followed by a denial from Anonymous's official Twitter account." +
                " 'All sorts of errors' Thursday's list appears to detail social media profiles of people who had" +
                " joined or \"liked\" KKK-related groups on Facebook and Google+. Many of the profiles featured racist" +
                " imagery and slogans. Anonymous said it had collected the names over the course of the last year," +
                " using a variety of ways, from \"interviewing expert sources\" and \"digital espionage\"" +
                " to obtaining publicly-available information. The group said those on the list included official" +
                " members of various KKK groups \"as well as their closest associates (most are also in other" +
                " extremist hate groups)\"). Some were listed with their alleged aliases.");
        article2.setRibbon("★★");

        Article article3 = new Article();
        article3.setTitle("Greenpeace loses Indian registration");
        article3.setImage("../img/news/greenpeace.jpg");
        article3.setFirstParagraph("Greenpeace says its charitable registration to operate in India has been revoked.");
        article3.setBody("The environmental campaign group says that the decision effectively shuts it down in India." +
                " The government of Narendra Modi has previously accused Greenpeace of flouting tax laws and having" +
                " an anti-development agenda. The pressure group has been working in India for 14 years and employs" +
                " more than 300 people. The BBC's correspondent in Delhi, Justin Rowlatt, says Mr Modi's" +
                " government has been accused of a major crackdown on NGOs and charitable groups ever since he came" +
                " to power in 2014. Greenpeace says it plans to challenge this latest decision. It follows a ruling" +
                " that the organisation could not raise money abroad - which was itself successfully challenged." +
                " Interim Executive Director Vinuta Gopal said in a statement: \"We are confident that we are on strong" +
                " legal ground. We have faith in the legal process and are confident of overcoming this order.\"");
        article3.setRibbon("★★★★");

        articles.add(article1);
        articles.add(article2);
        articles.add(article3);

    }

    public synchronized static NewsSingletone getInstance() {
        if (instance == null) {
            instance = new NewsSingletone();
        }
        return instance;

    }

    public synchronized List<Article> getArticles() {
        return articles;
    }

}
