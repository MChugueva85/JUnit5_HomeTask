package ru.almazovcentre.page.components;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class ResultComponent {
    public void checkLanguage(List<String> expectedButtons){
        $$("#nav a").filter(visible).should(texts(expectedButtons));
    }

    public void checkHeaderOfPage(String name){
        $$(".posttitle").should(texts(name));
    }

    public void checkPageHeader(String header){
        $$(".posttitle").should(texts(header));
    }
}
