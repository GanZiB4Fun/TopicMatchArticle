package com.bigwis.service;

import com.bigwis.model.Article;
import com.bigwis.model.ResultData;
import com.bigwis.model.Similarity;

import java.util.List;
import java.util.Map;

/**
 * 处理文章与话题匹配的处理接口
 * Created by GanZiB on 2017/4/13.
 */
public interface MatchService {

    /**
     * 根据传入的文章数据进行匹配
     * @param articleList
     */
    ResultData dispose(List<Article> articleList);

    /**
     * 计算Map中的最大值
     * @param map
     * @return
     */
    Integer compareSimilarity(Map<Object,Similarity> map);
}
