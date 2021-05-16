package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NeedPub {
    private Integer needId;
    private String title;
    private String text;
    private String time;
    private String state;
    private Integer reward;
    private Integer userid;
    private String username;
    private Integer ismultiple;

    public NeedPub() {
    }

    public NeedPub(Integer needId, String title, String text, String time, String state, Integer reward, Integer userid, Integer ismultiple) {
        this.needId = needId;
        this.title = title;
        this.text = text;
        this.time = time;
        this.state = state;
        this.reward = reward;
        this.userid = userid;
        this.ismultiple = ismultiple;
    }

    public NeedPub(Integer needId, String title, String text, String time, String state, Integer reward, Integer userid, String username, Integer ismultiple) {
        this.needId = needId;
        this.title = title;
        this.text = text;
        this.time = time;
        this.state = state;
        this.reward = reward;
        this.userid = userid;
        this.username = username;
        this.ismultiple = ismultiple;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public NeedPub(Integer needId) {
        this.needId = needId;
    }

    public Integer getNeedId() {
        return needId;
    }

    public void setNeedId(Integer needId) {
        this.needId = needId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getReward() {
        return reward;
    }

    public void setReward(Integer reward) {
        this.reward = reward;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getIsmultiple() {
        return ismultiple;
    }

    public void setIsmultiple(Integer ismultiple) {
        this.ismultiple = ismultiple;
    }

    @Override
    public String toString() {
        return "NeedPub{" +
                "needId=" + needId +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", time='" + time + '\'' +
                ", state='" + state + '\'' +
                ", reward=" + reward +
                ", userid=" + userid +
                ", ismultiple=" + ismultiple +
                '}';
    }
    public static NeedPub toObject(Map<String, Object> map) {
        NeedPub need = new NeedPub();
        need.setNeedId((Integer)map.get("need_id"));
        need.setTitle((String)map.get("need_title"));
        need.setText((String)map.get("need_text"));
        need.setTime((String)map.get("need_time"));
        need.setState((String)map.get("need_state"));
        need.setReward((Integer)map.get("need_reward"));
        need.setUserid((Integer)map.get("need_user_id"));
        need.setUsername((String)map.get("user_name"));
        need.setIsmultiple((Integer)map.get("need_ismultiple"));
        return need;
    }

    public static List<NeedPub> toObject(List<Map<String, Object>> lists){
        List<NeedPub> userInfos = new ArrayList<NeedPub>();
        for (Map<String, Object> map : lists) {
            NeedPub userInfo =  NeedPub.toObject(map);
            if (userInfo != null) {
                userInfos.add(userInfo);
            }
        }
        return userInfos;
    }

}
