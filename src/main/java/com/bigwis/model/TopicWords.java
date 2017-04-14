package com.bigwis.model;

import java.util.Date;

/**
 * 话题分词
 * Created by GanZiB on 2017/4/12.
 */
public class TopicWords {
    private String topic_title;
    private String topic_arr;
    private Date update_time;
    private String cd;

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    public String getTopic_title() {
        return topic_title;
    }

    public void setTopic_title(String topic_title) {
        this.topic_title = topic_title;
    }

    public String getTopic_arr() {
        return topic_arr;
    }

    public void setTopic_arr(String topic_arr) {
        this.topic_arr = topic_arr;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "TopicWords{" +
                "topic_title='" + topic_title + '\'' +
                ", topic_arr='" + topic_arr + '\'' +
                ", update_time='" + update_time + '\'' +
                '}';
    }
}
