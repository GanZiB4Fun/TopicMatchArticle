package com.bigwis.service;

import com.bigwis.model.Article;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 文章Service
 * Created by GanZiB on 2017/4/11.
 */
public interface ArticleService {
    /**
     * 根据用户登陆Id 获取用户文章列表
     * @param user_login
     * @return
     */
    List<Article> getArticles(String user_login);
}
