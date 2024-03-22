package org.example.domain.article;

import org.example.base.CommonUtil;
import org.example.view.ArticleView;

import java.util.ArrayList;
import java.util.Scanner;

public class ArticleController {
    CommonUtil commonUtil = new CommonUtil();
    ArticleRepository articleRepository = new ArticleRepository();
    ArticleView articleView = new ArticleView();
    Scanner scan = commonUtil.getScan();
    int WRONG_VALUE = -1;
    public void add () {
        System.out.print("게시물 제목을 입력해주세요 : ");
        String title = scan.nextLine();
        System.out.print("게시물 내용을 입력해주세요 : ");
        String body = scan.nextLine();
        System.out.println("=================================");

        articleRepository.saveArticle(title, body);

        System.out.println("게시물이 등록되었습니다.");
        System.out.println("=================================");
    }
    public void list () {

        ArrayList<Article> article = articleRepository.findAll();
        articleView.printArticle(article);
    }
    public void update () {
        System.out.print("수정할 게시물 번호 : ");
        int inputId = getParamAsInt(scan.nextLine(), WRONG_VALUE);
        System.out.println("=================================");
        if(inputId == WRONG_VALUE) {
            return;
        }

        Article article = articleRepository.findArticleById(inputId);

        if (article == null) {
            System.out.println("없는 게시물 번호입니다.");
            System.out.println("=================================");

        }
        else {
            System.out.print("제목 : ");
            String newTitle = scan.nextLine();
            System.out.print("내용 : ");
            String newBody = scan.nextLine();
            System.out.println("=================================");


            articleRepository.updateArticle(article, newTitle, newBody);

            System.out.println(inputId + "번 게시물이 수정되었습니다.");
            System.out.println("=================================");
        }

    }
    public void delete () {
        System.out.print("삭제할 게시물 번호 : ");
        int inputId = getParamAsInt(scan.nextLine(), WRONG_VALUE);
        System.out.println("=================================");
        if(inputId == WRONG_VALUE) {
            return;
        }

        Article article = articleRepository.findArticleById(inputId);

        if (article == null) {
            System.out.println("없는 게시물 번호입니다.");
            System.out.println("=================================");
        }
        else {
            articleRepository.deleteArticle(article);
            System.out.println(inputId + "번 게시물이 삭제되었습니다.");
            System.out.println("=================================");

        }

    }
    public void detail () {
        System.out.print("상세보기 할 게시물 번호를 입력해주세요 : ");
        int inputId = getParamAsInt(scan.nextLine(), WRONG_VALUE);
        System.out.println("=================================");
        if(inputId == WRONG_VALUE) {
            return;
        }

        Article article = articleRepository.findArticleById(inputId);

        if (article == null) {
            System.out.println("존재하지 않는 게시물 번호입니다.");
            System.out.println("=================================");
        }
        else {
            articleView.printArticleDetail(article);
            System.out.println("상세보기 기능을 선택해주세요\n1. 댓글 등록 \n2. 추천 \n3. 수정 \n4. 삭제 \n5. 목록으로");
            int choice = getParamAsInt(scan.nextLine(), WRONG_VALUE);
            if(choice == WRONG_VALUE) {
                return;
            }
            switch (choice) {

                case 1 -> {
                    System.out.print("댓글 내용 : ");
                    String content = scan.nextLine();
                    articleRepository.saveComment(article, content);
                    System.out.println("댓글이 성공적으로 등록되었습니다");
                    System.out.println("=================================");
                }
                case 2 -> {
                    article.increaseThumbUp();
                    System.out.println(inputId + "번 게시물을 추천했습니다.");
                }
                case 3 -> {
                    detailArticleUpdate(article, inputId);
                }
                case 4 -> {
                    detailArticleDelete(article, inputId);
                }
                case 5 -> {
                    System.out.println("목록으로 돌아갑니다.");
                    System.out.println("=================================");
                }
                default -> {
                    System.out.println("잘못된 명령어 입니다.");
                }
            }


        }
    }
    public void detailArticleDelete (Article article, int inputId) {
        articleRepository.deleteArticle(article);
        System.out.println(inputId + "번 게시물이 삭제되었습니다.");
        System.out.println("=================================");
    }
    public void detailArticleUpdate (Article article, int inputId) {
        System.out.print("제목 : ");
        String newTitle = scan.nextLine();
        System.out.print("내용 : ");
        String newBody = scan.nextLine();
        System.out.println("=================================");


        articleRepository.updateArticle(article, newTitle, newBody);

        System.out.println(inputId + "번 게시물이 수정되었습니다.");
        System.out.println("=================================");
    }
    public void search () {
        System.out.print("검색 키워드를 입력해주세요 : ");
        String keyword = scan.nextLine();

        ArrayList<Article> searchList = articleRepository.findArticleByKeyword(keyword);

        if (searchList.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
        }

        else {
            articleView.printArticle(searchList);
        }

    }
    public int getParamAsInt (String param, int defaultValue) {
        try {
            return Integer.parseInt(param);
        }
        catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요.");
            System.out.println("=================================");

            return defaultValue;
        }
    }
}
