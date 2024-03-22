package org.example.view;

import org.example.domain.article.Article;
import org.example.domain.article.comment.Comment;

import java.util.ArrayList;

public class ArticleView {

    public void printArticle (ArrayList<Article> article) {
        for (int i = 0; i < article.size(); i++) {
            Article target = article.get(i);

            System.out.println("번호 : " + target.getId());
            System.out.println("제목 : " + target.getTitle());
            System.out.println("등록일자 : " + target.getRegDate());
            System.out.println("=================================");
        }
    }
    public void printArticleDetail (Article article) {

        article.increaseHit();
        System.out.println("번호 : " + article.getId());
        System.out.println("제목 : " + article.getTitle());
        System.out.println("내용 : " + article.getBody());
        System.out.println("조회수 : " + article.getHit());
        if (article.getThumbUp() > 0) {
            System.out.println("추천수 : " + article.getThumbUp());
        }
        System.out.println("등록일자 : " + article.getRegDate());
        System.out.println("=================================");
        if (article.getComments() != null && !article.getComments().isEmpty()) {
            System.out.println("===============댓글==============");
            for (Comment comment : article.getComments()) {
                System.out.println("댓글 내용 : " + comment.getContent());
                System.out.println("댓글 작성일 : " + comment.getContentRegDate());
                System.out.println("=================================");
            }
        }
    }
}
