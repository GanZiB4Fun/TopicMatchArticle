package com.bigwis.task;

import com.bigwis.model.TopicWords;
import com.bigwis.service.TopicService;
import com.bigwis.service.TopicWordsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2017/4/12.
 */
@Component
public class DeleteOldTopicWordsTask {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TopicWordsService topicWordsService;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * 删除过时话题数据
     */
    @Scheduled(cron = "0 0 2 0/3 * ?")//每隔三天 凌晨两点
    public void startTask(){
        Integer topicNum = topicWordsService.deleteOldTopicWords();
        logger.info("删除"+topicNum+"条数据");
    }

}
