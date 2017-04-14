package com.bigwis.mapper.mysql;

import com.bigwis.model.TopicWords;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

/**
 * 话题分词
 * Created by GanZiB on 2017/4/12.
 */
@Mapper
public interface TopicWordsMapper {

    /**
     * 插入新的话题分词数据
     * @param topicWords
     * @return
     */
    Integer insertNewTopicWords(TopicWords topicWords);

    /**
     * 删除3天之前的话题
     * @param beforeYesterday
     * @return
     */
    Integer deleteOldTopicWords(Date beforeYesterday);

    /**
     * 获取今日热门话题分词数据
     * @return
     */
    List<TopicWords> getTopicWordsList(Date date);
}
