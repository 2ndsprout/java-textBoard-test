package org.example.domain.article.comment;

public class Comment {
    private String content;
    private String contentRegDate;

    public Comment () {

    }
    public Comment (String content, String contentRegDate) {
        this.content = content;
        this.contentRegDate = contentRegDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentRegDate() {
        return contentRegDate;
    }

    public void setContentRegDate(String contentRegDate) {
        this.contentRegDate = contentRegDate;
    }
}
