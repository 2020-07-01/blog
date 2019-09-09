package com.example.blog.service.impl;

import com.example.blog.dao.ArticleDao;
import com.example.blog.entity.Article;
import com.example.blog.errorCode.ErrorCode;
import com.example.blog.errorCode.ErrorCodes;
import com.example.blog.service.ArticleService;
import com.example.blog.support.CategoryObject;
import com.example.blog.support.DateSupport;
import com.example.blog.support.UUIDSupport;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :qiang
 * @date :2019/7/12 下午10:49
 * @description :
 * @other :
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    //创建日志实例
    protected final static Logger log = LoggerFactory.getLogger(ArticleServiceImpl.class.getName());


    @Autowired
    ArticleDao articleDao;

    /*
     * 查询所有的博客信息
     */
    public List<Article> selectAll() {
        List<Article> articleList = articleDao.selectAll();
        log.info("查询所有博客成功");
        return articleList;
    }


    /*
     * 根据id删除博客
     */
    public int deleteBlog(String id) {
        return articleDao.deleteBlog(id);
    }

    //修改博客
    public int updateBlog(Article article) {
        article.setEditDate(DateSupport.getDate());
        //取前40个字符为摘要,否则整个文章为摘要
        if (article.getContent().length() > 40) {
            article.setSummary(article.getContent().substring(0, 40));
        } else {
            article.setSummary(article.getContent());
        }
        Integer row = articleDao.updateBlog(article);

        log.info("修改成功");

        return row;
    }

    //根据id查询博客
    public Article selectById(String id) {
        return articleDao.selectById(id);
    }


    public ErrorCode saveBlog(String articleMessage) {

        //将string转换为静态的JSONObject
        JSONObject object = JSONObject.fromObject(articleMessage);
        //获取与键关联的值
        String cId = object.getString("cId");
        String content = object.getString("content");
        String title = object.getString("title");

        System.out.println(cId + content + title);

        if (cId.equals("")) {
            return ErrorCodes.CODE_012;
        }
        if (title.equals("")) {
            return ErrorCodes.CODE_014;
        }
        if (content.equals("")) {
            return ErrorCodes.CODE_013;
        }

        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setCategory(CategoryObject.category1);
        //设置aId
        article.setaId(UUIDSupport.getUUID());
        //取前40个字符为摘要,否则整个文章为摘要
        if (article.getContent().length() > 40) {
            article.setSummary(article.getContent().substring(0, 40));
        } else {
            article.setSummary(article.getContent());
        }
        //设置创建时间
        article.setCreateDate(DateSupport.getDate());
        int row = articleDao.saveBlog(article);
        log.info("保存成功");
        return ErrorCodes.CODE_000;
    }

    @Override
    public List<Article> search(String key) {
        //获取Article列表
        List<Article> articleList = articleDao.search(key);

        log.info("查询成功");

        return articleList;
    }

    @Override
    public int update(Article article) {

        //设置修改时间
        article.setEditDate(DateSupport.getDate());

        int row = articleDao.updateBlog(article);
        log.info("修改信息成功");
        return row;
    }

    //根据category查询所有的博客
    @Override
    public List<Article> selectAllByCategory(String category) {
        List<Article> articleList = articleDao.selectAllByCategory(category);

        return articleList;
    }


}
