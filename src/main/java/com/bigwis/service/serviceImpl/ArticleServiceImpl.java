package com.bigwis.service.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.bigwis.mapper.mysql.ArticleMapper;
import com.bigwis.model.Article;
import com.bigwis.service.ArticleService;
import com.bigwis.util.WebConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.downloader.HttpClientDownloader;

import java.util.List;

/**
 * 文章Service
 * Created by GanZiB on 2017/4/11.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 获取用户文章列表
     * @param user_login
     * @return
     */
    @Override
    public List<Article> getArticles(String user_login) {
        return articleMapper.getArticles(user_login);
    }

}
