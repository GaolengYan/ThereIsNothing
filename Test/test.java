import Spider.Spider;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by
 *
 * @author GaolengYan
 * @date 2017/12/19
 */

public class test {
    /**
     * 测试目标：newsSpider
     * 作用：找178ACG网站的新闻
     * 2018.1.1
     */
    @Test
    public void newsSpiderTest() {
        Spider spider = new Spider();
        spider.newsSpider();
    }

    @Test
    public void testRegex() {
        Pattern p = Pattern.compile("[\\\\/:*?\"<>|]");
        Matcher m = p.matcher("原来他们都长这样？日本历史人物真人与二次元形象对比Σ( °△°|||)Cover.jpg");
        String s = "原来他们都长这样？日本历史人物真人与二次元形象对比Σ( °△°|||)";
        String regex = "[\\\\/:*?\"<>|]";
        System.out.println(m.find());

    }
    @Test
    public void newsContentTest(){
        String url = "http://acg.178.com/201801/309742611014.html";
        String newsTitle = "123";
        Spider spider = new Spider();
    }

}
