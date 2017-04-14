package com.bigwis.model;

/**
 * 文章Model
 * Created by GanZiB on 2017/4/11.
 */
public class Article {
    private String id;
    private String user_login;
    private String title;
    private String tags;
    private String content;
    private String cd;

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getContents() {
        return content;
    }

    public void setContents(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", user_login='" + user_login + '\'' +
                ", title='" + title + '\'' +
                ", tags='" + tags + '\'' +
                ", content='" + content + '\'' +
                ", cd='" + cd + '\'' +
                '}';
    }
}
