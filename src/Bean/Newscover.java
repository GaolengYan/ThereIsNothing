package Bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Created by
 *
 * @author GaolengYan
 * @date 2018/1/9
 */
@Entity
public class Newscover {
    private String newsTitle;
    private String newsCoverImg;
    private String newsAuthor;
    private String newsUpdateTime;
    private String newsContext;

    public Newscover() {
    }

    public Newscover(String newsContext, String newsTitle, String newsCoverImg, String newsAuthor, String newsUpdateTime) {
        this.newsContext = newsContext;
        this.newsCoverImg = newsCoverImg;
        this.newsTitle = newsTitle;
        this.newsAuthor = newsAuthor;
        this.newsUpdateTime = newsUpdateTime;
    }

    @Basic
    @Column(name = "newsTitle", nullable = false, length = 50)
    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    @Basic
    @Column(name = "newsCoverImg", nullable = false, length = 100)
    public String getNewsCoverImg() {
        return newsCoverImg;
    }

    public void setNewsCoverImg(String newsCoverImg) {
        this.newsCoverImg = newsCoverImg;
    }

    @Basic
    @Column(name = "newsAuthor", nullable = false, length = 50)
    public String getNewsAuthor() {
        return newsAuthor;
    }

    public void setNewsAuthor(String newsAuthor) {
        this.newsAuthor = newsAuthor;
    }

    @Basic
    @Column(name = "newsUpdateTime", nullable = true, length = 50)
    public String getNewsUpdateTime() {
        return newsUpdateTime;
    }

    public void setNewsUpdateTime(String newsUpdateTime) {
        this.newsUpdateTime = newsUpdateTime;
    }

    @Id
    @Column(name = "newsContext", nullable = false, length = 50)
    public String getNewsContext() {
        return newsContext;
    }

    public void setNewsContext(String newsContext) {
        this.newsContext = newsContext;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Newscover newscover = (Newscover) o;
        return newsContext.equals(newscover.newsContext) &&
                Objects.equals(newsTitle, newscover.newsTitle) &&
                Objects.equals(newsCoverImg, newscover.newsCoverImg) &&
                Objects.equals(newsAuthor, newscover.newsAuthor) &&
                Objects.equals(newsUpdateTime, newscover.newsUpdateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(newsTitle, newsCoverImg, newsAuthor, newsUpdateTime, newsContext);
    }
}
