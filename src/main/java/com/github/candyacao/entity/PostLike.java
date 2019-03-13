package com.github.candyacao.entity;

import com.github.candyacao.enums.LikedStatusEnum;

import java.io.Serializable;

public class PostLike implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String userID;
    private String postID;
    private Integer status = LikedStatusEnum.UNLIKE.getCode();

    public PostLike() {
    }

    public PostLike(String id, String userID, String postID) {
        this.id = id;
        this.userID = userID;
        this.postID = postID;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
