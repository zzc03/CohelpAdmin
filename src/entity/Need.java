package entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Need implements Serializable {
     Integer applyid;
     Integer applyuserid;
     String username;
     String needtitle;
     String needtext;
     String needtime;
     Integer needreward;
     String applystate;
     Integer solveuserid;
     String solvename;
     String solovetime;
     String solveview;

    public Need() {
    }

    public Need(Integer applyid, Integer applyuserid, String needtitle, String needtext, String needtime, String applystate, Integer solveuserid, String solovetime, String solveview) {
        this.applyid = applyid;
        this.applyuserid = applyuserid;
        this.needtitle = needtitle;
        this.needtext = needtext;
        this.needtime = needtime;
        this.applystate = applystate;
        this.solveuserid = solveuserid;
        this.solovetime = solovetime;
        this.solveview = solveview;
    }

    public Need(Integer applyid, Integer applyuserid, String needtitle, String needtext, String needtime, Integer needreward, String applystate, Integer solveuserid, String solovetime, String solveview) {
        this.applyid = applyid;
        this.applyuserid = applyuserid;
        this.needtitle = needtitle;
        this.needtext = needtext;
        this.needtime = needtime;
        this.needreward = needreward;
        this.applystate = applystate;
        this.solveuserid = solveuserid;
        this.solovetime = solovetime;
        this.solveview = solveview;
    }

    public Need(Integer applyid, Integer applyuserid, String username, String needtitle, String needtext, String needtime, Integer needreward, String applystate, Integer solveuserid, String solovetime, String solveview) {
        this.applyid = applyid;
        this.applyuserid = applyuserid;
        this.username = username;
        this.needtitle = needtitle;
        this.needtext = needtext;
        this.needtime = needtime;
        this.needreward = needreward;
        this.applystate = applystate;
        this.solveuserid = solveuserid;
        this.solovetime = solovetime;
        this.solveview = solveview;
    }

    public Need(Integer applyid, Integer applyuserid, String username, String needtitle, String needtext, String needtime, Integer needreward, String applystate, Integer solveuserid, String solvename, String solovetime, String solveview) {
        this.applyid = applyid;
        this.applyuserid = applyuserid;
        this.username = username;
        this.needtitle = needtitle;
        this.needtext = needtext;
        this.needtime = needtime;
        this.needreward = needreward;
        this.applystate = applystate;
        this.solveuserid = solveuserid;
        this.solvename = solvename;
        this.solovetime = solovetime;
        this.solveview = solveview;
    }

    public Integer getApplyid() {
        return applyid;
    }

    public void setApplyid(Integer applyid) {
        this.applyid = applyid;
    }

    public Integer getApplyuserid() {
        return applyuserid;
    }

    public void setApplyuserid(Integer applyuserid) {
        this.applyuserid = applyuserid;
    }

    public String getNeedtitle() {
        return needtitle;
    }

    public void setNeedtitle(String needtitle) {
        this.needtitle = needtitle;
    }

    public String getNeedtext() {
        return needtext;
    }

    public void setNeedtext(String needtext) {
        this.needtext = needtext;
    }

    public String getNeedtime() {
        return needtime;
    }

    public void setNeedtime(String needtime) {
        this.needtime = needtime;
    }

    public String getApplystate() {
        return applystate;
    }

    public void setApplystate(String applystate) {
        this.applystate = applystate;
    }

    public Integer getSolveuserid() {
        return solveuserid;
    }

    public void setSolveuserid(Integer solveuserid) {
        this.solveuserid = solveuserid;
    }

    public String getSolovetime() {
        return solovetime;
    }

    public void setSolovetime(String solovetime) {
        this.solovetime = solovetime;
    }

    public String getSolveview() {
        return solveview;
    }

    public void setSolveview(String solveview) {
        this.solveview = solveview;
    }

    public Integer getNeedreward() {
        return needreward;
    }

    public void setNeedreward(Integer needreward) {
        this.needreward = needreward;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSolvename() {
        return solvename;
    }

    public void setSolvename(String solvename) {
        this.solvename = solvename;
    }

    @Override
    public String toString() {
        return "Need{" +
                "applyid=" + applyid +
                ", applyuserid=" + applyuserid +
                ", username='" + username + '\'' +
                ", needtitle='" + needtitle + '\'' +
                ", needtext='" + needtext + '\'' +
                ", needtime='" + needtime + '\'' +
                ", needreward=" + needreward +
                ", applystate='" + applystate + '\'' +
                ", solveuserid=" + solveuserid +
                ", solovetime='" + solovetime + '\'' +
                ", solveview='" + solveview + '\'' +
                '}';
    }

    public static Need toObject(Map<String, Object> map) {
        Need need = new Need();
        need.setApplyid((Integer) map.get("applyid"));
        need.setApplyuserid((Integer) map.get("applyuserid"));
        need.setNeedtitle((String) map.get("needtitle"));
        need.setNeedtext((String) map.get("needtext"));
        need.setNeedtime((String) map.get("needtime"));
        need.setApplystate((String) map.get("applystate"));
        need.setSolveuserid((Integer) map.get("solveuserid"));
        need.setSolovetime((String) map.get("solvetime"));
        need.setSolveview((String) map.get("solveview"));
        need.setNeedreward((Integer)map.get("needreward"));
        need.setUsername((String)map.get("user_name"));

        return need;
    }

    public static List<Need> toObject(List<Map<String, Object>> lists){
        List<Need> userInfos = new ArrayList<Need>();
        for (Map<String, Object> map : lists) {
            Need userInfo =  Need.toObject(map);
            if (userInfo != null) {
                userInfos.add(userInfo);
            }
        }
        return userInfos;
    }

}
