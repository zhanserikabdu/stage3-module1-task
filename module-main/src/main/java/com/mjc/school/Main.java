package com.mjc.school;

import com.mjc.school.controller.implementation.NewsController;

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        MenuHelper helper = new MenuHelper();
        NewsController newsController = new NewsController();

        while(true) {
            while(true) {
                try {
                    helper.printMainMenu();
                    switch (keyboard.nextLine()) {
                        case "1":
                            helper.getNews(newsController);
                            break;
                        case "2":
                            helper.getNewsById(newsController, keyboard);
                            break;
                        case "3":
                            helper.createNews(newsController, keyboard);
                            break;
                        case "4":
                            helper.updateNews(newsController, keyboard);
                            break;
                        case "5":
                            helper.deleteNews(newsController, keyboard);
                            break;
                        case "0":
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Command not found.");
                    }
                } catch (RuntimeException var7) {
                    System.out.println(var7.getMessage());
                }
            }
        }
    }
}
