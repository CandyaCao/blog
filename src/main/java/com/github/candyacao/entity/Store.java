package com.github.candyacao.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 收藏功能
 */
public class Store implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String userID;
    private String postID;
    private Date date;

    public Store() {}

    public Store(String userID, String postID) {
        this.userID = userID;
        this.postID = postID;
    }

    public Store(String id, String userID, String postID, Date date) {
        this.id = id;
        this.userID = userID;
        this.postID = postID;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id='" + id + '\'' +
                ", userID='" + userID + '\'' +
                ", postID='" + postID + '\'' +
                ", date=" + date +
                '}';
    }
}
