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
 * @date 2018/1/18
 */
@Entity
public class Newscontent {
    private String newssrc;
    private String content;

    public Newscontent() {
    }

    public Newscontent(String newssrc, String content) {
        this.newssrc = newssrc;
        this.content = content;
    }

    @Id
    @Column(name = "newssrc", nullable = false, length = 50)
    public String getNewssrc() {
        return newssrc;
    }

    public void setNewssrc(String newssrc) {
        this.newssrc = newssrc;
    }

    @Basic
    @Column(name = "content", nullable = false, length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Newscontent that = (Newscontent) o;
        return  Objects.equals(newssrc, that.newssrc) &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {

        return Objects.hash(newssrc, content);
    }
}
