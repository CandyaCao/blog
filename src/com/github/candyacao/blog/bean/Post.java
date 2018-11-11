package com.github.candyacao.blog.bean;

public class Post {
	private long id;
	private String title;
	private long author_id;
	private String content;
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Post(long id, String title, long author_id, String content) {
		super();
		this.id = id;
		this.title = title;
		this.author_id = author_id;
		this.content = content;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(long author_id) {
		this.author_id = author_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", author_id=" + author_id + ", content=" + content + "]";
	}
		
}
