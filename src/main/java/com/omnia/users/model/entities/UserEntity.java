package com.omnia.users.model.entities;

import com.omnia.users.model.User;

import javax.persistence.Entity;

@Entity
public class UserEntity extends BaseEntity<UserEntity> {

    private String username;
    private String password;
    private String nickname;

    public UserEntity() {
    }

    public UserEntity(String username, String password, String nickname) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public UserEntity setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public User convertToDTO(){
        return new User()
                .setNickname(getNickname())
                .setPassword(getPassword())
                .setUsername(getUsername())
                .setId(getId());
    }

}
