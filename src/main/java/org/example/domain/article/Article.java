package org.example.domain.article;

import org.example.domain.article.comment.Comment;

import java.util.ArrayList;

public class Article {
    int id;
    String title;
    String body;
    int hit;
    String regDate;
    int thumbUp;

    public int getThumbUp() {
        return thumbUp;
    }

    public void setThumbUp(int thumbUp) {
        this.thumbUp = thumbUp;
    }

    ArrayList<Comment> comments;
    public void addComment (String content, String contentRegDate) {

        comments.add(new Comment(content,contentRegDate));
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public Article () {

    }
    public Article (int id, String title, String body, int hit, int thumbUp, String regDate) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.hit = hit;
        this.regDate =regDate;
        this.thumbUp = thumbUp;
        this.comments = new ArrayList<>();
    }
    public void increaseThumbUp () {
        thumbUp++;
    }
    public void increaseHit () {
        hit++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }
}
