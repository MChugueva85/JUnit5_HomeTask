package ru.almazovcentre.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    SelenideElement
    infoMessage = $("#vinny_close");

    public MainPage openPage(){
        open("http://www.almazovcentre.ru/");
        return this;
    }

    public MainPage closeInfoMessage(){
        infoMessage.click();
        return this;
    }
}
