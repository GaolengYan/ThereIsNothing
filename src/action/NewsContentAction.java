package action;

import Bean.Content;
import Bean.Newscontent;
import Bean.Newscover;
import Dao.NewsContentDao;
import Dao.NewscoverDao;
import Spider.Spider;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created by
 *
 * @author GaolengYan
 * @date 2018/1/16
 */
public class NewsContentAction extends ActionSupport implements SessionAware {
    private Map<String, Object> session;
    private String src;
    private String newsTitle;


    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    @Override
    public String execute() {
        Spider spider = new Spider();
        NewscoverDao newscoverDao = new NewscoverDao();
        NewsContentDao newsContentDao = new NewsContentDao();
        Newscontent newscontent = newsContentDao.findBySrc(src);
        System.out.println(newscontent);
        if (newscontent==null){
            spider.newsContentSpider(src,newsTitle);
        }
        newscontent = newsContentDao.findBySrc(src);
        System.out.println(newscontent);
        String content = newscontent.getContent();
        Newscover newscover = newscoverDao.findBySrc(src);
        Content newsContent = new Content(newsTitle, newscover.getNewsAuthor(),
                newscover.getNewsUpdateTime(), content);
        session.put("newsContent", newsContent);
        return SUCCESS;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }
}
