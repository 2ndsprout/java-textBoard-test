package org.example.domain.article;

import org.example.base.CommonUtil;

import java.util.ArrayList;

public class ArticleRepository {
    CommonUtil commonUtil = new CommonUtil();
    ArrayList<Article> articleList = new ArrayList<>();
    int latestId = 4;

    public ArticleRepository () {
        makeTest();
    }

    public void makeTest () {
        Article a1 = new Article(1, "안녕하세요 반갑습니다. 자바 공부중이에요.", "냉무", 0, 0, commonUtil.getCurrentDateTime());
        Article a2 = new Article(2, "자바 질문좀 할게요~", "냉무", 0, 0, commonUtil.getCurrentDateTime());
        Article a3 = new Article(3, "정처기 따야되나요?", "냉무", 0, 0, commonUtil.getCurrentDateTime());

        articleList.add(a1);
        articleList.add(a2);
        articleList.add(a3);
    }
    public void saveComment (Article article, String comment) {
        article.addComment(comment, commonUtil.getCurrentDateTime());
    }
    public void deleteArticle (Article article) {
        articleList.remove(article);
    }

    public void updateArticle (Article article, String newTitle, String newBody) {
        article.setTitle(newTitle);
        article.setBody(newBody);
    }

    public void saveArticle (String title, String body) {
        Article article = new Article(latestId, title, body, 0, 0, commonUtil.getCurrentDateTime());
        articleList.add(article);
        latestId++;
    }
    public ArrayList<Article> findAll () {
        return articleList;
    }

    public ArrayList<Article> findArticleByKeyword (String keyword) {
        ArrayList<Article> searchList = new ArrayList<>();
        for (int i = 0; i < articleList.size(); i++) {
            Article article = articleList.get(i);
            if (article.getTitle().contains(keyword)) {
                searchList.add(article);
            }
        }
        return searchList;
    }
    public Article findArticleById (int id) {
        for (int i = 0; i <articleList.size(); i++) {
            Article article = articleList.get(i);

            if(article.getId() == id)
                return article;
        }
        return null;
    }
}
