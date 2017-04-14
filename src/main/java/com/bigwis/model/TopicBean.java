package com.bigwis.model;

/**
 * Created by Administrator on 2017/4/14.
 */
public class TopicBean {
    /**
     * cd : 83f15f2eb67930401d463f4a1af5d83f3b608c1f
     * title : #谢娜拜托了冰箱#
     * publisher : 腾讯视频拜托了冰箱
     * summary : 谢娜已参与录制拜托了冰箱第三季第一期录制、该节目预计4月12日20:00上线播出。 ​​​
     * source : d.weibo.com
     * source_url : http://weibo.com/p/10080870d6f555b17aa429ae60d0805e8a11f2?from=faxian_huati&mod=mfenlei
     * category : 040007
     * cover_img_url : http://ww4.sinaimg.cn/thumb180/98ebae42jw1fd1rf74fd9j20e80e7dhn.jpg
     * rank : 42
     * read_value : 27730000
     * like_value : 0
     * index_value : 0
     * data_time : 1487979679652
     * update_time : 1492012734292
     * score : 1.0
     */

    private String cd;
    private String title;
    private String publisher;
    private String summary;
    private String source;
    private String source_url;
    private String category;
    private String cover_img_url;
    private int rank;
    private int read_value;
    private int like_value;
    private int index_value;
    private long data_time;
    private long update_time;
    private double score;

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title.replace("#","");
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource_url() {
        return source_url;
    }

    public void setSource_url(String source_url) {
        this.source_url = source_url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCover_img_url() {
        return cover_img_url;
    }

    public void setCover_img_url(String cover_img_url) {
        this.cover_img_url = cover_img_url;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRead_value() {
        return read_value;
    }

    public void setRead_value(int read_value) {
        this.read_value = read_value;
    }

    public int getLike_value() {
        return like_value;
    }

    public void setLike_value(int like_value) {
        this.like_value = like_value;
    }

    public int getIndex_value() {
        return index_value;
    }

    public void setIndex_value(int index_value) {
        this.index_value = index_value;
    }

    public long getData_time() {
        return data_time;
    }

    public void setData_time(long data_time) {
        this.data_time = data_time;
    }

    public long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(long update_time) {
        this.update_time = update_time;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}