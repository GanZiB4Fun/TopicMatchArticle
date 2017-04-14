package com.bigwis.service;

import com.bigwis.model.Topic;
import com.bigwis.model.TopicBean;

import java.util.List;

/**
 * 话题服务
 * Created by GanZiB on 2017/4/11.
 */
public interface TopicService {

    void getNewTopics();
    List<TopicBean> getNewTopicsFromApi();
}
