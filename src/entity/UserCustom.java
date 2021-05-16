package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserCustom {
    private Integer userId;
    private String name;
    private String account;
    private String password;
    private String description;
    private Integer money;
    private String icon;
    private Integer isvalid;
    public UserCustom() {
    }

    public UserCustom(Integer userId, String name, String account, String password, String description, Integer money, String icon) {
        this.userId = userId;
        this.name = name;
        this.account = account;
        this.password = password;
        this.description = description;
        this.money = money;
        this.icon = icon;
    }

    public UserCustom(Integer userId, String name, String account, String password, String description, Integer money, String icon, Integer isvalid) {
        this.userId = userId;
        this.name = name;
        this.account = account;
        this.password = password;
        this.description = description;
        this.money = money;
        this.icon = icon;
        this.isvalid = isvalid;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Integer isvalid) {
        this.isvalid = isvalid;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "UserCustom{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", description='" + description + '\'' +
                ", money=" + money +
                ", icon='" + icon + '\'' +
                '}';
    }
    public static UserCustom toObject(Map<String, Object> map) {
        UserCustom userCustom = new UserCustom();
        userCustom.setUserId((Integer)map.get("user_id"));
        userCustom.setAccount((String)map.get("user_account"));
        userCustom.setPassword((String)map.get("user_password"));
        userCustom.setName((String)map.get("user_name"));
        userCustom.setDescription((String)map.get("user_description"));
        userCustom.setMoney((Integer)map.get("user_money"));
        userCustom.setIcon((String)map.get("user_icon"));
        userCustom.setIsvalid((Integer)map.get("isvalid"));
        return userCustom;
    }

    public static List<UserCustom> toObject(List<Map<String, Object>> lists){
        List<UserCustom> userInfos = new ArrayList<UserCustom>();
        for (Map<String, Object> map : lists) {
            UserCustom userInfo =  UserCustom.toObject(map);
            if (userInfo != null) {
                userInfos.add(userInfo);
            }
        }
        return userInfos;
    }
}
