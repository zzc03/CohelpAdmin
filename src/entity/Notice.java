package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Notice {
    private Integer id;
    private Integer type;
    private Integer sendid;
    private String sendname;
    private Integer receiverid;
    private Integer isread;
    private String title;
    private String text;
    private String time;
    public Notice() {
    }

    public Notice(Integer id, Integer type, Integer sendid, Integer receiverid, Integer isread, String title, String text, String time) {
        this.id = id;
        this.type = type;
        this.sendid = sendid;
        this.receiverid = receiverid;
        this.isread = isread;
        this.title = title;
        this.text = text;
        this.time = time;
    }

    public Notice(Integer id, Integer type, Integer sendid, String sendname, Integer receiverid, Integer isread, String title, String text, String time) {
        this.id = id;
        this.type = type;
        this.sendid = sendid;
        this.sendname = sendname;
        this.receiverid = receiverid;
        this.isread = isread;
        this.title = title;
        this.text = text;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSendid() {
        return sendid;
    }

    public void setSendid(Integer sendid) {
        this.sendid = sendid;
    }

    public Integer getReceiverid() {
        return receiverid;
    }

    public void setReceiverid(Integer receiverid) {
        this.receiverid = receiverid;
    }

    public Integer getIsread() {
        return isread;
    }

    public void setIsread(Integer isread) {
        this.isread = isread;
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

    public String getSendname() {
        return sendname;
    }

    public void setSendname(String sendname) {
        this.sendname = sendname;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public static Notice toObject(Map<String, Object> map) {
        Notice notice=new Notice();
        notice.setId((Integer)map.get("message_id"));
        notice.setType((Integer)map.get("message_type"));
        notice.setSendid((Integer)map.get("send_id"));
        notice.setReceiverid((Integer)map.get("receive_id"));
        notice.setIsread((Integer)map.get("is_read"));
        notice.setTitle((String)map.get("title"));
        notice.setText((String)map.get("text"));
        notice.setTime((String)map.get("time"));
        notice.setSendname((String)map.get("user_name"));
        return notice;
    }

    public static List<Notice> toObject(List<Map<String, Object>> lists){
        List<Notice> userInfos = new ArrayList<Notice>();
        for (Map<String, Object> map : lists) {
            Notice userInfo =  Notice.toObject(map);
            if (userInfo != null) {
                userInfos.add(userInfo);
            }
        }
        return userInfos;
    }
}
