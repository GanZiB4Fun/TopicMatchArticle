package com.bigwis.mapper.postgresql;

import com.bigwis.model.Topic;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 话题Mapper
 * Created by GanZiB on 2017/4/11.
 */
@Mapper
public interface TopicMapper {

    /**
     * 获取最新的话题
     * @param dateMap
     * @return
     */
    List<Topic> getNewTopics(Map<String,Object> dateMap);

}
