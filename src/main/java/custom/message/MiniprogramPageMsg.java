package custom.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Created by huyoucheng on 2018/10/9.
 */
public class MiniprogramPageMsg extends BaseMsg {

    private ObjectNode miniprogrampage;

    public ObjectNode getMiniprogrampage() {
        return miniprogrampage;
    }

    public void setMiniprogrampage(ObjectNode miniprogrampage) {
        this.miniprogrampage = miniprogrampage;
    }

    public MiniprogramPageMsg() {
    }

    public MiniprogramPageMsg(ObjectNode miniprogrampage) {
        this.miniprogrampage = miniprogrampage;
        super.setMsgtype("miniprogrampage");
    }

    public MiniprogramPageMsg(String touser, String title,String appid,String pagepath,String thumb_media_id) {
        super(touser, "miniprogrampage");

        ObjectNode node = new ObjectMapper().createObjectNode();
        node.put("title",title);
        node.put("appid",appid);
        node.put("pagepath",pagepath);
        node.put("thumb_media_id",thumb_media_id);

        this.miniprogrampage = node;
    }
}
