package com.bigwis.service.serviceImpl;

import com.bigwis.mapper.mysql.TopicWordsMapper;
import com.bigwis.model.TopicWords;
import com.bigwis.service.TopicWordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 话题分词操作
 * Created by GanZiB on 2017/4/12.
 */
@Service
public class TopicWordsServiceImpl implements TopicWordsService {

    @Autowired
    private TopicWordsMapper topicWordsMapper;

    @Override
    public Integer insertNewTopicWords(TopicWords topicWords) {
        return topicWordsMapper.insertNewTopicWords(topicWords);
    }

    /**
     * 删除三天之前的数据
     * @return
     */
    @Override
    public Integer deleteOldTopicWords() {
        //设置所获取的话题的时间范围
        Date beforeYesterday = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(beforeYesterday);
        calendar.add(Calendar.DATE,-3);
        Date before = Calendar.getInstance().getTime();

        return topicWordsMapper.deleteOldTopicWords(before);
    }

    /**
     * 获取今日热门话题分词数据
     * @return
     */
    @Override
    public List<TopicWords> getTopicWordsList() {
        //设置一个时间为当前时间前天的日期Date 作为热词搜索条件
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,-2);
        date = calendar.getTime();
        return topicWordsMapper.getTopicWordsList(date);
    }
}
