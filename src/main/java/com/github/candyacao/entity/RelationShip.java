package com.github.candyacao.entity;

import java.io.Serializable;

/**
 * 关注功能
 */
public class RelationShip implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    // 作者
    private String fromUserID;
    // 粉丝
    private String toUserID;

    public RelationShip() {
    }

    public RelationShip(String fromUserID, String toUserID) {
        this.fromUserID = fromUserID;
        this.toUserID = toUserID;
    }

    public RelationShip(String id, String fromUserID, String toUserID) {
        this.id = id;
        this.fromUserID = fromUserID;
        this.toUserID = toUserID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFromUserID() {
        return fromUserID;
    }

    public void setFromUserID(String fromUserID) {
        this.fromUserID = fromUserID;
    }

    public String getToUserID() {
        return toUserID;
    }

    public void setToUserID(String toUserID) {
        this.toUserID = toUserID;
    }

    @Override
    public String toString() {
        return "RelationShip{" +
                "id='" + id + '\'' +
                ", fromUserID='" + fromUserID + '\'' +
                ", toUserID='" + toUserID + '\'' +
                '}';
    }
}
