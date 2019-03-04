package com.github.candyacao.entity;

import java.util.Date;
import java.util.List;

public class PostEntity {
    private String id;
    private String content;
    private String authorID;
    private String title;
    private String summary;
    // 展示图片的链接
    private String photoLink;
    private Date createDate;
    private List<CommentEntity> comments;
    private List<TagEntity> tags;

    public PostEntity() {
    }

    public PostEntity(String id) {
        this.id = id;
    }

    public PostEntity(String id, String content, String authorID, String title, String summary, String photoLink, Date createDate) {
        this.id = id;
        this.content = content;
        this.authorID = authorID;
        this.title = title;
        this.summary = summary;
        this.photoLink = photoLink;
        this.createDate = createDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }

    public List<TagEntity> getTags() {
        return tags;
    }

    public void setTags(List<TagEntity> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "PostEntity{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", authorID='" + authorID + '\'' +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", photoLink='" + photoLink + '\'' +
                ", createDate=" + createDate +
                ", comments=" + comments +
                '}';
    }
}
