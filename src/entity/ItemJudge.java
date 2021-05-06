package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemJudge {
    private Integer id;
    private Integer applyuserid;
    private String applyusername;
    private String needtitle;
    private String needtext;
    private String needtime;
    private Integer needreward;
    private String applystate;
    private Integer solveuserid;
    private String solvetime;
    private String solveview;
    private String solveviewtext;
    public static ItemJudge toObject(Map<String, Object> map,String username) {
        ItemJudge need = new ItemJudge();
        need.setId((Integer) map.get("zc_id"));
        need.setApplyusername(username);
        need.setNeedtitle((String) map.get("needtitle"));
        need.setNeedtext((String) map.get("needtext"));
        need.setNeedtime((String) map.get("needtime"));
        need.setNeedreward((Integer) map.get("needreward"));
        need.setApplystate((String) map.get("applystate"));
        need.setSolveuserid((Integer) map.get("zc_solveuserid"));
        need.setSolvetime((String) map.get("zc_solvetime"));
        need.setSolveview((String) map.get("zc_solveview"));
        need.setSolveviewtext((String) map.get("zc_solveviewtext"));
        return need;
    }

    public static List<ItemJudge> toObject(List<Map<String, Object>> lists,List<String> names){
        List<ItemJudge> userInfos = new ArrayList<ItemJudge>();
//        for (Map<String, Object> map : lists) {
//            ItemJudge userInfo =  ItemJudge.toObject(map);
//            if (userInfo != null) {
//                userInfos.add(userInfo);
//            }
//        }
        for(int i=0;i<lists.size();i++)
        {
            ItemJudge itemJudge=ItemJudge.toObject(lists.get(i),names.get(i));
            userInfos.add(itemJudge);
        }
        return userInfos;
    }
    public static ItemJudge toObject(Map<String, Object> map) {
        ItemJudge need = new ItemJudge();
        need.setId((Integer) map.get("zc_id"));
        need.setNeedtitle((String) map.get("needtitle"));
        need.setNeedtext((String) map.get("needtext"));
        need.setApplyuserid((Integer) map.get("zc_applyuserid"));
        need.setNeedtime((String) map.get("needtime"));
        need.setNeedreward((Integer) map.get("needreward"));
        need.setApplystate((String) map.get("applystate"));
        need.setSolveuserid((Integer) map.get("zc_solveuserid"));
        need.setSolvetime((String) map.get("zc_solvetime"));
        need.setSolveview((String) map.get("zc_solveview"));
        need.setSolveviewtext((String) map.get("zc_solveviewtext"));
        return need;
    }

    public static List<ItemJudge> toObject(List<Map<String, Object>> lists){
        List<ItemJudge> userInfos = new ArrayList<ItemJudge>();
        for (Map<String, Object> map : lists) {
            ItemJudge userInfo =  ItemJudge.toObject(map);
            if (userInfo != null) {
                userInfos.add(userInfo);
            }
        }
        return userInfos;
    }
    public ItemJudge() {
    }

    public ItemJudge(Integer id, Integer applyuserid, String applyusername, String needtitle, String needtext, String needtime, Integer needreward, String applystate, Integer solveuserid, String solvetime, String solveview, String solveviewtext) {
        this.id = id;
        this.applyuserid = applyuserid;
        this.applyusername = applyusername;
        this.needtitle = needtitle;
        this.needtext = needtext;
        this.needtime = needtime;
        this.needreward = needreward;
        this.applystate = applystate;
        this.solveuserid = solveuserid;
        this.solvetime = solvetime;
        this.solveview = solveview;
        this.solveviewtext = solveviewtext;
    }

    public ItemJudge(String applyusername, String needtitle, String needtext, String needtime, Integer needreward, String applystate, Integer solveuserid, String solvetime, String solveview, String solveviewtext) {
        this.applyusername = applyusername;
        this.needtitle = needtitle;
        this.needtext = needtext;
        this.needtime = needtime;
        this.needreward = needreward;
        this.applystate = applystate;
        this.solveuserid = solveuserid;
        this.solvetime = solvetime;
        this.solveview = solveview;
        this.solveviewtext = solveviewtext;
    }

    public Integer getApplyuserid() {
        return applyuserid;
    }

    public void setApplyuserid(Integer applyuserid) {
        this.applyuserid = applyuserid;
    }

    public ItemJudge(Integer id, String applyusername, String needtitle, String needtext, String needtime, Integer needreward, String applystate, Integer solveuserid, String solvetime, String solveview, String solveviewtext) {
        this.id = id;
        this.applyusername = applyusername;
        this.needtitle = needtitle;
        this.needtext = needtext;
        this.needtime = needtime;
        this.needreward = needreward;
        this.applystate = applystate;
        this.solveuserid = solveuserid;
        this.solvetime = solvetime;
        this.solveview = solveview;
        this.solveviewtext = solveviewtext;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplyusername() {
        return applyusername;
    }

    public void setApplyusername(String applyusername) {
        this.applyusername = applyusername;
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

    public Integer getNeedreward() {
        return needreward;
    }

    public void setNeedreward(Integer needreward) {
        this.needreward = needreward;
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

    public String getSolvetime() {
        return solvetime;
    }

    public void setSolvetime(String solvetime) {
        this.solvetime = solvetime;
    }

    public String getSolveview() {
        return solveview;
    }

    public void setSolveview(String solveview) {
        this.solveview = solveview;
    }

    public String getSolveviewtext() {
        return solveviewtext;
    }

    public void setSolveviewtext(String solveviewtext) {
        this.solveviewtext = solveviewtext;
    }
}
