package com.bigwis.model;

import java.util.Date;

/**
 * 话题
 * Created by GanZiB on 2017/4/11.
 */
public class Topic {
    private String title;
    private Date data_time;
    private String cd;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getData_time() {
        return data_time;
    }

    public void setData_time(Date data_time) {
        this.data_time = data_time;
    }

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "title='" + title + '\'' +
                ", data_time=" + data_time +
                ", cd='" + cd + '\'' +
                '}';
    }
}
