package ru.almazovcentre.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    SelenideElement
            infoMessage = $("#vinny_close");

    public MainPage openPage() {
        open("");
        return this;
    }

    public void closeInfoMessage() {
        infoMessage.click();
    }

    public void selectPage(String name) {
        $$(".online-services").find(text(name)).click();
    }
}
