package com.bigwis.model;

/**
 * Created by Administrator on 2017/4/13.
 */
public class ResultData {
    private String articleCd;
    private String articleTitle;
    private String userLogin;
    private String topicCd;
    private String topicTitle;

    public ResultData() {
    }

    public ResultData(Article article, TopicWords topicWords, String userLogin){
        this.articleCd = article.getCd();
        this.articleTitle = article.getTitle();
        this.topicCd = topicWords.getCd();
        this.topicTitle = topicWords.getTopic_title();
        this.userLogin = userLogin;
    }

    public String getArticleCd() {
        return articleCd;
    }

    public void setArticleCd(String articleCd) {
        this.articleCd = articleCd;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getTopicCd() {
        return topicCd;
    }

    public void setTopicCd(String topicCd) {
        this.topicCd = topicCd;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    @Override
    public String toString() {
        return "ResultData{" +
                "articleCd='" + articleCd + '\'' +
                ", articleTitle='" + articleTitle + '\'' +
                ", userLogin='" + userLogin + '\'' +
                ", topicCd='" + topicCd + '\'' +
                ", topicTitle='" + topicTitle + '\'' +
                '}';
    }
}
