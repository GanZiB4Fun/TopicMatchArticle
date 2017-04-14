package com.bigwis.service.serviceImpl;

import com.bigwis.model.*;
import com.bigwis.service.MatchService;
import com.bigwis.service.TopicService;
import com.bigwis.service.TopicWordsService;
import com.bigwis.similarity.Cosine;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 处理文章与话题匹配的处理
 * Created by  on 2017/4/13.
 */
@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private TopicService topicService;

    /**
     * 根据传入的文章数据进行匹配
     *
     * @param articleList
     */
    @Override
    public ResultData dispose(List<Article> articleList) {
        //获取今日话题列表
        List<TopicBean> topicBeans = topicService.getNewTopicsFromApi();
        ResultData resultData = new ResultData();
        Map<Object, Similarity> simMap = new HashedMap();
        for (int i = 0; i < articleList.size(); i++) {
            Double similarity = 0.0;
            Double similarityFlag = 0.4 ;
            //simMap是Key为 文章List的位标 为一个具有匹配值 Artitle TopicWords的对象
            for (int j = 0; j < topicBeans.size(); j++) {
                similarity = new Cosine(topicBeans.get(j).getTitle(), articleList.get(i).getTags()).getConsin();
                //判断话题与文章是否匹配 TODO: 匹配规则：当“话题与文章匹配值”≥ C （C的值由实验所得）时，则判定为文章与话题相匹配。待测试
                if (similarity > similarityFlag) {
                    similarityFlag = similarity;
                    Similarity similarityData = new Similarity(articleList.get(i), topicBeans.get(j), similarity);
                    simMap.put(i, similarityData);
                } else {
                    similarity = new Cosine(topicBeans.get(j).getTitle(), articleList.get(i).getTitle()).getConsin();
                    if (similarity > similarityFlag) {
                        similarityFlag = similarity;
                        Similarity similarityData = new Similarity(articleList.get(i), topicBeans.get(j), similarity);
                        simMap.put(i, similarityData);
                    } else {
                        similarity = new Cosine(topicBeans.get(j).getTitle(), articleList.get(i).getContents()).getConsin();
                        if (similarity > similarityFlag) {
                            similarityFlag = similarity;
                            Similarity similarityData = new Similarity(articleList.get(i), topicBeans.get(j), similarity);
                            simMap.put(i, similarityData);
                        }
                    }
                }
            }
        }
        if(simMap.size()!=0){
            Integer articleNum = this.compareSimilarity(simMap);
            Similarity similarity = simMap.get(articleNum);
            resultData.setArticleCd(similarity.getArticle().getCd());
            resultData.setArticleTitle(similarity.getArticle().getTitle());
            resultData.setTopicCd(similarity.getTopicBean().getCd());
            resultData.setTopicTitle(similarity.getTopicBean().getTitle());
            resultData.setUserLogin(similarity.getArticle().getUser_login());
        }else {
            //数据相似度过低返回null
            resultData = null;
        }
        return resultData;
    }

    /**
     * 计算Map中的最大值
     * @param map
     * @return
     */
    @Override
    public Integer compareSimilarity(Map<Object, Similarity> map) {
        Double keySim = 0.0;
        Integer valueSim = 0;
        for (Object key : map.keySet()) {
            Similarity similarity = map.get(key);
            if (similarity.getSimilarity() > keySim) {
                keySim = similarity.getSimilarity();
                valueSim = Integer.valueOf(key.toString()) ;
            }
        }
        return valueSim;
    }
}
