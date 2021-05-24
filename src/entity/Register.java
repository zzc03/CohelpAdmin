package entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

public class Register {
    private Integer applyid;
    private String account;
    private String password;
    private String name;
    private String stuid;
    private String icon;
    private String state;
    private Integer solverid;
    private String solvetime;
    private String solveview;
    private String solvetext;
    private File img;
    public Register() {
    }

    public Register(Integer applyid, String account, String password, String name, String stuid, String icon, Integer solverid, String solvetime, String solveview, String solvetext) {
        this.applyid = applyid;
        this.account = account;
        this.password = password;
        this.name = name;
        this.stuid = stuid;
        this.icon = icon;
        this.solverid = solverid;
        this.solvetime = solvetime;
        this.solveview = solveview;
        this.solvetext = solvetext;
    }

    public Register(Integer applyid, String account, String password, String name, String stuid, String icon, String state, Integer solverid, String solvetime, String solveview, String solvetext) {
        this.applyid = applyid;
        this.account = account;
        this.password = password;
        this.name = name;
        this.stuid = stuid;
        this.icon = icon;
        this.state = state;
        this.solverid = solverid;
        this.solvetime = solvetime;
        this.solveview = solveview;
        this.solvetext = solvetext;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getApplyid() {
        return applyid;
    }

    public void setApplyid(Integer applyid) {
        this.applyid = applyid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
        if(icon!=null)
        {
            Base64.Decoder decoder=Base64.getDecoder();
            try{
                byte[] bytes=decoder.decode(icon.getBytes());
                ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(bytes);
                BufferedImage bufferedImage= ImageIO.read(byteArrayInputStream);
                File file=new File("E:\\0001.jpg");
                ImageIO.write(bufferedImage,"jpg",file);
            }catch (Exception e)
            {
                e.printStackTrace();;
            }finally {
            }
        }


    }

    public Integer getSolverid() {
        return solverid;
    }

    public void setSolverid(Integer solverid) {
        this.solverid = solverid;
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

    public String getSolvetext() {
        return solvetext;
    }

    public void setSolvetext(String solvetext) {
        this.solvetext = solvetext;
    }
    public static Register toObject(Map<String, Object> map) {
        Register need = new Register();
        need.setApplyid((Integer)map.get("applyid"));
        need.setAccount((String)map.get("account"));
        need.setPassword((String)map.get("password"));
        need.setName((String)map.get("name"));
        need.setStuid((String)map.get("stuid"));
        need.setIcon((String)map.get("icon"));
        need.setState((String)map.get("state"));
        need.setSolverid((Integer)map.get("solverid"));
        need.setSolvetime((String)map.get("solvetime"));
        need.setSolveview((String)map.get("solveview"));
        need.setSolvetext((String)map.get("solvetext"));
        return need;
    }

    public static List<Register> toObject(List<Map<String, Object>> lists){
        List<Register> userInfos = new ArrayList<Register>();
        for (Map<String, Object> map : lists) {
            Register userInfo =  Register.toObject(map);
            if (userInfo != null) {
                userInfos.add(userInfo);
            }
        }
        return userInfos;
    }

}
