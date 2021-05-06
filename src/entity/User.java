package entity;

public class User {
    private Integer id;
    private String name;
    private String account;
    private String password;
    private String icon;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public User() {
    }

    public User(String name) {
        this.name = name;
        this.account = null;
        this.password = null;
    }
    public User(String name, String account) {
        this.name = name;
        this.account = account;
        this.password = null;

    }

    public User(String name, String account, String password) {
        this.name = name;
        this.account = account;
        this.password = password;

    }


    public User(String name, String account, String password,String icon) {
        this.name = name;
        this.account = account;
        this.password = password;

        this.icon = icon;
    }

    public User(Integer id, String name, String account, String password, String icon) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.password = password;
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}

