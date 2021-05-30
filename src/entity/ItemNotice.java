package entity;

public class ItemNotice {
    private Notice notice;
    private String sendername;

    public ItemNotice() {
    }

    public ItemNotice(Notice notice, String sendername) {
        this.notice = notice;
        this.sendername = sendername;
    }

    public Notice getNotice() {
        return notice;
    }

    public void setNotice(Notice notice) {
        this.notice = notice;
    }

    public String getSendername() {
        return sendername;
    }

    public void setSendername(String sendername) {
        this.sendername = sendername;
    }
}
