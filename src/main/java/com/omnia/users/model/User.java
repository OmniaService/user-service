package com.omnia.users.model;

import com.omnia.users.model.entities.UserEntity;

public class User extends BaseModel<User> {

    private String username;
    private String password;
    private String nickname;
    private String role;

    public User() {
    }

    public User(String username, String password, String nickname, String role) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public User setRole(String role) {
        this.role = role;
        return this;
    }

    public UserEntity convertToEntity(){
        return new UserEntity()
                .setNickname(getNickname())
                .setPassword(getPassword())
                .setUsername(getUsername())
                .setRole(getRole())
                .setId(getId());
    }

    @Override
    public String toString(){
        return String.format("ID: [%s] username: [%s] password: [%s] nickname: [%s]", getId() != null ? getId().toString() : "null",getUsername(),getPassword(),getNickname());
    }

}
