package action;

import Dao.NewscoverDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

/**
 * Created by
 *
 * @author GaolengYan
 * @date 2018/1/16
 */
public class NewsLoadAction extends ActionSupport implements SessionAware {
    private Map<String, Object> session;

    @Override
    public String execute(){
        NewscoverDao newscoverDao = new NewscoverDao();
        List list = newscoverDao.findAll();
        session.put("News", list);
        System.out.println("+++++++++action++++++");
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}
