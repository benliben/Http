package com.android.benben.http;

/**
 * Created by tangjunjie on 2016/6/13.
 */
public class UserInfo {
    private long id; // ID
    private String user_name; // 用户名
    private String user_account = "";// 用户登录名
    private String password = ""; // 密码
    private int type; // 类型
    private String org_name; // 隶属的公司
    private long parent_id; // 上司的ID
    private String role_name; // 角色
    private String token;
    private int index;
    String role_code;
    String mobile = "";
    int[] menus;
    int[] for_remove_menus;
    boolean online;
    long parent_user_id;
    String parent_user_name;
    int staff_state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    public long getParent_id() {
        return parent_id;
    }

    public void setParent_id(long parent_id) {
        this.parent_id = parent_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getRole_code() {
        return role_code;
    }

    public void setRole_code(String role_code) {
        this.role_code = role_code;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int[] getMenus() {
        return menus;
    }

    public void setMenus(int[] menus) {
        this.menus = menus;
    }

    public int[] getFor_remove_menus() {
        return for_remove_menus;
    }

    public void setFor_remove_menus(int[] for_remove_menus) {
        this.for_remove_menus = for_remove_menus;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public long getParent_user_id() {
        return parent_user_id;
    }

    public void setParent_user_id(long parent_user_id) {
        this.parent_user_id = parent_user_id;
    }

    public String getParent_user_name() {
        return parent_user_name;
    }

    public void setParent_user_name(String parent_user_name) {
        this.parent_user_name = parent_user_name;
    }

    public int getStaff_state() {
        return staff_state;
    }

    public void setStaff_state(int staff_state) {
        this.staff_state = staff_state;
    }
}
