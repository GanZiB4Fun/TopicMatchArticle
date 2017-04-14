package com.bigwis.task;

import com.bigwis.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 调度任务 每隔一个小时从采集的话题数据中获取当日的最新话题
 * Created by GanZiB on 2017/4/12.
 */
@Service
public class GetNewTopicWordsTask {

    @Autowired
    private TopicService topicService;

    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();


    /**
     * 初始化调度服务
     */
    @PostConstruct
    public void init() {

//        long delayTime =60 * 60 * 1000L; // 每小时调度一次
        long delayTime =60 * 1000L; // 每小时调度一次
        // 以相对固定时间执行调度（等上一个任务执行完成后，再延迟指定的时间）
        executor.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                startTask();
            }
        }, 0, delayTime, TimeUnit.MILLISECONDS);
    }

    /**
     * 新增话题数据
     */
    public void startTask(){
        topicService.getNewTopics();
    }

}
