package Spider;

import Bean.Newscontent;
import Bean.Newscover;
import Dao.NewsContentDao;
import Dao.NewscoverDao;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by
 *
 * @author GaolengYan
 * @date 2017/12/19
 */

public class Spider {
    private static File newsCoverDir = new File("F:\\Tomcat 8.5\\webapps\\ThereIsNothing\\173Img");
    private static File newsContentDir = new File("F:\\Tomcat 8.5\\webapps\\ThereIsNothing\\173Img\\content");
    /**
     * newsSpider
     * 作用：找178ACG网站的新闻
     * 2018.1.8
     */
    private Pattern p = Pattern.compile("[\\\\/:*?\"<>|]");
    public void newsSpider() {
        List<Newscover> list = new ArrayList<>();
        try {
            NewscoverDao newscoverDao = new NewscoverDao();
            String url = "http://acg.178.com/";
            Document document = Jsoup.connect(url).get();
            Newscover news;
            //获得封面图片
            Elements element = document.select("#j-imgtextlist").select("li");
            //获得封面和标题
            for (Element e : element) {
                //新闻内容地址
                String contentSrc = url + e.select(".textbox").select("a").attr("href");
                if (newscoverDao.findBySrc(contentSrc)!=null){
                    break;
                }
                //获取封面图片src并保存到本地
                String imgSrc = e.select("a").select("img").attr("data-src");
                //新闻标题
                String newsTitle = e.select("a").select("img").attr("alt");
                if (fileNameIsVaild(newsTitle)){
                    newsTitle = newsTitle.replaceAll(String.valueOf(p),"");
                }
                downLoadImg(imgSrc, newsTitle,true);
                imgSrc = "173Img/" + newsTitle + "Cover.jpg";
                //担当编辑
                String author = e.select(".labelbox").text();
                //日期
                String data = e.select(".labelbox").select(".time").attr("data-time");
                //新闻内容

                news = new Newscover(contentSrc, newsTitle, imgSrc, author, data);
                list.add(news);
            }
            newscoverDao.add(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * newsSpider
     * 作用：找178ACG网站的新闻内容
     * 2018.1.12
     */
    public void newsContentSpider(String url,String newsTitle){
        NewsContentDao newsContentDao = new NewsContentDao();
        Newscontent newscontent = newsContentDao.findBySrc(url);
        if (newscontent != null){
            return;
        }
        String content = null;
        String src;
        try {
            Document document = Jsoup.connect(url).get();
            Elements element = document.select(".article").select(".bd").select("p").select("img");

            int i = 0;
            for (Element e:element){
               src = e.attr("src");
               downLoadImg(src, newsTitle,false);
               e.attr("src","173Img/content/"+newsTitle+"/"+i+".jpg");
               i++;
            }
            content = document.select(".article").select(".bd").select("p").toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        newsContentDao.add(new Newscontent(url, content));

    }


    private void downLoadImg(String url, String newsTitle, Boolean isCover) {
        try {
            File newsContentImgDir = new File(newsContentDir+"\\"+newsTitle);
            if (!newsCoverDir.exists()){
                newsCoverDir.mkdir();
                newsContentDir.mkdir();
                newsContentImgDir.mkdir();
            }
            if (!newsContentDir.exists()){
                newsContentDir.mkdir();
                newsContentImgDir.mkdir();
            }
            if (!new File(newsContentDir+newsTitle).exists()){
                newsContentImgDir.mkdir();
            }
            URL imgUrl = new URL(url);
            File file;
            //拼接图片文件名
            if (isCover){
                file = new File(newsCoverDir, newsTitle + "Cover.jpg");
            }else {
                int i = 0;
                file = new File(newsContentImgDir, i + ".jpg");
                while (file.exists()){
                    i++;
                    file = new File(newsContentImgDir, i + ".jpg");
                }
            }
            if (!file.exists()) {
                //如果图片不存在就写入
                InputStream in = imgUrl.openConnection().getInputStream();
                FileOutputStream out = new FileOutputStream(file);
                int line;
                while ((line = in.read()) != -1) {
                    out.write(line);
                }
                out.close();
                in.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private boolean fileNameIsVaild(String fileName){
        Matcher m = p.matcher(fileName);
        return m.find();
    }

}
