package ru.almazovcentre.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class testBase {
    @BeforeAll

    static void beforeAll() {
//        Configuration.baseUrl = "http://www.almazovcentre.ru/";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;

    }
}
