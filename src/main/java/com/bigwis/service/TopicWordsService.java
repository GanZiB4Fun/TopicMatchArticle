package com.bigwis.service;

import com.bigwis.model.TopicWords;

import java.util.List;

/**
 * 话题分词操作
 * Created by GanZiB on 2017/4/12.
 */
public interface TopicWordsService {

    /**
     * 插入新的话题分词数据
     * @param topicWords
     * @return
     */
    Integer insertNewTopicWords(TopicWords topicWords);

    /**
     * 删除三天之前的数据
     * @return
     */
    Integer deleteOldTopicWords();

    /**
     * 获取今日热门话题分词数据
     * @return
     */
    List<TopicWords> getTopicWordsList();
}
