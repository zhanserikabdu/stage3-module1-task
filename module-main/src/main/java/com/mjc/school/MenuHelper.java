package com.mjc.school;

import com.mjc.school.controller.NewsController;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.exceptions.ServiceErrorCode;
import com.mjc.school.service.exceptions.ValidatorException;
import java.io.PrintStream;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MenuHelper {
    public MenuHelper() {
    }

    public void printMainMenu() {
        System.out.println("Enter the number of operation:");
        Operations[] var1 = Operations.values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            Operations operation = var1[var3];
            System.out.println(operation.getOperationWithNumber());
        }

    }

    public void getNews(NewsController newsController) {
        System.out.println(Operations.GET_ALL_NEWS.getOperation());
        List var10000 = newsController.readAll();
        PrintStream var10001 = System.out;
        Objects.requireNonNull(var10001);
        var10000.forEach(var10001::println);
    }

    public void getNewsById(NewsController newsController, Scanner keyboard) {
        System.out.println(Operations.GET_NEWS_BY_ID.getOperation());
        System.out.println("Enter news id:");
        System.out.println(newsController.readById(this.getKeyboardNumber("News Id", keyboard)));
    }

    public void createNews(NewsController newsController, Scanner keyboard) {
        NewsDtoRequest dtoRequest = null;
        boolean isValid = false;

        while(!isValid) {
            try {
                System.out.println(Operations.CREATE_NEWS.getOperation());
                System.out.println("Enter news title:");
                String title = keyboard.nextLine();
                System.out.println("Enter news content:");
                String content = keyboard.nextLine();
                System.out.println("Enter author id:");
                Long authorId = this.getKeyboardNumber("Author Id", keyboard);
                dtoRequest = new NewsDtoRequest((Long)null, title, content, authorId);
                isValid = true;
            } catch (Exception var8) {
                System.out.println(var8.getMessage());
            }
        }

        System.out.println(newsController.create(dtoRequest));
    }

    public void updateNews(NewsController newsController, Scanner keyboard) {
        NewsDtoRequest dtoRequest = null;
        boolean isValid = false;

        while(!isValid) {
            try {
                System.out.println(Operations.UPDATE_NEWS.getOperation());
                System.out.println("Enter news id:");
                Long newsId = this.getKeyboardNumber("News Id", keyboard);
                System.out.println("Enter news title:");
                String title = keyboard.nextLine();
                System.out.println("Enter news content:");
                String content = keyboard.nextLine();
                System.out.println("Enter author id:");
                Long authorId = this.getKeyboardNumber("Author Id", keyboard);
                dtoRequest = new NewsDtoRequest(newsId, title, content, authorId);
                isValid = true;
            } catch (Exception var9) {
                System.out.println(var9.getMessage());
            }
        }

        System.out.println(newsController.update(dtoRequest));
    }

    public void deleteNews(NewsController newsController, Scanner keyboard) {
        System.out.println(Operations.REMOVE_NEWS_BY_ID.getOperation());
        System.out.println("Enter news id:");
        System.out.println(newsController.deleteById(this.getKeyboardNumber("News Id", keyboard)));
    }

    private long getKeyboardNumber(String params, Scanner keyboard) {
        try {
            long enter = keyboard.nextLong();
            keyboard.nextLine();
            return enter;
        } catch (Exception var6) {
            keyboard.nextLine();
            throw new ValidatorException(String.format(ServiceErrorCode.VALIDATE_INT_VALUE.getMessage(), params));
        }
    }
}