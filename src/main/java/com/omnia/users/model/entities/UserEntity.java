package com.omnia.users.model.entities;

import com.omnia.users.model.User;

import javax.persistence.Entity;

@Entity
public class UserEntity extends BaseEntity<UserEntity> {

    private String username;
    private String password;
    private String nickname;
    private String role;

    public UserEntity() {
    }

    public UserEntity(String username, String password, String nickname, String role) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public UserEntity setRole(String role) {
        this.role = role;
        return this;
    }

    public User convertToDTO(){
        return new User()
                .setNickname(getNickname())
                .setPassword(getPassword())
                .setUsername(getUsername())
                .setRole(getRole())
                .setId(getId());
    }

    @Override
    public String toString(){
        return String.format("ID: [%s] username: [%s] password: [%s] nickname: [%s]", getId().toString(),getUsername(),getPassword(),getNickname());
    }

}
