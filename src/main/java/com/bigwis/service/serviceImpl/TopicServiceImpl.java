package com.bigwis.service.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.bigwis.mapper.mysql.TopicWordsMapper;
import com.bigwis.mapper.postgresql.TopicMapper;
import com.bigwis.model.Topic;
import com.bigwis.model.TopicBean;
import com.bigwis.model.TopicJsonData;
import com.bigwis.model.TopicWords;
import com.bigwis.service.TopicService;
import com.bigwis.util.GetTimestamp;
import com.bigwis.util.WebConstant;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.downloader.HttpClientDownloader;

import java.sql.Timestamp;
import java.util.*;

/**
 * 话题Service
 * Created by GanZiB on 2017/4/11.
 */
@Service
public class TopicServiceImpl implements TopicService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private static Site site = Site.me().
            setUserAgent(WebConstant.USER_AGENT).
            addHeader("accept", WebConstant.HEADER_ACCEPT).
            addHeader("Accept-Language", WebConstant.ACCEPT_LANGUAGE).setCharset("UTF-8").setSleepTime(3000);

    private static final String API_TOPIC_URL = "http://api.h2.bigwis.com/search/topic";
    private static final String AK = "26bec948f555a5c11988352fd8051468eb78e02c";

    @Autowired
    private TopicMapper topicMapper;
    @Autowired
    private TopicWordsMapper topicWordsMapper;

    /**
     * 获取到采集数据中的最新话题数据 并保存到话题分词库中
     */
    @Override
    public void getNewTopics() {
        Integer flag = 0;
        //设置所获取的话题的时间范围
        Timestamp start = GetTimestamp.changeTime(new Date(), "yyyy-MM-dd 00:00:00.000000", -1);
        Timestamp end = GetTimestamp.changeTime(new Date(), "yyyy-MM-dd HH:mm:ss.SSSSSS", 0);
        Map<String, Object> dateMap = new HashedMap();
        dateMap.put("start", start);
        dateMap.put("end", end);
        //获取到采集数据中的最新话题数据 并保存
        List<Topic> newTopics = topicMapper.getNewTopics(dateMap);
        TopicWords topicWords = new TopicWords();
        if (newTopics.size() > 0) {
            for (Topic topic : newTopics) {
                topicWords.setTopic_title(topic.getTitle());
//                topicWords.setTopic_arr(HanLPTagsUtil.getTags(topic.getTitle()));
                topicWords.setTopic_arr(topic.getTitle().replace("#", ""));
                topicWords.setUpdate_time(new Date());
                topicWords.setCd(topic.getCd());
                try {
                    topicWordsMapper.insertNewTopicWords(topicWords);
                    flag++;
                } catch (DuplicateKeyException e) {
                    logger.info(topic.getTitle() + "已经存在");
                }
            }
        } else {
            logger.info("暂无数据需要更新");
        }
        logger.info("此次共新增了" + flag + "条数据");
    }


    /**
     * 从接口中获取热门话题
     * @return
     */
    @Override
    public List<TopicBean> getNewTopicsFromApi() {
        //获取时间区间 今日此时 到 前天
        Date before = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(before);
        calendar.add(Calendar.DATE, -2);
        before = calendar.getTime();
        String url = API_TOPIC_URL + "?ak=" + AK+"&st="+before.getTime()+"&et="+new Date().getTime();
        Page page = new HttpClientDownloader().download(new Request(url), site.toTask());
        TopicJsonData topicJsonData = JSONObject.parseObject(page.getRawText(),TopicJsonData.class);
        Integer page_size = topicJsonData.getPage_size();
        url = url + "&page_size" + page_size;
        page = new HttpClientDownloader().download(new Request(url), site.toTask());
        topicJsonData = JSONObject.parseObject(page.getRawText(),TopicJsonData.class);
        return topicJsonData.getData();
    }
}
