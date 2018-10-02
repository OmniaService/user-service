package com.omnia.users.model;

import com.omnia.users.model.entities.UserEntity;

public class User extends BaseModel<User> {

    private String username;
    private String password;
    private String nickname;

    public User() {
    }

    public User(String username, String password, String nickname) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public User setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public UserEntity convertToEntity(){
        return new UserEntity()
                .setNickname(getNickname())
                .setPassword(getPassword())
                .setUsername(getUsername())
                .setId(getId());
    }
}
