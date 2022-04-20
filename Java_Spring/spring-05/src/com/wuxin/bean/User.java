package com.wuxin.bean;

import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Author: wuxin001
 * @Date: 2022/04/20/10:06
 * @Description:
 */
@Component(value = "user")
public class User {
    private int userid;
    private String username;

    public User(int userid, String username) {
        this.userid = userid;
        this.username = username;
    }

    public User() {
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return userid == user.userid && Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, username);
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                '}';
    }
}
