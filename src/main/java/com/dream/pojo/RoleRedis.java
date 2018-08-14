package com.dream.pojo;

import java.io.Serializable;

/**
 * 使用Redis保存对象，对象要可序列化，需要实现Serializable接口
 */
public class RoleRedis implements Serializable{
    private Integer id;
    private String roleName;
    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "RoleRedis{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
