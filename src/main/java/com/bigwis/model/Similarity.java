package com.bigwis.model;

/**
 * Created by Administrator on 2017/4/13.
 */
public class Similarity {
    private Article article;
    private TopicBean topicBean;
    private Double similarity;

    public Similarity(Article article, TopicBean topicBean, Double similarity) {
        this.article = article;
        this.topicBean = topicBean;
        this.similarity = similarity;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public TopicBean getTopicBean() {
        return topicBean;
    }

    public void setTopicBean(TopicBean topicBean) {
        this.topicBean = topicBean;
    }

    public Double getSimilarity() {
        return similarity;
    }

    public void setSimilarity(Double similarity) {
        this.similarity = similarity;
    }
}
