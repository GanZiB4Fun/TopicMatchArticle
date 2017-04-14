package com.bigwis.controller;

import com.bigwis.model.Article;
import com.bigwis.model.ResultData;
import com.bigwis.service.ArticleService;
import com.bigwis.service.MatchService;
import com.bigwis.service.TopicService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

/**
 * WebController Web控制器
 * Created by Administrator on 2017/4/11.
 */
@RestController
@RequestMapping("/matchTopic")
public class ArticleMatchTopicController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private MatchService matchService;
    @Autowired
    private TopicService topicService;
    /**
     * 获取传入的用户名
     * @param user_login
     * @param request
     */
    @RequestMapping(value = "/dispose", method = RequestMethod.GET)
    public Map<String,Object> test(@PathParam("user_login") String user_login, HttpServletRequest request) {
        Map<String,Object> result = new HashedMap();
        //获取用户文章列表
        List<Article> articleList = articleService.getArticles(user_login);
        //将用户文章列表传入匹配处理 并返回结果
        ResultData resultData = matchService.dispose(articleList);
        if(resultData==null){
            result.put("data",null);
            result.put("ret","-1 没有匹配");
            result.put("msg","ERROR");
        }else {
            result.put("data",resultData);
            result.put("ret","0");
            result.put("msg","OK");
        }

        return result;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public Map<String,Object> index() {
       topicService.getNewTopicsFromApi();

        return null;
    }


}
