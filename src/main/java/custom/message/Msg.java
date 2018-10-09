package custom.message;

import com.entites.MyObject;

/**
 * Created by huyoucheng on 2018/10/9.
 */
public class Msg extends BaseMsg {
    private Object content;

    public Msg() {
    }

    public Msg(Object content) {
        this.content = content;
    }

    public Msg(String touser, String msgtype, Object content) {
        super(touser, msgtype);
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
