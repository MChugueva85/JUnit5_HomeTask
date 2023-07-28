package ru.almazovcentre.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static ru.almazovcentre.tests.MainPageTest.mainPage;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "http://www.almazovcentre.ru/";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";

    }
    @BeforeAll
    static void informationTableClose() {
        mainPage.openPage()
                .closeInfoMessage();
    }

    @BeforeEach
    void openPage() {
        mainPage.openPage();
    }
}
