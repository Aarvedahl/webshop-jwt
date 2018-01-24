package io.github.aarvedahl.dto;

public class Userdto {

    private int userid;
    private String username;
    private String password;
    private boolean enabled;

    public Userdto(int userid, String username, String password, boolean enabled) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public Userdto() { }

    public int getUserid() { return userid; }

    public String getUsername() { return username; }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isEnabled() { return enabled; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }
}
