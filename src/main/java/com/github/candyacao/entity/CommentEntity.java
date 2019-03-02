package com.github.candyacao.entity;

import java.util.Date;

public class CommentEntity {
    private String id;
    private Date createDate;
    private String content;
    private UserEntity user;
    private String postID;

    public CommentEntity() {}

    public CommentEntity(String id, Date createDate, String content, UserEntity user, String postID) {
        this.id = id;
        this.createDate = createDate;
        this.content = content;
        this.user = user;
        this.postID = postID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    @Override
    public String toString() {
        return "CommentEntity{" +
                "id='" + id + '\'' +
                ", createDate=" + createDate +
                ", content='" + content + '\'' +
                ", user=" + user +
                ", postID='" + postID + '\'' +
                '}';
    }
}
