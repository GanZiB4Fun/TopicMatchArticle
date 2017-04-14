package com.bigwis.mapper.mysql;

import com.bigwis.model.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户文章Mapper
 * Created by GanZiB on 2017/4/11.
 */
@Mapper
public interface ArticleMapper {

    /**
     * 根据用户登陆Id 获取其文章列表
     * @param user_login
     * @return
     */
    List<Article> getArticles(String user_login);
}
