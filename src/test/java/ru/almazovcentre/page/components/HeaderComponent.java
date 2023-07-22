package ru.almazovcentre.page.components;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$$;

public class HeaderComponent {
    public void checkPageHeader(String header){

        $$(".posttitle").should(texts(header));
    }

}
